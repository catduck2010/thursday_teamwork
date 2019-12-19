/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author lihang
 */
public class PasswordUtil {

    private static final String ID = "$31$";
    private static final int SIZE = 128;
    private static int COST = 16;
    private static final String ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final Pattern LAYOUT = Pattern.compile("\\$31\\$(\\d\\d?)\\$(.{43})");
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String hash(char[] passwd, byte[] salt) {
        byte[] dk = pbkdf2(passwd, salt, 1 << COST);
        byte[] hash = new byte[salt.length + dk.length];
        System.arraycopy(salt, 0, hash, 0, salt.length);
        System.arraycopy(dk, 0, hash, salt.length, dk.length);
        Base64.Encoder enc = Base64.getUrlEncoder().withoutPadding();
        return ID + COST + '$' + enc.encodeToString(hash);
    }

    public static String hash(char[] passwd) {
        return hash(passwd, getSalt());
    }

    public static void setCost(int cost) {
        COST = cost;
    }

    public static void setDefaultCost() {
        setCost(16);
    }

    public static byte[] getSalt() {
        byte[] salt = new byte[SIZE / 8];
        RANDOM.nextBytes(salt);
        return salt;
    }

    private static int iterations(int cost) {
        if ((cost & ~0x1F) != 0) {
            throw new IllegalArgumentException("cost: " + cost);
        }
        return 1 << cost;
    }

    public static boolean authenticate(char[] password, String token) {
        Matcher m = LAYOUT.matcher(token);
        if (!m.matches()) {
            throw new IllegalArgumentException("Invalid token format");
        }
        int iterations = iterations(Integer.parseInt(m.group(1)));
        byte[] hash = Base64.getUrlDecoder().decode(m.group(2));
        byte[] salt = Arrays.copyOfRange(hash, 0, SIZE / 8);
        byte[] check = pbkdf2(password, salt, iterations);
        int zero = 0;
        for (int idx = 0; idx < check.length; ++idx) {
            zero |= hash[salt.length + idx] ^ check[idx];
        }
        return zero == 0;
    }

    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations) {
        KeySpec spec = new PBEKeySpec(password, salt, iterations, SIZE);
        try {
            SecretKeyFactory f = SecretKeyFactory.getInstance(ALGORITHM);
            return f.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException ex) {
            throw new IllegalStateException("Missing algorithm: " + ALGORITHM, ex);
        } catch (InvalidKeySpecException ex) {
            throw new IllegalStateException("Invalid SecretKeyFactory", ex);
        }
    }
}
