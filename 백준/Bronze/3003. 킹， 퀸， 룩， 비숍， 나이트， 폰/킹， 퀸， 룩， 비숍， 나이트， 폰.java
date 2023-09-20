import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    // 킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] init = {1,1,2,2,2,8};
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            result[i] = init[i] - arr[i];
        }
        String[] str = Arrays.stream(result).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.println(String.join(" ", str));
    }
}