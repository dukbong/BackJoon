import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = n; i <= m; i++){
        	boolean test = true;
        	if(i == 1){continue;}
        	for(int j = 1; j < i; j++){ // 소수 체크
        		if(i % j == 0){
        			int check2 = i / j;
        			if(check2 != i){
        				test = false;
        				break;
        			}
        		}
        	}
        	
        	if(test){ // 소수는 list에 담는다.
        		list.add(i);
        	}
        }
        if(list.size() == 0){
        	System.out.println(-1);
        	return;
        }
        long sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
        System.out.println(list.get(0));
    }
}