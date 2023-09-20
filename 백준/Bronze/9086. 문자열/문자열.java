import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for(int i = 0; i < count; i++){
        	String testCase = br.readLine();
        	String start = String.valueOf(testCase.charAt(0));
        	String end = String.valueOf(testCase.charAt(testCase.length() - 1));
        	System.out.println(start+end);
        }
    }
}