import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list1 = new ArrayList<>();
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        for(int i = 0; i < num[0]; i++) {
        	list1.add(br.readLine());
        }
        
        for(int i = 0; i < num[1]; i++) {
        	String str = br.readLine();
        	if(list1.contains(str)) {
        		count++;
        	}
        }
        System.out.println(count);
    }
}