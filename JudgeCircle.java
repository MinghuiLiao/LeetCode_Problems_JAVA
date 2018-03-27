//657. Judge Route Circle
/**
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, 
 * judge if this robot makes a circle, which means it moves back to the original place.
 * 
 * The move sequence is represented by a string. And each move is represent by a character. 
 * The valid robot moves are R (Right), L (Left), U (Up) and D (down). 
 * The output should be true or false representing whether the robot makes a circle.
 * 
 * Example 1:
 * Input: "UD"
 * Output: true
 * 
 * Example 2:
 * Input: "LL"
 * Output: false
 * @author liaominghui
 *
 */
public class JudgeCircle {
	public static boolean judgeCircle(String moves) {
		int sum = 0;
		for (int i = 0; i < moves.length(); i++) {
			switch(moves.charAt(i)) {
			case 'R': sum++; break;
			case 'L': sum--; break;
			case 'U': sum++; break;
			case 'D': sum--; break;
			}
			
		}
        return sum == 0;
    }

	public static void main(String[] args) {
		String moves = "LL";
		
		System.out.println(judgeCircle(moves));
	}

}
