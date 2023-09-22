import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int total = 1;
        int count = 1;
        int n = Integer.parseInt(br.readLine());
        
        while(true){
	        if(total >= n){
		        System.out.println(count);
                break;
	        }else{
		        total += count * 6;
		        count++;
	        }
        }
    }
}