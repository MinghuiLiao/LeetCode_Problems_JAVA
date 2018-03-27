package leetcode;
//682. Baseball Game
/**
 * You're now a baseball game point recorder.
 * Given a list of strings, each string can be one of the 4 following types:
 
 * Integer (one round's score): Directly represents the number of points you get in this round.
 * "+" (one round's score): 
 * Represents that the points you get in this round are the sum of the last two valid round's points.
 * "D" (one round's score): 
 * Represents that the points you get in this round are the doubled data of the last valid round's points.
 * "C" (an operation, which isn't a round's score): 
 * Represents the last valid round's points you get were invalid and should be removed.
 
 * Each round's operation is permanent and could have an impact on the round before and the round after.
 * You need to return the sum of the points you could get in all the rounds.
 
 *Example 1:
 *Input: ["5","2","C","D","+"]
 *Output: 30
 *Explanation: 
 *Round 1: You could get 5 points. The sum is: 5.
 *Round 2: You could get 2 points. The sum is: 7.
 *Operation 1: The round 2's data was invalid. The sum is: 5.  
 *Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
 *Round 4: You could get 5 + 10 = 15 points. The sum is: 30. 
 */
import java.util.Stack;

public class CalPoints {
	public static int calPoints(String[] ops) {
		int point = 0;
		Stack<Integer> stack = new Stack();
		for (String str: ops) {
			if (str.equals("C")) {
				point -= stack.pop();
			} else if (str.equals("D")) {
				stack.push(stack.peek() * 2);
				point += stack.peek();
			} else if (str.equals("+")) {
				int last = stack.pop();
				int temp = stack.peek();
				stack.push(last);
				stack.push(stack.peek() + temp);
				point += stack.peek();
			} else {
				stack.push(Integer.parseInt(str));
				point += stack.peek();
			}
		}
		
		return point;
	}

	public static void main(String[] args) {
		String[] ops = {"5","2","C","D","+"};
		System.out.println(calPoints(ops));
	}

}
