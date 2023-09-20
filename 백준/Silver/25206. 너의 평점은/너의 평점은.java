import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] total = new double[20];
        double[] totalCheck = new double[20];
        
        for(int i = 0; i < 20; i++){
        	String[] arr = Arrays.stream(br.readLine().split(" "))
        						 .toArray(String[]::new);
        	
        	double sc = 0.0;
        	switch(arr[2]){
        		case "A+": sc = 4.5; break;
        		case "A0": sc = 4.0; break;
        		case "B+": sc = 3.5; break;
        		case "B0": sc = 3.0; break;
        		case "C+": sc = 2.5; break;
        		case "C0": sc = 2.0; break;
        		case "D+": sc = 1.5; break;
        		case "D0": sc = 1.0; break;
        		case "F" : sc = 0.0; break;
        	}
        	
        	total[i] = Double.parseDouble(arr[1]) * sc;
        	
        	if(!arr[2].equals("P")){
            	totalCheck[i] = Double.parseDouble(arr[1]);
        	}
        }
        double result = Arrays.stream(total).reduce(0, (acc, cur) -> acc + cur);
        double result2 = Arrays.stream(totalCheck).reduce(0, (acc, cur) -> acc + cur);
        System.out.println(result / result2);
    }
}