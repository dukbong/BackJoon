import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= arr[0]; i++){
            if(arr[0] % i == 0){
                list.add(i);
            }
        }
        if(list.size() < arr[1]){
            System.out.println(0);
        }else{
            Optional<Integer> resultCheck = list.stream().sorted().skip(arr[1] - 1).findFirst(); 
            Integer result = resultCheck.get();
            System.out.println(result);
        }
    }
}