import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int homeCount = Integer.parseInt(br.readLine());
		int[][] homePrice = new int[homeCount][3]; // r g b
		
		// 집은 2개 이상이다.
		homePrice[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		for(int i = 1; i < homeCount; i++){
			homePrice[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			homePrice[i][0] += Math.min(homePrice[i - 1][1], homePrice[i - 1][2]); 
			homePrice[i][1] += Math.min(homePrice[i - 1][0], homePrice[i - 1][2]); 
			homePrice[i][2] += Math.min(homePrice[i - 1][0], homePrice[i - 1][1]); 
		}
		
		Arrays.sort(homePrice[homeCount - 1]);
		System.out.println(homePrice[homeCount - 1][0]);
	}
}

/*
	첫번째 가설(무조건 최소값) 실패 
	71 + 55 + 37 + 89 + 11 + 13 + 29 + 60 : 365
	39 + 32 + 37 + 89 + 11 + 13 + 29 + 60 : 310
	44 + 32 + 37 + 89 + 11 + 13 + 29 + 60 : 315
	
	두번째 삽질(그냥 같자기 든 위 아래 차이가 많이 나는 거 선택) 당연히 실패
	
	세번째 삽질(위 아래 차이가 제일 적게 나는거 선택) 당연히 실패 빡대가리....
	
	네번째 가설(아는 거라곤 누적합) 성공
	71			39			44
	32 + 39 = 71		83 + 44 = 127		55 + 39 = 94
	51 + 94 = 145		37 + 71 = 108		63 + 71 = 134
	89 + 108 = 197		29 + 134 = 163		100 + 108 = 208
	83 + 163 = 246		58 + 197 = 255		11 + 163 = 174
	65 + 174 = 237		13 + 174 = 187		15 + 246 = 261
	47 + 187 = 234		25 + 237 = 262		29 + 187 = 216
	60 + 216 = 276		66 + 216 = 282		19 + 234 = 253
*/