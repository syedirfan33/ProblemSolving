/**
 * 
 */
package com.algoexpert;

/**
 * @author Syed Irfan
 *
 */
public class MonortonicArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isMonotonic(int[] array) {
	    if(array == null || array.length <=1 ) return true;
			
			boolean decreasing = array[0] >= array[array.length-1] ? true: false;
			for(int i=0;i<array.length-1;i++){
				if(decreasing){
					if(array[i] < array[i+1]) return false;
				}else{
					if(array[i] > array[i+1]) return false;
				}
			}
	    return true;
	  }

}
