package com.leetcode;


import inet.ipaddr.IPAddressString;
import inet.ipaddr.ipv4.IPv4Address;
import inet.ipaddr.ipv4.IPv4AddressSection;
import inet.ipaddr.ipv6.IPv6Address;

import java.net.Inet6Address;

public class IpExample {
    public static void main(String[] args) {
//        IPv6Address addr = new IPv6Address(new Inet6Address("2001:0db8:85a3:0000:0000:8a2e:0370:7334")); //bytes is byte[16]
//
//        if(addr.isIPv4Compatible() || addr.isIPv4Mapped()) {
//            IPv4Address derivedIpv4Address = addr.getEmbeddedIPv4Address();
//            byte ipv4Bytes[] = derivedIpv4Address.getBytes();
//            System.out.println(new String(ipv4Bytes));
//        }
        IPAddressString str = new IPAddressString("2404:160:802d:6ed6:1:0:d521:7702");
        if(str.isIPv6()) {
            IPv6Address ipv6Address = str.getAddress().toIPv6();
            System.out.println(ipv6Address.toMixedString());
            if(ipv6Address.isIPv4Convertible() || ipv6Address.isIPv4Mapped() || ipv6Address.isIPv4Compatible()) {
                IPv4AddressSection ipv4Address = ipv6Address.get6To4IPv4Address().getHostSection();
                System.out.println("Comibg");
                System.out.println(ipv4Address.toNormalizedString());
            }
        }
    }
}
