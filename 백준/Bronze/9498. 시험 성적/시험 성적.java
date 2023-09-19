import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int x = Integer.parseInt(br.readLine());
        String result = "";
        if(x >= 90){
          result = "A";
        }
        else if(x >= 80){
          result = "B";
        }
        else if(x >= 70){
          result = "C";
        }
        else if(x >= 60){
          result = "D";
        }else{
          result = "F";
        }
        System.out.println(result);
    }
}