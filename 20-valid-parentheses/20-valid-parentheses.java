class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
    for(int i=0;i<s.length();i++){
        if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
            stack.push(s.charAt(i));
        }
        else if(!stack.isEmpty()){
                 char x = stack.pop();
            if(x=='{' && s.charAt(i)!='}'){
                return false;
            }
            if(x=='[' && s.charAt(i)!=']'){
                return false;
            }
            if(x=='(' && s.charAt(i)!=')'){
                return false;
            }
        }
        else{
            return false;
        } 
    }
     return (stack.isEmpty()?true:false);
}
        
    
}