package com.leetcode;
///**
// * 
// */
//package com.algoexpert;
//
//import java.util.List;
//
///**
// * @author Syed Irfan
// *
// */
//
///**
// * // This is the BinaryMatrix's API interface. // You should not implement it,
// * or speculate about its implementation interface BinaryMatrix { public int
// * get(int x, int y) {} public List<Integer> dimensions {} };
// */
//  //https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/
//public class LeftMostMatrixColumnWithAtleastOne {
//
//	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
//		List<Integer> dim = binaryMatrix.dimensions();
//		int rows = dim.get(0);
//		int columns = dim.get(1);
//		int res = Integer.MAX_VALUE;
//		for (int i = 0; i < rows; i++) {
//			int left = 0;
//			int right = columns - 1;
//			while (left <= right) {
//				int mid = left + (right - left) / 2;
//				int mid_ele = binaryMatrix.get(i, mid);
//				if (mid_ele == 1) {
//					while (mid - 1 >= 0 && binaryMatrix.get(i, mid - 1) == 1)
//						mid--;
//					res = Math.min(res, mid);
//					break;
//				} else if (res > mid) {
//					left = mid + 1;
//				} else {
//					break;
//				}
//			}
//		}
//		return res != Integer.MAX_VALUE ? res : -1;
//	}
//}
