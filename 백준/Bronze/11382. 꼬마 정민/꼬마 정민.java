import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long result = Arrays.stream(br.readLine().split(" "))
                          .mapToLong(Long::parseLong)
                          .reduce(0, (acc, cur) -> acc + cur);
        
        System.out.println(result);
    }
}