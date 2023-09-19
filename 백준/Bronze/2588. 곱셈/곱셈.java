import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int[] b = Arrays.stream(br.readLine().split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int result = 0;
        int spot = 1;
        for(int i = b.length-1; i >= 0; i--){
            int rs = b[i] * a;
            System.out.println(rs);
            result += rs * spot;
            spot *= 10;
        }
        System.out.println(result);
    }
}