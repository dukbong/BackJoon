import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException{
    new Main().solution();
  }
  private void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::parseInt).toArray();
    String result = "==";
    if(arr[0] > arr[1])
        result = ">";
    else if (arr[0] < arr[1])
        result = "<";
    System.out.println(result);
  }
}