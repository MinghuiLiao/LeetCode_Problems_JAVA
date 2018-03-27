package leetcode;
import java.util.*;

public class DistributeCandies {
	private Set<Integer> set = new HashSet<Integer>();
	public int distributeCandies(int[] candies) {
		set.clear();
		for (int i = 0; i < candies.length; i++) {
			set.add(new Integer(candies[i]));
		}
		return Math.min(set.size(), candies.length/2);
	}

	public static void main(String[] args) {

	}

}