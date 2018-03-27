package leetcode;

/**
 * Given a non-empty integer array of size n, find the minimum number of moves
 * required to make all array elements equal, where a move is incrementing n - 1
 * elements by 1.
 * 
 * Example:
 * 
 * Input: [1,2,3]
 * 
 * Output: 3
 * 
 * Explanation: Only three moves are needed (remember each move increments two
 * elements):
 * 
 * [1,2,3] => [2,3,3] => [3,4,3] => [4,4,4]
 * 
 * @author liaominghui
 * 
 */
public class MinMoves {
	public static int minMoves(int[] nums) {
		
		int count = 0;
		int equal = 0;
		for(int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i+1]) equal++;	
			if (equal == nums.length) return 0;
			equal = 0;
		}
		
		
		while (equal != nums.length) {
			System.out.println(equal);
			int max = 0;
			int index = 0;
			for(int i = 0; i < nums.length - 1; i++) {
				if (nums[i] == nums[i+1]) equal++;								
			}
			for(int j = 0; j < nums.length; j++) {
				if (max < nums[j]) {
					max = nums[j];
					index = j;
				}
			}
			
			for (int k = 0; k < nums.length; k++) {
				if (k != index) nums[k]++;
			}

			count++;	
			
		}
		
		return count;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(minMoves(nums));
	}

}
