import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();
        int num1 = Integer.parseInt(br.readLine());
        int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int num2 = Integer.parseInt(br.readLine());
        int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num1; i++) {
        	if(map.get(arr1[i]) == null) {
        		map.put(arr1[i], 1);
        	}else {
        		map.put(arr1[i], map.get(arr1[i]) + 1);
        	}
        }
        
        for(int i = 0; i < num2; i++) {
        	if(map.get(arr2[i]) == null) {
        		sb.append(0).append(" ");
        	}else {
        		sb.append(map.get(arr2[i])).append(" ");
        	}
        }
        System.out.println(sb.toString());
    }
}