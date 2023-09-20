import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < num; i++){
                for(int j = 0; j < num - i - 1; j++){ 
                    System.out.printf(" ");
                }
                for(int k = 0; k < i * 2 + 1; k++){ 
                    System.out.printf("*");
                } 
                System.out.println(); 
        }
        
        for(int i = 1; i < num; i++){
                for(int j = 0; j < i; j++){  // 1 2 3 4 5
                    System.out.printf(" ");
                }
                for(int k = 0; k < (num - i - 1) * 2 + 1; k++){ // 9 7 5 3 1
                    System.out.printf("*");
                } 
                System.out.println(); 
        }
    }
}