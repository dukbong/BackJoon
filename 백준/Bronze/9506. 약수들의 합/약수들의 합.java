import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
        	int sum = 0;
            int n = Integer.parseInt(br.readLine());
           
            if(n == -1){
                break;
            }
            Set<Integer> set = new HashSet<>();
            for(int i = 1; i < n / 2; i++){
                int fir = n % i;
                if(fir == 0){
                    int sec = n / i;
                    set.add(i);
                    set.add(sec);
                }
            }
            
            ArrayList<Integer> arrList = new ArrayList<>(set);
            Collections.sort(arrList);
            
            for(int i = 0; i < arrList.size() - 1; i++){
            	sum += arrList.get(i);
            }
            if(n != sum){
            	System.out.println(n + " is NOT perfect.");
            	continue;
            }
            
            String[] result = arrList.stream().map(Object::toString).toArray(String[]::new);
            int resultLength = result.length;
            String str = String.join(" + ", Arrays.copyOfRange(result, 0, resultLength - 1));
            System.out.println(n + " = " + str);
        }
    }
}