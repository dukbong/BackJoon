import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[][] arr = new String[5][15];
   
        for(int i = 0; i < 5; i++){
            String[] array = Arrays.stream(br.readLine().split("")).toArray(String[]::new);
            for(int j = 0; j < 15; j++){
                try{
                    arr[i][j] = array[j];
                }catch(Exception e){
                    arr[i][j] = " ";
                }
            }
        }
        System.out.println(createLine(arr));
    }
    
    private String createLine(String[][] arr){
        String[][] changeArr = new String[arr[0].length][arr.length];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < changeArr.length; i++){
            for(int j = 0; j < changeArr[0].length; j++){
                changeArr[i][j] = arr[j][i];
            }
        }   
       
        for(int i = 0; i < changeArr.length; i++){
            String line = String.join(" ", changeArr[i]).replace(" ","");
            sb.append(line);
        }
        return sb.toString();
    }
}