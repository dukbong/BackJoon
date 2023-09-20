import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[28];
        for(int i = 0; i < 28; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        List<Integer> list = Arrays.stream(arr)
                                   .boxed()
                                   .collect(Collectors.toList());
        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i <= 30; i++){
            list2.add(i);
        }
        
        list2.removeAll(list);
        System.out.println(list2.get(0));
        System.out.println(list2.get(1));
    }
}
