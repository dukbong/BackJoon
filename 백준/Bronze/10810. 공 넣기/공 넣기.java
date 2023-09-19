import java.io.*;
import java.util.*;

public class Main{
 public static void main(String[] args) throws IOException{
  new Main().solution();
 }

 private void solution() throws IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int[] check = Arrays.stream(br.readLine()
                      .split(" "))
                      .mapToInt(Integer::parseInt)
                      .toArray();
     
  String[] totalArr = new String[check[0]];
  Arrays.fill(totalArr, "0");
     
  for(int i = 0; i < check[1]; i++){
    String[] row = br.readLine().split(" ");
      
    int start = Integer.parseInt(row[0]) - 1;
    int end = Integer.parseInt(row[1]) - 1;
    String value = row[2];
    
    if(start != end){
      for(int j = start; j <= end; j++){
        totalArr[j] = value;
      }
    }else{
        totalArr[start] = value;
    }
  }
  System.out.println(String.join(" ", totalArr));
 }
}