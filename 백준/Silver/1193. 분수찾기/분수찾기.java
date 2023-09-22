import java.io.*;

public class Main{
	
    public static void main(String[] args) throws IOException{
        new Main().solution();    
    }
    private void solution() throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int checkNum = Integer.parseInt(br.readLine());
    
    	int count = 1, total = 1;
    	int t = 0, b = 0, sum =0, loop = 0;
    	
    	String result = "";
    	
    	while(true){
    		if(checkNum == 1){
    			result = "1/1";
    			break;
    		}
    		if(checkNum <= total){
    			sum = count + 1;
    			loop = checkNum - (total - count) - 1;
    			if(sum % 2 == 0){
    				b = 1;
    				t = sum - b;
    				for(int i = 0; i < loop; i++){
    					t--;
    					b++;
    				}
    			}else{
    				t = 1;
    				b = sum - t;
    				for(int i = 0; i < loop; i++){
    					t++;
    					b--;
    				}
    			}
    			result = t + "/" + b;
    			break;
    		}else{
    			count++; 
    			total += count;
    		}
    	}
    	System.out.println(result);
    }
}