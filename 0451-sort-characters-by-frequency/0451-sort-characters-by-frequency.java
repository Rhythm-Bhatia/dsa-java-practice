// class Solution {
//     public String frequencySort(String s) {
//         char arr[]=s.toCharArray();
        
//         Map<Character,Integer>map=new HashMap<>();
//         for(int i=0;i<arr.length;i++){
//             map.put(arr[i],map.getOrDefault(arr[i],0)+1);

//         }
//         PriorityQueue<Character>heap=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));

//         heap.addAll(map.keySet());
//         StringBuilder sb=new StringBuilder();
//         while(!heap.isEmpty()){
//             char c=heap.poll();
//             for(int i=0;i<map.get(c);i++){
//                 sb.append(c);
//             }
//         }
//         return sb.toString();
//     }
// }
class Solution {
    class Pair{
        char value;
        int freq;
        Pair(char value,int freq){
            this.value=value;
            this.freq=freq;
        }

    }

    public String frequencySort(String s) {
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Pair>heap=new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1,Pair p2){
                int freqCompare=Integer.compare(p2.freq,p1.freq);
                if(freqCompare!=0)return freqCompare;
                return Character.compare(p1.value,p2.value);
            }
        });
        for(Map.Entry<Character,Integer>entry:map.entrySet()){
            heap.offer(new Pair(entry.getKey(),entry.getValue()));
        }
        StringBuilder sb=new StringBuilder();
        int n=heap.size();
        for(int i=0;i<n;i++){
            Pair p=heap.poll();
            for(int j=0;j<p.freq;j++){

                sb.append(p.value);
            }
            
        }
        return sb.toString();
    }
}