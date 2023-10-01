import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        int[] arr = new int[num];
        int[] arr2 = new int[num - 1];
        // 심어진 위치와 차이를 저장한다.
        for(int i = 0; i < num; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	if(i >= 1) {
        		int x = arr[i] - arr[i - 1];
            	arr2[i - 1] = x;
        	}
        }
        
        // 유클리드 호제법으로 차이들의 최대 공약수를 찾았다.
        int x = findGcd(arr2);
        
        // 길이 차이를 구한다.
        int start = arr[0];
        int count = 0;
        
        while(true) {
        	if(start == arr[arr.length - 1]) {
        		count++;
        		break;
        	}
        	count++;
        	start += x;
        }
        System.out.println(count - arr.length);
    }

	private int findGcd(int[] arr2) {
		int start = arr2[0];
		for(int i = 1; i < arr2.length; i++) {
			start = gcd(start, arr2[i]);
		}
		return start;
	}

	private int gcd(int start, int i) {
		if(i == 0) {
			return start;
		}
		return gcd(i, start % i);
	}
}