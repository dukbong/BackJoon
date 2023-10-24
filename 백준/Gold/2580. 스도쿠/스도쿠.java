import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[9][9];
		ArrayList<int[]> nullArr = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (arr[i][j] == 0) {
					nullArr.add(new int[] { i, j });
				}
			}
		}
		sudoku(arr,  0, nullArr, nullArr.size());
	}

	private void sudoku(int[][] arr, int start, ArrayList<int[]> nullArr, int count) {
		if (count == 0) {
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < 9; i++) {
				sb.append(Arrays.stream(arr[i]).mapToObj(String::valueOf).collect(Collectors.joining(" "))).append("\n");
			}
			System.out.print(sb.toString());
			System.exit(0);
		}
		
		
//		for(int i = start; i < nullArr.size(); i++){
			int[] possibleNum = check(arr, nullArr.get(start)); // [1, 4, 5]
//			if(arr[nullArr.get(i)[0]][nullArr.get(i)[1]] == 0){
//				System.out.println("찾는 곳 : " + Arrays.toString(nullArr.get(i)) + ", 가능한 개수 : " + possibleNum.length);
//				if(possibleNum.length != 0){
					for(int j = 0; j < possibleNum.length; j++){
						arr[nullArr.get(start)[0]][nullArr.get(start)[1]] = possibleNum[j];
						sudoku(arr, start + 1, nullArr, count - 1);
						arr[nullArr.get(start)[0]][nullArr.get(start)[1]] = 0;
					}
//				}else{
//					return;
//				}

				
				
//			}
//		}

	}

	// 들어갈 수 있는 숫자 체크
	private int[] check(int[][] arr, int[] position) {
		/*
		ArrayList<Integer> check = new ArrayList<>();
		// 가로
		for (int i = 0; i < 9; i++) {
			check.add(arr[position[0]][i]);
		}
//		ArrayList<Integer> row  = IntStream.rangeClosed(1, 9).boxed().filter(i -> !check.contains(i)).collect(Collectors.toCollection(ArrayList::new));
		ArrayList<Integer> row  = lineCheck(check);
		check.clear();
		// 세로
		for (int i = 0; i < 9; i++) {
			check.add(arr[i][position[1]]);
		}
//		ArrayList<Integer> column = IntStream.rangeClosed(1, 9).boxed().filter(i -> !check.contains(i)).collect(Collectors.toCollection(ArrayList::new));
		ArrayList<Integer> column = lineCheck(check);
		check.clear();
		
//		int[] move = new int[] { -2, -1, 0 };
		
		int sqareX = sqarePoint(position[1]);
		int sqareY = sqarePoint(position[0]);
//		for (int i = 0; i < 3; i++) {
//			int x = (position[1] + move[i]) % 3;
//			if (x == 0) {
//				sqareX = position[1] + move[i];
//				break;
//			}
//		}
//		for(int i = 0; i < 3; i++) {
//			int y = (position[0] + move[i]) % 3;
//			if(y == 0) {
//				sqareY = position[0] + move[i];
//				break;
//			}
//		}
		
		for(int i = sqareY; i < sqareY + 3; i++) {
			for(int j = sqareX; j < sqareX + 3; j++) {
				check.add(arr[i][j]);
			}
		}
		
		ArrayList<Integer> box = IntStream.rangeClosed(1, 9).boxed()
												  			.filter(i -> !check.contains(i))
												  			.collect(Collectors.toCollection(ArrayList::new));
		
		int[] result = row.stream().mapToInt(Integer::intValue)
								  .filter(column::contains)
								  .filter(box::contains)
								  .toArray();
		*/
		
		
		Set<Integer> set = new HashSet<>();
		int row = position[0];
		int col = position[1];
		int squareStartRow = row - row % 3;
		int squareStartCol = col - col % 3;
		
		for(int i = 0; i < 9; i++){
			set.add(arr[row][i]);
			set.add(arr[i][col]);
			int squareRow = squareStartRow + i / 3;
			int squareCol = squareStartCol + i % 3;
			set.add(arr[squareRow][squareCol]);
		}
		
		int[] result = IntStream.rangeClosed(1,  9).filter(i -> !set.contains(i)).toArray();
		
		return result;
	}
	
//	private ArrayList<Integer> lineCheck(ArrayList<Integer> list){
//		return IntStream.rangeClosed(1, 9).boxed().filter(i -> !list.contains(i)).collect(Collectors.toCollection(ArrayList::new));
//	}
//	
//	private int sqarePoint(int position){
//		int[] move = new int[] { -2, -1, 0 };
//		for (int i = 0; i < 3; i++) {
//			int x = (position + move[i]) % 3;
//			if (x == 0) {
//				return position + move[i];
//			}
//		}
//		return -1;
//	}
}
