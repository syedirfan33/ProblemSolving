package com.leetcode;

public class PerfectSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public boolean isPerfectSquare(int num) {
	        if( num == 1 ) return true;
	        long low = 1; 
	        long high = num/2;
	        
	        while(low<=high){
	            long mid = low + (high - low)/2;
	            long res = mid*mid;
	            if(res == num) return true;
	            else if(res < num) low = mid + 1;
	            else high =  mid - 1;
	        }
	        return false;
	    }
}
