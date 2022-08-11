class Solution {
    public int evalRPN(String[] tokens) {
        int ans =0;
        Stack<Integer> st = new Stack<>();
        String operator = "+-/*";
        for(String t: tokens){
            if( !operator.contains(t)){
                st.push(Integer.parseInt(t));
                continue;
            }
            
            int a =st.pop();
            int b = st.pop();
            if(t.equals("+")){
                st.push(a+b);
            }
            else if(t.equals("-")){
                st.push(b-a);
            }
            else if(t.equals("*")){
                st.push(a*b);
            }
            else if(t.equals("/")){
                st.push(b/a);
            }            
            
        }
        ans =st.pop();
        return ans;
    }
}