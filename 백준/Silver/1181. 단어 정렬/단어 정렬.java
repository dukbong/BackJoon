import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        Set<String> set = new HashSet<>();
        for(int i = 0; i < num; i++) {
        	set.add(br.readLine());
        }
        
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2); // 사전순
				}else {
					return o1.length() - o2.length(); // 길이순
				}
			}
		});
        
        for(String str : list) {
        	sb.append(str).append("\n");
        }
        System.out.println(sb.toString());
    }
}