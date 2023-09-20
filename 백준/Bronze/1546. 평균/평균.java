import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        double[] arr = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double max = Arrays.stream(arr).max().getAsDouble();
        double result = Arrays.stream(arr).map((val) -> val / max * 100).reduce(0,  (acc, cur) -> acc + cur);
        System.out.println(result/num);
    }
}
