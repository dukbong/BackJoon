import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // 에라토스테네스 체라는 거란다.
        // 소수를 false로 만든다.
		boolean[] bArr = new boolean[1000001];
		bArr[0] = bArr[1] = true;
        for (int i = 2; i * i <= 1000000; i++) {
            if (!bArr[i]) {
                for (int j = i + i; j <= 1000000; j += i) {
                	bArr[j] = true;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
        	int num = Integer.parseInt(br.readLine());
        	int count = findSosu(num, bArr);
        	sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }

	private int findSosu(int num, boolean[] bArr) {
//		ArrayList<Integer> list = new ArrayList<>();
//		int[] testArr = new int[num - 1];
//		// 우선 총 배열을 만든다.
//		for(int i = 0; i < num - 1; i++) {
//			testArr[i] = i + 2;
//		}
//		for(int i = 0; i < testArr.length; i++) {
//			for(int j = i + 1; j < testArr.length; j++) {
//				if(testArr[j] != 0 && testArr[i] != 0) {
//					if(testArr[j] % testArr[i] == 0) {
//						testArr[j] = 0;
//					}
//				}
//			}
//			if(testArr[i] != 0) {
//				list.add(testArr[i]);
//			}
//		}
		
        
//        while(true) {
        	int ans = 0;
        	for(int i = 0; i <= num / 2; i++) {
        		if(!bArr[i] && !bArr[num - i]) {
        			ans++;
        		}
        	}	
//        	System.out.println(ans);
//        }
		
		return ans;
//		// 소수를 list에 담는다.
//		for(int i = 2; i <= num; i++) {
//			int check = checkSosu(i);
//			if(check != 0) {
//				list.add(check);
//			}
//		}
		
		// 합이 같은지 확인하기 위한 코드
//		int[] result = new int[2];
//		combo(0, 0, 2, list.size(), result, list, num);
//		return test;
	}
//	// 소수인지 아닌지 체크
//	private int checkSosu(int i) {
//		if(i == 2 || i == 3) {
//			return i;
//		}
//		for(int j = 2; j <= Math.sqrt(i); j++) {
//			if(i % j == 0) {
//				return 0;
//			}
//		}
//		return i;
//	}
	
	// 이게 지금 시간을 초과하는 것 같다.
//	private void combo(int cnt, int idx, int count, int length, int[] result, ArrayList<Integer> checkArr, int num) {
//		if(cnt == count) {
//			 System.out.println(Arrays.toString(result));
//			if(Arrays.stream(result).reduce((acc, cur) -> acc + cur).getAsInt() == num) {
////				System.out.println("정답 : " + Arrays.toString(result));
//				test++;
//				return;
//			}
//			return;
//		}
//		
//		for(int i = idx; i < length; i++) {
//			result[cnt] = checkArr.get(i);
//			combo(cnt + 1, i, count, length, result, checkArr, num);
//		}
//	}
}