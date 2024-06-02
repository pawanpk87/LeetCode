class Num{
    public  char ch;
    public  int index;

    public Num(char ch, int index){
        this.ch = ch;
        this.index = index;
    }
}

class Solution {
    public String clearStars(String s) {
        int n = s.length();
        
        PriorityQueue<Num> priorityQueue =
                new PriorityQueue<>(new Comparator<Num>() {
                    @Override
                    public int compare(Num num1, Num num2) {
                        if(num1.ch < num2.ch){
                            return -1;
                        } else if(num1.ch > num2.ch){
                            return 1;
                        }
                        return num2.index - num1.index;
                    }
                });
        
        Set<Integer> st = new HashSet<>();
        
        IntStream.range(0, n)
             .forEach(i -> {
                 char ch = s.charAt(i);
                 if(ch == '*'){
                     Num removedNum = priorityQueue.poll();
                     st.add(removedNum.index);
                 } else{
                     priorityQueue.add(new Num(ch, i));
                 }
             });
        
        StringBuilder sb = new StringBuilder();
        
        IntStream.range(0, n)
            .forEach(i -> {
                if(s.charAt(i) != '*' && st.contains(i) == false){
                    sb.append(s.charAt(i));
                }
            });
        
        return sb.toString();
    }
}