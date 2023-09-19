import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		new Main().solution();
	}
	
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String str = "";
			if((str = br.readLine()) != null){
				int sum = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).reduce(0, (acc,cur) -> acc + cur);
				System.out.println(sum);
			}else{
				break;
			}
		}
	}
}