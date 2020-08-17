import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class leetcode241 {
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        if(input==null||input.length()==0){
            return ans;
        }
        if(!input.contains("+")&&!input.contains("-")&&!input.contains("*")){
            ans.add(Integer.valueOf(input));
        }
        for(int i=0;i<input.length();i++){
            char ch = input.charAt(i);
            if(ch=='+'||ch=='-'||ch=='*'){
                List<Integer> leftAns = diffWaysToCompute(input.substring(0,i));
                List<Integer> rightAns = diffWaysToCompute(input.substring(i+1,input.length()));
                for(int l:leftAns){
                    for(int r:rightAns){
                        if(ch=='+') ans.add(l+r);
                        if(ch=='-') ans.add(l-r);
                        if(ch=='*') ans.add(l*r);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(diffWaysToCompute(str));
    }
}
