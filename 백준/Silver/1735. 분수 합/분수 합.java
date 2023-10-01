import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        long mo = arr1[1] * arr2[1];
        long ja = arr1[0] * arr2[1] + arr2[0] * arr1[1];
        
        long[] arr = {mo, ja};
        Arrays.sort(arr);
        
        long count = gcd(arr[0], arr[1]);
        
        mo /= count;
        ja /= count;
        
        System.out.println(ja + " " + mo);
    }

	private long gcd(long arr0, long arr1) {
		if(arr1 == 0) {
			return arr0;
		}
		return gcd(arr1, arr0 % arr1);
	}
}