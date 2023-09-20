import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int total = 0;
        for(int i = 0; i < count; i++){
            String str = br.readLine();
            String check = String.valueOf(str.charAt(0)); // a
            if(str.length() == 1){
                total += 1;
            }else{
                for(int j = 1; j < str.length(); j++){ // 4
                    String now = String.valueOf(str.charAt(j)); // b a
                    String last = String.valueOf(check.charAt(check.length() - 1)); // a b
                
                    if(!now.equals(last)){
                        if(!check.contains(now)){
                            check += now; // ab
                            if(j == str.length() - 1){
                                total += 1;
                            }
                        }else{
                            break;
                        }
                    }else if(now.equals(last) && j == str.length() - 1){
                        total += 1;
                    }
                }
            }
            
        }
        System.out.println(total);
    }
}