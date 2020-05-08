package com.leetcode;

public class CheckIfStraightLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	  public boolean checkStraightLine(int[][] coordinates) {
	       
	        for(int i=2;i<coordinates.length-1;i++){
	           if(!onCordinates(coordinates[0], coordinates[1], coordinates[i])) return false;
	        }
	        return true;
	    }
	    
	    private boolean onCordinates(int[] p1, int[] p2, int[] p3){
	        int x1 = p1[0]; int y1 = p1[1];
	        int x2 = p2[0]; int y2 = p2[1];
	        int x3 = p3[0]; int y3 = p3[1];
	        return ( (y1 - y2) * (x2 - x3) ) == ( (y2 - y3) * (x1 - x2)  );
	    }
	    
}
