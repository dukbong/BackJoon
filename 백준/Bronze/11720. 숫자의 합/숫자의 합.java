import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String notUse = br.readLine();
        
        int result = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).reduce(0, (acc, cur) -> acc + cur);
//        bw.write(result);
//        bw.flush();
//        bw.close();
        System.out.println(result);
    }
}