/**
 * 
 */
package com.algoexpert;

/**
 * @author Syed Irfan
 *
 */
public class RakutenSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		System.out.println(getCuts(arr));
	}

	
	public static int getCuts(int[] inp) {
		int counter = 0;
		if(inp.length<=1) {
			return 0;
		}
		if(inp[0] < inp[1]) {
			for(int i = 2;i < inp.length; i++) {
				if(i%2 == 0 && !(inp[i] < inp[i-1])) {
					counter++;
				}
				
				if(i%2 != 0 && inp[i] < inp[i-1]) {
					counter++;
				}
			}
			
		}else {
			for(int i = 2;i < inp.length; i++) {
				if(i%2 == 0 && !(inp[i] > inp[i-1])) {
					counter++;
				}
				
				if(i%2 != 0 && inp[i] > inp[i-1]) {
					counter++;
				}
			}
		}
		return counter;
		
	}
}
