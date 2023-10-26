import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int result = 0;
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		int[][] meeting = new int[N][2]; // 1 4, 3 5 이런식으로 들어오기 때문이다.
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}else {
					return o1[1] - o2[1];
				}
			}
		});
		
		int now = 0;
		for (int[] i : meeting) {
        //for(int i = 0; i < N; i++){
			if(now <= i[0]) {
				now = i[1];
				result++;
			}
		}
		
		System.out.println(result);
	}
}