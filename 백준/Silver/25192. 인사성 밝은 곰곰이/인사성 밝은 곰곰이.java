import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> list = new HashSet<>();
        int count = 0;
        
        while(n-->0){
        	String str = br.readLine();
        	if(str.equals("ENTER")){
        		list = new HashSet<>();
        		continue;
        	}
        	if(!list.contains(str)){
        		list.add(str);
        		count++;
        	}
        }
        System.out.println(count);

    }
}