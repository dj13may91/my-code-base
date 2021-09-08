package Competitive_programming;

import java.util.Arrays;

public class IpExplode {

  /*
  Using cidr, print all the IPs that fall in range
  * */
  public static void main(String[] args) {
    String ip = "1.1.0.0/20";
    String[] cidr = ip.split("/");
    System.out.println("cidr : " + cidr[1]);
    String[] bits = cidr[0].split("\\.");
    int range = (int) Math.pow(2, 32 - Integer.parseInt(cidr[1]));
    int IP_MAX = 255; // set to single digit to check 
    for (int i = 0; i < range; i++) {
      System.out.println(Arrays.toString(bits));
      int bit = Integer.parseInt(bits[3]);
      bits[3] = ++bit + "";
      if (bit == IP_MAX) {
        int index = 3;
        while (index >= 0 && Integer.parseInt(bits[index]) == IP_MAX) {
          bits[index] = "0";
          index--;
        }
        if(index >= 0){
          bits[index] = (Integer.parseInt(bits[index]) + 1) + "";
        }
      }
    }
  }
}
