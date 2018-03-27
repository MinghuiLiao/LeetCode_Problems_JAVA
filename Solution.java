package leetcode;

import java.util.Arrays;

public class Solution {
	static double eps = 0.00000001;
    static boolean IsValid(double dist, int k, int[] stations) {
        int sum = 0;
        for (int i = 0; i < stations.length-1; i++) {
            int cnt = 0;
            double t = (stations[i+1]-stations[i])/dist;
            int flr = (int)Math.floor(t);
            int ceil = (int)Math.ceil(t);
            if (flr == ceil) {
                cnt = flr-1;
            } else if (t > flr-eps) {
                cnt = ceil-1;
            } else {
                cnt = flr-1;
            }
            if (cnt < 0) {
                cnt = 0;
            } 
            sum += cnt;
            if (sum > k) {
                System.out.println("sum:"+sum);
                System.out.println("dist:"+dist);
                System.out.println(t);
                System.out.println("flr:"+flr);
                System.out.println("ceil:"+ceil);
                System.out.println("cnt:"+cnt);
                return false;
            }
        }
        System.out.println("sum:"+sum);
        System.out.println("dist:"+dist);
        return true;
    }
    static double BinarySearch(double low, double high, int k, int[] stations) {
    	System.out.println("low:"+low);
    	System.out.println("high:"+high);
        double mid = (low+high)/2;
        if (Math.abs(mid-low) < eps) {
            return mid;
        }
        boolean flag = IsValid(mid, k, stations);
        if (flag == false) return BinarySearch(mid, high, k, stations);
        else return BinarySearch(low, mid, k, stations);
        
    }
    public static double minmaxGasDist(int[] stations, int K) {
        Arrays.sort(stations);
        return BinarySearch(((double)(stations[1]-stations[0]))/(K+1), stations[stations.length-1]-stations[0], K, stations);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stations = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		double ans = minmaxGasDist(stations, 9);
		System.out.println("ans:"+ ans);
	}

}
