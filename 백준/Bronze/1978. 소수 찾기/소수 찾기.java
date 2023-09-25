import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String notUse = br.readLine();
        int count = 0;
        
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        for(int i = 0; i < arr.length; i++){
        	boolean test = true;
        	if(arr[i] == 1){
        		continue;
        	}
        	for(int j = 1; j < arr[i]; j++){
        		int check = arr[i] % j;
        		if(check == 0){
        			int check2 = arr[i] / j;
        			if(check != 1 && check2 != arr[i]){
        				test = false;
        				break;
        			}
        		}
        	}
        	
        	if(test){
        		count++;
        	}
        }
        System.out.println(count);
    }
}