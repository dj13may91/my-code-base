// http://commons.apache.org/proper/commons-net/apidocs/src-html/org/apache/commons/net/util/SubnetUtils.html#line.27
package Competitive_programming;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.regex.Pattern;

public class IpInRange {

  private static final String IP_ADDRESS = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})";
  private static final String SLASH_FORMAT = IP_ADDRESS + "/(\\d{1,3})";
  private static final Pattern addressPattern = Pattern.compile(IP_ADDRESS);
  private static final Pattern cidrPattern = Pattern.compile(SLASH_FORMAT);
  private String ipStart = "255.255.255.0";
  private String ipEnd = "255.255.255.255";

  public static void main(String[] args) {
    System.out.println(Double.valueOf(Math.pow(2,32-12)).longValue());
//    System.out.println(Integer.parseInt("11111111111111111111111100000000", 2));
    IpInRange ip = new IpInRange();
    System.out.println(ip.getBigInt(ip.ipEnd) - ip.getBigInt(ip.ipStart));
//    ip.printCidr();


//    int[] startIpBits = ip.test(ip.ipStart);
//    int[] endIpBits = ip.test(ip.ipEnd);
//    int[] checkIp = ip.test("10.0.3.2");
//    int i = 0;
//    System.out.println(endIpBits[0] << 2);
//    while (i < 4) {
//      if (startIpBits[i] == checkIp[i] && endIpBits[i] == checkIp[i]) {
//        System.out.println("Same at index " + i);
//        i++;
//      } else {
//        if (startIpBits[i] > checkIp[i] || endIpBits[i] < checkIp[i]) {
//          System.out.println("not in range");
//          break;
//        } else if (startIpBits[i] == checkIp[i] && endIpBits[i] >= checkIp[i]) {
//          System.out.println("Colliding bit, check next bit");
//          i++;
//        } else {
//          System.out.println("in range");
//          break;
//        }
//      }
//    }
  }

  public long getBigInt(String ip) {
    String[] ipBits = ip.split("\\.");
    int[] startBits = new int[4];
    StringBuilder bitNumber = new StringBuilder();
    for (int i = 0; i < 4; i++) {
      startBits[i] = Integer.parseInt(ipBits[i]);
      ipBits[i] = Integer.toBinaryString(startBits[i]);
      while (ipBits[i].length() != 8) {
        ipBits[i] = "0" + ipBits[i];
      }

      bitNumber.append(ipBits[i]);
    }
    System.out.println(ip + " " + Arrays.toString(ipBits));
    System.out.println(bitNumber);
    BigInteger integer = new BigInteger(bitNumber.toString());
    return Long.parseLong(bitNumber.toString(), 2);
  }

  public int[] test(String ip) {
    String[] ipBits = ip.split("\\.");
    int[] startBits = new int[4];
    for (int i = 0; i < 4; i++) {
      startBits[i] = Integer.parseInt(ipBits[i]);
      ipBits[i] = Integer.toBinaryString(startBits[i]);
    }
    System.out.println(ip + " " + Arrays.toString(ipBits));
    return startBits;
  }


  public void printCidr() {
    int allSet = 0b11111111;  //255
    int cidr = 30;

    int[] netMask = new int[4];
    int[] wildCard = new int[4];
    for (int i = 0; i <= 3; i++) {
      if (cidr > 0) {
        if (cidr >= 8) {
          netMask[i] = allSet;
        } else {
          int num = (1 << (8 - cidr)) - 1;
          netMask[i] = allSet ^ num;//taking XOR here
          System.out.println(num);
        }
      }
      wildCard[i] = allSet - netMask[i];
      cidr = cidr - 8;
    }
//    netMask[cidr / 8] = (1 << (cidr > 8 ? 8 : cidr)) - 1;
//    for (int i = (cidr / 8) + 1; i <= 3; i++) {
//      netMask[i] = 255;
//    }

    System.out.println(Arrays.toString(netMask));
    System.out.println(Arrays.toString(wildCard));
//    int[] end = ipInBitsStart;
//    System.out.println(Arrays.toString(end));
//    end[cidr / 8] = (1 << cidr) - 1;
//    for (int i = (cidr / 8) + 1; i <= 3; i++) {
//      end[i] = 255;
//    }
//    System.out.println(Arrays.toString(end));
//    System.out.println(Arrays.toString(ipInBitsStart));
  }

}
