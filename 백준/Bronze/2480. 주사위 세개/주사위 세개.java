import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr); // 정렬
        
        int result = 0;
        int check = arr[0];
        int dul = 0;
        int count = 1;
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == check){
                count++;
                dul = arr[i];
            }else{
                check = arr[i];
            }
        }
        
        
        switch (count){
            case 2:
                result = 1000 + dul * 100;
                break;
            case 3:
                result = 10000 + dul * 1000;
                break;
            default:
                result = arr[arr.length-1] * 100;
        }
        System.out.println(result);
    }
}