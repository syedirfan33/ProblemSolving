package com.leetcode;

import javax.activation.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author Syed Irfan - 12/06/2020
 */
public class ATestClass {
    public static void main(String[] args) {

        StringBuilder res = new StringBuilder();
        Object[] arr = new Object[]{null};
        arr[0] = "hi";
        System.out.println(arr[0]);
        System.out.println("0.7.5".compareTo("0.7.4"));
    }
    
   
}
 enum TxnType {
    SPLIT_BILL, SEND_MONEY, SEND_MONEY_REQUEST
}
