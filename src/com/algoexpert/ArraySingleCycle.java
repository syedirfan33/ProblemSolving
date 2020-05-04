/**
 * 
 */
package com.algoexpert;

/**
 * @author Syed Irfan
 *
 */
public class ArraySingleCycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean hasSingleCycle(int[] array) {
		int currentIdx = 0;
		int numElementsVisited = 0;
		
		while(numElementsVisited < array.length) {
			if(numElementsVisited > 0 && currentIdx == 0) {
				return false;
			}
			numElementsVisited++;
			currentIdx = getNextIdx(currentIdx, array);
		}
		return currentIdx == 0;
	}

	private static int getNextIdx(int currentIdx, int[] array) {
		int jump = array[currentIdx];
		int nextIdx = (currentIdx+jump)%array.length;
		return nextIdx >= 0 ? nextIdx : nextIdx + array.length;
	}
}
