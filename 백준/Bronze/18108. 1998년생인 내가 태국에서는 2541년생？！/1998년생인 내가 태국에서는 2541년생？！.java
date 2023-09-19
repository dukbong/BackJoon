import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().Solution();
    }
    private void Solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int before = Integer.parseInt(br.readLine());
        int after = before - 543;
        System.out.println(after);
    }
}