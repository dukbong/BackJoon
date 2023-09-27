import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		new Main().solution();
	}
	
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String question = br.readLine();
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		int pickCount = question.length();
		int[] copy = new int[question.length()];
		
		combo(arr, copy, 0, pickCount, question);
		
		if(list.size() == 0){
			System.out.println(0);
		}else{
			System.out.println(list.get(0));
		}
	}
	
	private void combo(int[] arr, int[] copy, int start, int pickCount, String question) {
		
		if (start == pickCount) {
			int maxCheck = 0;
			for(int i = copy.length - 1, j = 0; i >= 0; i--, j++){
				maxCheck += copy[i] * Math.pow(10, j);
			}
			if(maxCheck >= Integer.parseInt(question)){
				return;
			}
			sum(maxCheck, copy, Integer.parseInt(question));
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			copy[start] = arr[i];
			combo(arr, copy, start + 1, pickCount, question);
		}
	}
	
	
	private void sum(int maxCheck, int[] copy, int question){
		int result = maxCheck;
		for(int i = 0; i < copy.length; i++){
			result += copy[i];
		}
		
		if(result == question){
			list.add(maxCheck);
		}
	}
}