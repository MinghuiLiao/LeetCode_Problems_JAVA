
public class leetcode_461_HammingDistance {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int result = 0;
			result = hammingDistance(1, 4);
			System.out.println("The hamming distance is: " + result);
		}

		public static int hammingDistance(int x, int y) {
	        String biX = Integer.toBinaryString(x); 
	        String biY = Integer.toBinaryString(y); 
		    int ix = Integer.parseInt(biX); 
		    int iy = Integer.parseInt(biY); 
	        
	        int count = 0; 
	        int k = 1;
	        for(int i = 0; i < 31; i++) {
	        	int ix1 = ix % (10 * k) / k;
	        	int iy1 = iy % (10 * k) / k; 
	        	if (ix1 != iy1)
	        		count++;
	        	k = k * 10;
	        }
	        return count; 
	    }
	}
