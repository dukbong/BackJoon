import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] check = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        
        int[] totalArr = new int[check[0]];
        for(int i = 0; i < totalArr.length; i++){
            totalArr[i] = i + 1;
        }
        
        for(int i = 0; i < check[1]; i++){
            int[] check2 = Arrays.stream(br.readLine().split(" "))
                                 .mapToInt(Integer::parseInt)
                                 .map((val) -> val -1)
                                 .toArray();
            
            int temp = totalArr[check2[0]]; 
            totalArr[check2[0]] = totalArr[check2[1]]; 
            totalArr[check2[1]] = temp; 
        }
        String[] str = Arrays.stream(totalArr)
                           .mapToObj(String::valueOf)
                           .toArray(String[]::new);
        System.out.println(String.join(" ", str));
    }
}