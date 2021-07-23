package com.practice.leetcode.stringProbs;

/**
 * 1108. Defanging an IP Address
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 *
 * A defanged IP address replaces every period "." with "[.]".
 * Example 1:
 *
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 * Example 2:
 *
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 *
 * What i learned ? ReplaceAll of String replaces string occurrences whereas replace replaces char occurrences.
 */
public class DefangIPAddress {

    // 3ms
    public String defangIpAddr(String ip) {
        ip=ip.replaceAll("\\.", "[.]");
        return ip;
    }

    // 0 ms. No diff between defangIpAddr2 and defangIpAddr3
    public String defangIpAddr3(String ip) {
        ip = ip.replace(".", "[.]");
        return ip;
    }

    //0 ms
    public String defangIpAddr2(String ip) {
        int n = ip.length();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<n;i++){
            char c = ip.charAt(i);
            if (c == '.') {
                stringBuilder.append("[").append(".").append("]");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        DefangIPAddress defangIPAddress = new DefangIPAddress();
        System.out.println(defangIPAddress.defangIpAddr2("1.1.1.1"));
    }
}
