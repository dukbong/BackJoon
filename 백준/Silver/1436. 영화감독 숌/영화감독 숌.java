import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        String devil = "666";
        int devilNum = 666;
        int count = 0;
        
        while(true) {
        	if(String.valueOf(devilNum).contains(devil)) {
        		count++;
        		if(count == num) {
        			System.out.println(devilNum);
        			break;
        		}
        	}
        	devilNum++;
        }
    }
}