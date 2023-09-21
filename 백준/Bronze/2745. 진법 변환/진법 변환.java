import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = Arrays.stream(br.readLine().split(" ")).toArray(String[]::new);
        int n = Integer.parseInt(input[1]);
        String str = new StringBuilder(input[0]).reverse().toString();
        
        int result = 0;
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                result += ((int)c - 'A' + 10) * Math.pow(n,i); // -55
            }else{
                result += (c - '0') * Math.pow(n,i); // 이게 문제 였다...
            }
        }
        System.out.println(result);
    }
}