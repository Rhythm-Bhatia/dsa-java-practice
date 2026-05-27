class Twitter {
    int timecounter;
    Map<Integer,User>map;

    class User{
        int userId;
        LinkedList<Tweet>list;
        HashSet<Integer>following;
        User(int userId){
            this.userId=userId;
            list=new LinkedList<>();
            following=new HashSet<>();
        }
        void addtweet(Tweet t){
            list.addFirst(t);
        }
        void add(int id){
            following.add(id);
        }
        void remove(int id){
            following.remove(id);
        }

    }
    class Tweet{
        int timer;
        int tweetId;
        Tweet(int timer,int tweetId){
            this.timer=timer;
            this.tweetId=tweetId;
        }
    }
    
    public Twitter() {
        timecounter=0;
        map=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        timecounter++;
        if(!map.containsKey(userId)){
            map.put(userId,new User(userId));
        }
        User user=map.get(userId);
        user.addtweet(new Tweet(timecounter,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer>ans=new ArrayList<>();
        if(!map.containsKey(userId)){
            return ans;
        }
        PriorityQueue<Tweet>pq=new PriorityQueue<>((a,b)->{
            return Integer.compare(b.timer,a.timer);
        });
        User user=map.get(userId);
        int counter=0;
        for(Tweet t:user.list){
            counter++;
            pq.add(t);
            if(counter>10)break;
        }
        for(int element:user.following){
            int count=0;
            for(Tweet l:map.get(element).list){
                count++;
                pq.add(l);
                if(count>10){
                    break;
                }
            }
        }
        int index=0;
        while(!pq.isEmpty()&&index<10){
            ans.add(pq.poll().tweetId);
            index++;
        }
        return ans;

    }
    
    public void follow(int followerId, int followeeId) {
        if(!map.containsKey(followerId)){
            map.put(followerId,new User(followerId));
        }
        if(!map.containsKey(followeeId)){
            map.put(followeeId,new User(followeeId));
        }
        User user=map.get(followerId);
        user.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!map.containsKey(followerId) ||!map.containsKey(followeeId)){
            return;
        }
        User user=map.get(followerId);
        user.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */