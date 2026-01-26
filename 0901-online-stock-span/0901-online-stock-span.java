class StockSpanner {
    
    Stack<List<Integer>>stack;
    
    public StockSpanner() {
        stack=new Stack<>();
        
    }
    
    public int next(int price) {
        List<Integer>list=new ArrayList<>();
        list.add(price);
        list.add(1);
        // stack.push(list);
        
        while(!stack.isEmpty()&&stack.peek().get(0)<=price){
            list.set(1,list.get(1)+stack.peek().get(1));
            stack.pop();
        }
        stack.push(list);
        return list.get(1);
         
        // int ans=1;
        // List<Integer>list=new ArrayList<>();
        // while(!stack.isEmpty()&&stack.peek()<=price){
        //     list.add(stack.peek());
        //     stack.pop();
        //     ans++;
        // }
        // while(list.size()!=0){
        //     stack.push(list.get(list.size()-1));
        //     list.remove(list.size()-1);
        // }
        
        // stack.push(price);
        // return ans;
        

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */