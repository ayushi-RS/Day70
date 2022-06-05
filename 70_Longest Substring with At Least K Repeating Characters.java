class Solution {
    public int longestSubstring(String s, int k) {
        int chr[] = new int[36];
        char str[] = s.toCharArray();
        int dist=0;
        if(s.length()==1&&k==1) return 1;
            
        for(int i=0;i<str.length-1;i++){
            chr = new int[36];
            chr[str[i]-'a']+=1;
            for(int j=i+1;j<str.length;j++){
                 chr[str[j]-'a']+=1;
                 if(isValidSubstring(k,chr)){
                     dist = Math.max(dist,j+1-i);
                 }
            }
        }
        return dist;
    }
    public boolean isValidSubstring(int k,int chr[]){
    
        for(int i=0;i<chr.length;i++)
        {
            if(chr[i]>0&&chr[i]<k)
                return false;
        }   
        return true;
    }
}