import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 2;
        while(n > 1){
        	if(n % start == 0){
        		n /= start;
        		System.out.println(start);
        	}else{
        		start++;
        	}
        	
        }
    }
}
