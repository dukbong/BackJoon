import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        for(int i = 0; i < 2; i++){
        	StringBuilder sb = new StringBuilder(strArr[i]);
        	strArr[i] = sb.reverse().toString();
        }
        if(Integer.parseInt(strArr[0]) - Integer.parseInt(strArr[1]) > 0){
        	System.out.println(strArr[0]);
        }else{
        	System.out.println(strArr[1]);
        }
    }
}