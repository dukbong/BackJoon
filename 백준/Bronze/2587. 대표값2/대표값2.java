import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
        	list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        int avg = (int)Arrays.stream(arr).average().orElse(0);
        System.out.println(avg);
        
        int middle = list.size() / 2;
        
        System.out.println(list.get(middle));
    }
}