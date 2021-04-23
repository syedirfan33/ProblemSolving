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
        BigDecimal a = new BigDecimal("1234567.995");
        DecimalFormat df = new DecimalFormat("#,###,###.00");
        System.out.println(new BigDecimal(df.format(a)));
        StringBuilder res = new StringBuilder();
    }
    
   
}
 enum TxnType {
    SPLIT_BILL, SEND_MONEY, SEND_MONEY_REQUEST
}
