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
		int[] q = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] homeLocation = new int[q[0]];
		for(int i = 0; i < q[0]; i++){
			homeLocation[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(homeLocation); // 정렬이 안된 상태로 배열이 들어온다.
		
		int min = 1; // 최소 거리
		int max = homeLocation[q[0] - 1] - homeLocation[0] + 1; // 최대 거리
		
		System.out.println(machine(homeLocation, max, min, q[1], 1));
	}

	private int machine(int[] homeLocation, int max, int min, int count, int start) { // start는 어짜피 처음엔 1이 들어가기때문에 했다.
		
		while(max > min){
			int mid = (max + min) / 2;
			if(search(mid, homeLocation, start) < count - 1){ // 무조건 1번집은 설치하기 때문에 count - 1을 해준다.
				max = mid; // 길이를 줄이고
			}else{
				min = mid + 1; // 길이를 늘리고
			}
		}
		
		return --min;
	}

	private int search(int mid, int[] homeLocation, int start) {
		int count = 0;
		
		int currentHome = homeLocation[0];
		
//		System.out.print("1 \t");
		for(int i = 1; i < homeLocation.length; i++) {
			int nowHome = homeLocation[i];
			if(nowHome - currentHome >= mid) {
//				System.out.print(nowHome + "\t");
				count++;
				currentHome = nowHome;
			}
		}
//		System.out.println();
//		System.out.println("count = " + count);
//		System.out.println();
		return count;
	}

}