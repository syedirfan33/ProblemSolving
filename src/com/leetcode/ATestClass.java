package com.leetcode;

import javax.activation.*;
import java.util.*;

/**
 * @author Syed Irfan - 12/06/2020
 */
public class ATestClass {
    public static void main(String[] args) {
//        StringBuilder res = new StringBuilder();
//        String a = "   ";
//        System.out.println(a+"a");
//        Map<String, Object> map = new HashMap<>();
//        map.put("s", "SPLIT_BIL");
//        TxnType mdf = TxnType.valueOf(map.get("s").toString());
//        System.out.println(mdf);
        
        String b = "true";
        System.out.println(Boolean.parseBoolean("true"));
        System.out.println(Calendar.getInstance().getTimeInMillis());
    }
    
   
}
 enum TxnType {
    SPLIT_BILL, SEND_MONEY, SEND_MONEY_REQUEST
}
