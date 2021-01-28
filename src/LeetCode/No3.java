package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/9/6 16:02
 * @description：
 */
public class No3 {
    public int lengthOfLongestSubstring(String s) {
        int result=0;
        String x="";
        if(s.length()==1){
            return 1;
        }
        for(int i=0;i<s.length();i++){
            x=s.substring(i,i+1);
            for(int j=i+1;j<s.length();j++){
                if(!x.contains(s.substring(j,j+1))){
                    x=s.substring(i,j+1);
                }
                else{
                    if(x.length()>result){
                        result=x.length();
                    }
                    break;
                }
            }
            result = Math.max(x.length(),result);
        }
        return result;
    }
}
