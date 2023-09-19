import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		new Main().solution();
	}
	
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		for(int i = 0; i < count; i++){
			for (int j = i+1; j < count; j++){
				System.out.printf(" ");
			}
			for(int k = 0; k <= i; k++){
				System.out.printf("*");
			}
			System.out.println();
		}
	}
}