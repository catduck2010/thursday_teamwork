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
import lab7.entities.Post;
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
       Map<Integer, Comment> comments = DataStore.getInstance().getComments();
       Map<Integer, Post> posts = DataStore.getInstance().getPosts();
       Map<Integer,Integer> res = new HashMap<Integer,Integer>();
       List<Comment> commentList = new ArrayList<>(comments.values());
       List<Post> postList = new ArrayList<>(posts.values());
       for(Comment c: commentList){
           if(res.containsKey(c.getUserId()))
               res.put(c.getUserId(), res.get(c.getUserId())+2);
           else
               res.put(c.getUserId(), 2);
       }
       for(Post p: postList){
           if(res.containsKey(p.getUserId()))
               res.put(p.getUserId(), res.get(p.getUserId())+3);
           else
               res.put(p.getUserId(), 3);
       }
       for(Comment c: commentList){
           if(res.containsKey(c.getUserId()))
               res.put(c.getUserId(), res.get(c.getUserId())+c.getLikes());
           else
               res.put(c.getUserId(), 1);
       }
       List<Map.Entry<Integer,Integer>> list = new ArrayList<>(res.entrySet());
       
       Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>() {
           @Override
           public int compare(Map.Entry o1, Map.Entry o2) {
               //so as to get decending list
               return (int)o2.getValue() - (int)o1.getValue();
           }
       });
        System.out.println("Five Most proactive User:(post 3 points, comment 2 points, 1 like 1 point)"+"\nId:"+list.get(0).getKey()+" Score:"+list.get(0).getValue()
                +"\nId:"+list.get(1).getKey()+" Score:"+list.get(1).getValue()
                +"\nId:"+list.get(2).getKey()+" Score:"+list.get(2).getValue()
                +"\nId:"+list.get(3).getKey()+" Score:"+list.get(3).getValue()
                +"\nId:"+list.get(4).getKey()+" Score:"+list.get(4).getValue()+"\n");
    }
    

}
