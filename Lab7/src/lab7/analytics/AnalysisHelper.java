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
    public void getFiveMostLikedComment() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        Collections.sort(commentList, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return o2.getLikes() - o1.getLikes();
            }

        });

        System.out.println("5 most likes comments: ");
        for (int i = 0; i < commentList.size() && i < 5; i++) {
            System.out.println(commentList.get(i));
        }
    }

    // find Average number of likes per comment
    public void getAvgLikeNumPerComment() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        double likes = 0;
        for (Comment c : commentList) {
            likes += c.getLikes();
        }
        likes = likes / commentList.size();

        System.out.println("Average # of Likes Per Comment: " + likes);
    }

    // Find the post with most liked comments.
    public void getPostWithMostLikedComments() {
        Map<Integer, Comment> commentMap = DataStore.getInstance().getComments();
        List<Comment> comments = new ArrayList<>(commentMap.values());
        Collections.sort(comments, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                return Integer.compare(o2.getLikes(), o1.getLikes());
            }
        });
        Comment mlc = comments.get(0);
        Map<Integer, Post> postMap = DataStore.getInstance().getPosts();
        Post post = postMap.get(mlc.getPostId());

        System.out.println("Post w/ Most Liked Comments: " + post);
    }

    // Find the post with most comments
    public void getPostWithMostComments() {
        Map<Integer, Post> postMap = DataStore.getInstance().getPosts();
        List<Post> posts = new ArrayList<>(postMap.values());
        Collections.sort(posts, new Comparator<Post>() {
            @Override
            public int compare(Post o1, Post o2) {
                return Integer.compare(o2.getComments().size(), o1.getComments().size());
            }
        });
        Post pwmc = posts.get(0);

        System.out.println("Post w/ Most Comments (" + pwmc.getComments().size() + "): " + pwmc);
    }

    //Top 5 inactive users based on total posts number
    public void Top5inactiveusersbasedonposts() {
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        Map<Integer, Integer> user = new HashMap<Integer, Integer>();
        List<Post> postList = new ArrayList<>();
        int number = 0;
        for (Post p : posts.values()) {
            postList.add(p);
        }
        Collections.sort(postList, new Comparator<Post>() {
            @Override
            public int compare(Post o1, Post o2) {
                return Integer.compare(o2.getUserId(), o1.getUserId());
            }
        });
        int maxId = postList.get(0).getUserId();
        for (int i = 0; i < maxId; i++) {
            for (Post po : posts.values()) {
                if (po.getUserId() == i) {
                    number = number + 1;
                }
            }
            user.put(i, number);
            number = 0;
        }
        System.out.println("User ID and Post Number(User ID = Post number):");
        System.out.println(user);
        Comparator<Map.Entry<Integer, Integer>> valueComparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        };
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(user.entrySet());
        Collections.sort(list, valueComparator);
        System.out.println("Top 5 inactive users based on posts");
        System.out.println(users.get(list.get(0).getKey()));
        System.out.println(users.get(list.get(1).getKey()));
        System.out.println(users.get(list.get(2).getKey()));
        System.out.println(users.get(list.get(3).getKey()));
        System.out.println(users.get(list.get(4).getKey()));
        System.out.println();
    }

    // Top 5 inactive users overall
    public void fiveinactoverall() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer, Integer> res = new HashMap<Integer, Integer>();
        List<Comment> commentList = new ArrayList<>(comments.values());
        List<Post> postList = new ArrayList<>(posts.values());
        for (Comment c : commentList) {
            if (res.containsKey(c.getUserId())) {
                res.put(c.getUserId(), res.get(c.getUserId()) + 2);
            } else {
                res.put(c.getUserId(), 2);
            }
        }
        for (Post p : postList) {
            if (res.containsKey(p.getUserId())) {
                res.put(p.getUserId(), res.get(p.getUserId()) + 3);
            } else {
                res.put(p.getUserId(), 3);
            }
        }
        for (Comment c : commentList) {
            if (res.containsKey(c.getUserId())) {
                res.put(c.getUserId(), res.get(c.getUserId()) + c.getLikes());
            } else {
                res.put(c.getUserId(), 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(res.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                //so as to get decending list
                return (int) o1.getValue() - (int) o2.getValue();
            }
        });
        System.out.println("Five Most inactive User:(post 3 points, comment 2 points, 1 like 1 point)" + "\nId:" + list.get(0).getKey() + " Score:" + list.get(0).getValue()
                + "\nId:" + list.get(1).getKey() + " Score:" + list.get(1).getValue()
                + "\nId:" + list.get(2).getKey() + " Score:" + list.get(2).getValue()
                + "\nId:" + list.get(3).getKey() + " Score:" + list.get(3).getValue()
                + "\nId:" + list.get(4).getKey() + " Score:" + list.get(4).getValue() + "\n");
    }

    public void lastFiveComments() {
        Map<Integer, Comment> commentHashMap = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<Comment>(commentHashMap.values());
        Collections.sort(commentList, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                return o1.getLikes() - o2.getLikes();
            }
        });

        System.out.println("Printing the last five comments");

        for (int j = 0; j < commentList.size() && j < 5; j++) {
            System.out.println(commentList.get(j));
        }
    }

    public void topProactiveUsers() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer, Integer> res = new HashMap<Integer, Integer>();
        List<Comment> commentList = new ArrayList<>(comments.values());
        List<Post> postList = new ArrayList<>(posts.values());
        for (Comment c : commentList) {
            if (res.containsKey(c.getUserId())) {
                res.put(c.getUserId(), res.get(c.getUserId()) + 2);
            } else {
                res.put(c.getUserId(), 2);
            }
        }
        for (Post p : postList) {
            if (res.containsKey(p.getUserId())) {
                res.put(p.getUserId(), res.get(p.getUserId()) + 3);
            } else {
                res.put(p.getUserId(), 3);
            }
        }
        for (Comment c : commentList) {
            if (res.containsKey(c.getUserId())) {
                res.put(c.getUserId(), res.get(c.getUserId()) + c.getLikes());
            } else {
                res.put(c.getUserId(), 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(res.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                //so as to get decending list
                return (int) o2.getValue() - (int) o1.getValue();
            }
        });

        System.out.println("Five Most proactive User:(post 3 points, comment 2 points, 1 like 1 point)" + "\nId:" + list.get(0).getKey() + " Score:" + list.get(0).getValue()
                + "\nId:" + list.get(1).getKey() + " Score:" + list.get(1).getValue()
                + "\nId:" + list.get(2).getKey() + " Score:" + list.get(2).getValue()
                + "\nId:" + list.get(3).getKey() + " Score:" + list.get(3).getValue()
                + "\nId:" + list.get(4).getKey() + " Score:" + list.get(4).getValue() + "\n");
    }

}
