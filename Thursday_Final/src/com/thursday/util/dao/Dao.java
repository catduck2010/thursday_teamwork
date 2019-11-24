package com.thursday.util.dao;

import com.thursday.util.DBInfo;
import java.util.List;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * 对访问数据库统一管理
 *
 * @author yhy
 *
 */
public abstract class Dao {

    private Connection conn;
    private final String db;

    public Dao(String db) {
        this.db = db;
    }

    /**
     * 获得连接
     *
     * @return
     */
    public Connection getConnection() {
        conn = connect(db);
        return conn;
    }

    private Connection connect() {
        Connection conn = null;
        String jdbcURL = "jdbc:mysql://" + DBInfo.IP + ":" + DBInfo.PORT + "/"
                + DBInfo.APARTMENT + "?useUnicode=true&characterEncoding=UTF8";
        String jdbcDriver = "com.mysql.jdbc.Driver";
        try {
            //DbUtils中加载驱动的方法
            DbUtils.loadDriver(jdbcDriver);
            conn = DriverManager.getConnection(jdbcURL,
                    DBInfo.USER, DBInfo.PASSWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private Connection connect(String db) {
        Connection conn = null;
        String jdbcURL = "jdbc:mysql://" + DBInfo.IP + ":" + DBInfo.PORT + "/"
                + db + "?useUnicode=true&characterEncoding=UTF8";
        String jdbcDriver = "com.mysql.jdbc.Driver";
        try {
            //DbUtils中加载驱动的方法
            DbUtils.loadDriver(jdbcDriver);
            conn = DriverManager.getConnection(jdbcURL,
                    DBInfo.USER, DBInfo.PASSWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void disconnect() {
        DbUtils.closeQuietly(conn);
    }

    /**
     * 执行更新的sql语句,插入,修改,删除
     *
     * @param sql
     * @return
     */
    public boolean update(String sql, Object[] params) {
        boolean flag = false;
        try {
            conn = getConnection();
            QueryRunner qRunner = new QueryRunner();
            int i = qRunner.update(conn, sql, params);
            if (i > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return flag;
    }

    /**
     * 查找多个对象
     *
     * @param sql
     * @param theClass
     * @return
     */
    public List query(String sql, Class theClass) {
        List beans = null;
        try {
            conn = getConnection();
            QueryRunner qRunner = new QueryRunner();
            beans = (List) qRunner.query(conn,
                    sql,
                    new BeanListHandler(theClass));
            //BeanListHandler处理了从ResultSet中获取数据，封装对象并存入List集合
            //源码同样需要用到ResultSet
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return beans;
    }

    /**
     * 重载查询多个对象方法
     *
     * @param sql
     * @param theClass
     * @return
     */
    public List query(String sql, Class theClass, Object[] params) {
        List beans = null;
        try {
            conn = getConnection();
            QueryRunner qRunner = new QueryRunner();
            beans = (List) qRunner.query(conn, sql, new BeanListHandler(theClass), params);

            //BeanListHandler处理了从ResultSet中获取数据，封装对象并存入List集合
            //源码同样需要用到ResultSet
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return beans;
    }

    /**
     * 查找对象
     *
     * @param sql
     * @param theClass
     * @return
     */
    public Object get(String sql, Class theClass) {
        Object obj = null;

        try {
            conn = getConnection();
            QueryRunner qRunner = new QueryRunner();
            obj = qRunner.query(conn,
                    sql,
                    new BeanHandler(theClass));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return obj;
    }

    /**
     * 重载查询单对象方法
     *
     * @param sql
     * @param theClass
     * @return
     */
    public Object get(String sql, Class theClass, Object[] params) {
        Object obj = null;
        try {
            conn = getConnection();
            QueryRunner qRunner = new QueryRunner();
            obj = qRunner.query(conn,
                    sql,
                    new BeanHandler(theClass), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return obj;
    }
}



