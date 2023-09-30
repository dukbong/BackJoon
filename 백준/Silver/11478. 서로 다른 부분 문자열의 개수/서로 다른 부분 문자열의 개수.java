import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        Set<String> set = new HashSet<>();
        int count = 0;
        int end = str.length;
        
        for(int i = 0; i < end; i++) {
        	StringBuilder sb = new StringBuilder();
        	for(int j = count; j < end; j++) {
        		sb.append(str[j]);
        		set.add(sb.toString());
        	}
        	count++;
        }
        System.out.println(set.size());
    }
}