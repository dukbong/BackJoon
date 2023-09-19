import java.io.*;
import java.util.*;
public class Main{
public static void main(String[] args) throws IOException{
    
    new Main().solution();
}
private void solution() throws IOException{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());
    
    int result = 0;
    if(b > 0 ){
    // 1,2
        if(a > 0){
            result = 1;
        }else{
            result = 2;
        }
    }else{
    // 3,4
        if(a > 0){
            result = 4;
        }else{
            result = 3;
        }
    }
    System.out.println(result);
}
}