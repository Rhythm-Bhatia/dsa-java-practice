class Pair{
    String first;
    int second;
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i<wordList.size(); i++){
            set.add(wordList.get(i));
        }
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));

        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            String word = curr.first;
            int step = curr.second;

            if(word.equals(endWord)){
                return step;
            }

            for(int i = 0; i<word.length(); i++){
                char[] replacedCharArray = word.toCharArray();
                for(char ch = 'a'; ch <='z'; ch++){
                    replacedCharArray[i] = ch;

                    String newWord = new String(replacedCharArray);
                    if(set.contains(newWord)){
                        queue.offer(new Pair(newWord, step+1));
                        set.remove(newWord);
                    }
                }
            }
            
        }
    return 0;

    }
}