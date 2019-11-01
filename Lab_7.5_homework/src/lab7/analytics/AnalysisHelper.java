/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lab7.entities.Comment;
import lab7.entities.User;

/**
 *
 * @author harshalneelkamal
 */
public class AnalysisHelper {
    // find user with Most Likes
    // TODO
    public void userWithMostLikes(){
        Map<Integer, User> userHashMap = DataStore.getInstance().getUsers();
        
        Map<Integer, Integer> tempUserHashMap = new HashMap<Integer, Integer>();
        
        for(User u : userHashMap.values()){
            for(Comment c : u.getComments()){
                int likes = 0;
                if(tempUserHashMap.containsKey(u.getId())){
                    likes = tempUserHashMap.get(u.getId());
                }
                likes += c.getLikes();
                tempUserHashMap.put(u.getId(), likes);
            }
        }
        int max = 0;
        int maxId = 0;
        for(int id: tempUserHashMap.keySet()){
            if(tempUserHashMap.get(id)>max){
                max = tempUserHashMap.get(id);
                maxId = id;
            }
        }
        
        System.out.println("User With Most Likes:\t" + max + "\t Entire User Object\t" + userHashMap);
        
    }
    
    // find 5 comments which have the most likes
    // TODO
    
    public void topFiveComments(){
        Map<Integer, Comment> commentHashMap = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<Comment>(commentHashMap.values());      
        Collections.sort(commentList, new Comparator<Comment>(){
            @Override
            public int compare(Comment o1, Comment o2){
                return o2.getLikes() - o1.getLikes();
            }
        });
        
        System.out.println("Printing the top five comments");
        
        for(int j = 0; j < commentList.size () && j<5; j++){
            System.out.println(commentList.get(j));
        }
    }
 /*  
    public void lastFiveComments(){
        Map<Integer, Comment> commentHashMap = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<Comment>(commentHashMap.values());      
        Collections.sort(commentList, new Comparator<Comment>(){
            @Override
            public int compare(Comment o1, Comment o2){
                return o1.getLikes() - o2.getLikes();
            }
        });
        
        System.out.println("Printing the last five comments");
        
        for(int j = 0; j < commentList.size () && j<5; j++){
            System.out.println(commentList.get(j));
        }
    }
    
    public void topProactiveUsers(){
        Map<Integer, Comment> commentHashMap = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<Comment>(commentHashMap.values());      
        Collections.sort(commentList, new Comparator<Comment>(){
            @Override
            public int compare(Comment o1, Comment o2){
                return o2.getLikes() - o1.getLikes();
            }
           
        });
        
        System.out.println("Printing the top five proactive users");
        
        for(int j = 0; j < commentList.size () && j<5; j++){
            System.out.println(commentList.get(j));
        }
    }
*/
}
