
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[3][2];
        for(int i = 0; i < 3; i++){
        	arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        
        for(int i = 0; i < 3; i++){
        	int checkx = arr[i][0];
        	int checky = arr[i][1];
        	if(x.contains(checkx)){
        		x.remove(Integer.valueOf(checkx));
        	}else{
        		x.add(checkx);
        	}
        	if(y.contains(checky)){
        		y.remove(Integer.valueOf(checky));
        	}else{
        		y.add(checky);
        	}
        }
        System.out.println(x.get(0) + " " + y.get(0));
    }
}