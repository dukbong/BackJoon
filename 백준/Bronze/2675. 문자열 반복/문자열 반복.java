import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int input = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < input; i++){
        	String[] arr = br.readLine().split(" ");
        	
        	for(int j = 0; j < arr[1].length(); j++){
        		for(int k = 0; k < Integer.parseInt(arr[0]); k++){
        			sb.append(arr[1].charAt(j));
        		}
        	}
        	System.out.println(sb.toString());
        	sb.delete(0, sb.length());
        }
        
    }
}