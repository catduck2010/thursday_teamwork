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
    public void userWithMostLikes() {
        Map<Integer, Integer> userLikesCount = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();

        for (User user : users.values()) {
            for (Comment c : user.getComments()) {
                int likes = 0;
                if (userLikesCount.containsKey(user.getId())) {
                    likes = userLikesCount.get(user.getId());
                }
                likes += c.getLikes();
                userLikesCount.put(user.getId(), likes);
            }
        }

        int max = 0;
        int maxId = 0;
        for (int id : userLikesCount.keySet()) {
            if (userLikesCount.get(id) > max) {
                max = userLikesCount.get(id);
                maxId = id;
            }
        }

        System.out.println("User with most likes: " + max + "\n"
                + users.get(maxId));
    }

    // find 5 comments which have the most likes
    // TODO
    public void getFiveMostLikedComment(){
        Map<Integer,Comment> comments=DataStore.getInstance().getComments();
        List<Comment> commentList=new ArrayList<>(comments.values());
        Collections.sort(commentList,new Comparator<Comment>(){
            @Override
            public int compare(Comment o1, Comment o2) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return o2.getLikes()-o1.getLikes();
            }
            
        });
        
        System.out.println("5 most likes comments: ");
        for(int i=0;i<commentList.size()&&i<5;i++){
            System.out.println(commentList.get(i));
        }
    }
    
    // find Average number of likes per comment
    public void getAvgLikeNumPerComment(){
        Map<Integer,Comment> comments=DataStore.getInstance().getComments();
        List<Comment> commentList=new ArrayList<>(comments.values());
        double likes=0;
        for(Comment c:commentList){
            likes+=c.getLikes();
        }
        likes=likes/commentList.size();
        
        System.out.println("Average # of Likes Per Comment: "+likes);
    }
    // Find the post with most liked comments.
    public void getPostWithMostLikedComments(){
        Map<Integer,Comment> commentMap=DataStore.getInstance().getComments();
        List<Comment> comments=new ArrayList<>(commentMap.values());
        Collections.sort(comments,new Comparator<Comment>(){
            @Override
            public int compare(Comment o1, Comment o2) {
                return o2.getLikes()-o1.getLikes();
            }
        });
        Comment mlc=comments.get(0);
        Map<Integer,Post> postMap=DataStore.getInstance().getPosts();
        Post post=postMap.get(mlc.getPostId());
        
        System.out.println("Post w/ Most Liked Comments: "+post);
    }
    // Find the post with most comments
    public void getPostWithMostComments(){
        Map<Integer,Post> postMap=DataStore.getInstance().getPosts();
        List<Post> posts=new ArrayList<>(postMap.values());
        Collections.sort(posts, new Comparator<Post>() {
            @Override
            public int compare(Post o1, Post o2) {
                return o2.getComments().size()-o1.getComments().size();
            }
        });
        Post pwmc=posts.get(0);
        
        System.out.println("Post w/ Most Comments ("+pwmc.getComments().size()+"): "+pwmc);
    }
        
}
