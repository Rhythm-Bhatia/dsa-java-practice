
class Pair{
    String stringg;
    int lengthh;
    Pair(String stringg,int lengthh){
        this.stringg=stringg;
        this.lengthh=lengthh;
    }
}
class Solution {
    

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)){
            return 0;
        }
        if(beginWord.equals(endWord))return 0;
        Set<String>set=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        Set<String>visited=new HashSet<>();
        Pair first=new Pair(beginWord,1);
        Queue<Pair>q=new LinkedList<>();
        q.add(first);
        while(!q.isEmpty()){
            Pair p=q.poll();
            String s=p.stringg;
            int len=p.lengthh;
            for(int i=0;i<s.length();i++){
                for(char j='a';j<='z';j++){
                    String st=Character.toString(j);
                    String neww=s.substring(0,i)+j+s.substring(i+1,s.length());
                    if(set.contains(neww)&&!visited.contains(neww)){
                        visited.add(neww);
                        q.add(new Pair(neww,len+1));
                        if(neww.equals(endWord)){
                            return len+1;
                        }
                    }
        
                    
                }
            }
            
        }
        return 0;

    }
}