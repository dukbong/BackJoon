import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		List<String> list = new ArrayList<>();
		for(int i = 2; i < str.length(); i++) {
			for(int j = 1; j < i; j++) {
                StringBuilder sb1 = new StringBuilder(str.substring(0, j));
                StringBuilder sb2 = new StringBuilder(str.substring(j, i));
                StringBuilder sb3 = new StringBuilder(str.substring(i));
                String reverseSb1 = sb1.reverse().toString();
                String reverseSb2 = sb2.reverse().toString();
                String reverseSb3 = sb3.reverse().toString();
                list.add(reverseSb1 + reverseSb2 + reverseSb3);
			}
		}
		Collections.sort(list);
		System.out.println(list.get(0));
	}

}