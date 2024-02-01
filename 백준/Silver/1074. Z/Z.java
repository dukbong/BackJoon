import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
	
	int r, c, result;
//	int[][] arr;

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] question = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		r = question[1];
		c = question[2];
//		arr = new int[(int)Math.pow(2, question[0])][(int)Math.pow(2, question[0])];
		
		go(0,0,(int)Math.pow(2, question[0]));
		System.out.println(result);
	}

	private void go(int i, int j, int pow) {
		if(pow == 1){
			return;
		}
		
		int size = pow / 2;
		
		if(r < i + size && c < j + size){
			go(i,j,size);
		}
		if(r < i + size && j + size <= c){
			result = result + (((int)Math.pow(pow, 2)) / 4);
			go(i,j + size, size);
		}
		if(i + size <= r && c < j + size){
			result = result + ((((int)Math.pow(pow, 2)) / 4) * 2);
			go(i + size, j, size);
		}
		if(i + size <= r && j + size <= c){
			result = result + ((((int)Math.pow(pow, 2)) / 4) * 3);
			go(i + size, j + size, size);
		}
	}
}