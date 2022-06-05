class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i =0;i<s.length();i++){
            Character c = s.charAt(i);
            if(st.size()>0){
                if(c=='(')st.push(c);
                else if(c==')'&&st.peek()=='(')st.pop();
                else return false;
            }
            else st.push(c);
        }
        if(st.size()==0)return true;
        else return false;
        
    }
    public void rec(List<String> pre,int n, String cur ,int curIndex){
        if(curIndex>=n*2){
            if(isValid(cur))pre.add(cur);
            return ;
        }
        rec(pre,n,cur+')',curIndex+1);
        rec(pre,n,cur+'(',curIndex+1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> pre = new ArrayList<>();
        rec(pre,n,"",0);
        return pre;
    }
}