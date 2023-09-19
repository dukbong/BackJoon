// 첫째 줄에 (A+B)%C,
// 둘째 줄에 ((A%C) + (B%C))%C,
// 셋째 줄에 (A×B)%C,
// 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        new Main().Solution();
    }
    private void Solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                          .mapToInt(Integer::parseInt).toArray();
        
        System.out.println((arr[0] + arr[1]) % arr[2]);
        System.out.println(((arr[0] % arr[2]) + (arr[1] % arr[2])) % arr[2]);
        System.out.println((arr[0] * arr[1]) % arr[2]);
        System.out.println(((arr[0] % arr[2]) * (arr[1] % arr[2])) % arr[2]);
        
    }
}