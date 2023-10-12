import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] x = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 이항 계수란 C(a,b)이런식으로 나타낼수 있고 이는 조합을 의미한다.
        // 공식이 존재한다. a! / (b! * (a - b)!)
        // 순서 상관없고 중복을 허용하지 않는 것이 특징이다.
        int facA = IntStream.rangeClosed(1, x[0]).reduce(1, (acc, cur) -> acc * cur);
        int facB = IntStream.rangeClosed(1, x[1]).reduce(1, (acc, cur) -> acc * cur);
        int facAB = IntStream.rangeClosed(1, x[0] - x[1]).reduce(1, (acc,cur) -> acc * cur);
        System.out.println(facA / (facB * facAB));
    }
}