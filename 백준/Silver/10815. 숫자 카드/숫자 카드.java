import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String notUse1 = br.readLine();
        int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String notUse2 = br.readLine();
        int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr1.length; i++) {
        	map.put(arr1[i], 1);
        }
        
        for(int i = 0; i < arr2.length; i++) {
        	if(map.get(arr2[i]) == null) {
        		sb.append("0").append(" ");
        	}else {
        		sb.append("1").append(" ");
        	}
        }
        System.out.println(sb.toString());
    }
}