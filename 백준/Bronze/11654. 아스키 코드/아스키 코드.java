import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = (int)br.readLine().charAt(0);
        System.out.println(input);
    }
}