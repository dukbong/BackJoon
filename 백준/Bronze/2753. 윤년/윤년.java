import java.io.*;

public class Main{

public static void main(String[] args) throws IOException{
new Main().solution();
}

private void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());
    
    int result = 0;
    if ((x % 4 == 0 && x % 100 != 0) || x % 400 == 0){
        result = 1;
    }
    System.out.println(result);
}

}