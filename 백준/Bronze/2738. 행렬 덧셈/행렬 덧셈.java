
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] size = Arrays.stream(br.readLine().split(" "))
						   .mapToInt(Integer::parseInt)
						   .toArray();
		
		int[][] arr1 = createArray(size, br);
		int[][] arr2 = createArray(size, br);
		int[][] arr3 = sumArray(arr1, arr2, size);
		
		for(int i = 0; i < size[0]; i++){
			int[] result = arr3[i];
			String[] str = Arrays.stream(result)
							   .mapToObj(String::valueOf)
							   .toArray(String[]::new);
			System.out.println(String.join(" ", str));
		}
	}
	
	private int[][] createArray(int[] size, BufferedReader br) throws IOException{
		int[][] createArr = new int[size[0]][size[1]];
		for(int i = 0; i < size[0]; i++){
			int[] value = Arrays.stream(br.readLine().split(" "))
								.mapToInt(Integer::parseInt)
								.toArray();
			for(int j = 0; j < size[1]; j++){
				createArr[i][j] = value[j];
			}
		}
		return createArr;
	}
	
	private int[][] sumArray(int[][] arr1, int[][] arr2, int[] size){
		int[][] sumArray = new int[size[0]][size[1]];
		
		for(int i = 0; i < size[0]; i++){
			for(int j = 0; j < size[1]; j++){
				sumArray[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return sumArray;
	}
}