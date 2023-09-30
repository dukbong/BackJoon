import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] arr = Arrays.stream(br.readLine().split("")).map(Integer::parseInt).toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i : arr) {
        	sb.append(i);
        }
        System.out.println(sb.toString());
    }
}