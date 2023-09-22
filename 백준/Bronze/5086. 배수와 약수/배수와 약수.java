import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int[] a = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
            if(a[0] == 0 && a[1] == 0){
                 break;
            }
            if(a[1] % a[0] == 0) {
				System.out.println("factor");
			}
			else if(a[0] % a[1] == 0) {
				System.out.println("multiple");
			}
			else {
				System.out.println("neither");
			}
        }
        
    }
}