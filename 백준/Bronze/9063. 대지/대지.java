import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        for(int i = 0; i < n; i++){
             int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
             x.add(arr[0]);
             y.add(arr[1]);
        }
        Collections.sort(x);
        Collections.sort(y);

        int xLength = x.get(x.size()-1) - x.get(0);
        int yLength = y.get(y.size()-1) - y.get(0);
        
        System.out.println(xLength * yLength);
    }
}