import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < num; i++) {
        	list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        for(int i : list) {
        	System.out.println(i);
        }
    }
}