import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//566. Reshape the Matrix
/**
 * In MATLAB, there is a very useful function called 'reshape', which can
 * reshape a matrix into a new one with different size but keep its original
 * data. You're given a matrix represented by a two-dimensional array, and two
 * positive integers r and c representing the row number and column number of
 * the wanted reshaped matrix, respectively. The reshaped matrix need to be
 * filled with all the elements of the original matrix in the same
 * row-traversing order as they were. If the 'reshape' operation with given
 * parameters is possible and legal, output the new reshaped matrix; Otherwise,
 * output the original matrix.
 * 
 * Example 1: 
 * Input: nums = [[1,2], [3,4]] r = 1, c = 4 
 * Output: [[1,2,3,4]]
 * Explanation: The row-traversing of nums is [1,2,3,4]. The new reshaped matrix
 * is a 1 * 4 matrix, fill it row by row by using the previous list.
 * 
 * @author liaominghui
 * 
 */
public class MatrixReshape {
	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		int[][] matrix = new int[r][c];
		if (r * c != (nums.length * nums[0].length)) return nums;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				matrix[i][j] = nums[i][j];
			}
		}
		/*
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i = 0; i < nums.length; i++) { 
			for (int j = 0; j < nums[i].length; j++) {
				que.add(nums[i][j]);				
			}
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				matrix[i][j] = que.poll();			
			}
		}
		*/
		return matrix;
	}

	public static void main(String[] args) {
		int[][] nums = new int[][]{{1, 2}, {3, 4}};
		int r = 2;
		int c = 4;
		System.out.println("The matrix is: " + Arrays.deepToString(nums));
		System.out.println("size: " + nums.length * nums[0].length);
		System.out.println(Arrays.deepToString(matrixReshape(nums,r,c)));

	}

}
