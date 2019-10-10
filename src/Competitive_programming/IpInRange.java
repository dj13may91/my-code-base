package Competitive_programming;

import java.util.Arrays;
import java.util.regex.Pattern;

public class IpInRange {

  private static final String IP_ADDRESS = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})";
  private static final String SLASH_FORMAT = IP_ADDRESS + "/(\\d{1,3})";
  private static final Pattern addressPattern = Pattern.compile(IP_ADDRESS);
  private static final Pattern cidrPattern = Pattern.compile(SLASH_FORMAT);
  private String ipStart = "10.0.4.001";
  private String ipEnd = "10.0.4.032";

  public static void main(String[] args) {
    IpInRange ip = new IpInRange();
    ip.printCidr();

//    int[] startIpBits = ip.test(ip.ipStart);
//    int[] endIpBits = ip.test(ip.ipEnd);
//    int[] checkIp = ip.test("10.0.4.2");
//    int i = 0;
//    System.out.println(endIpBits[0] << 2);
//    while (i < 4) {
//      if (startIpBits[i] == checkIp[i] && endIpBits[i] == checkIp[i]) {
//        System.out.println("Same at index " + i);
//        i++;
//      } else {
//        if (startIpBits[i] > checkIp[i] || endIpBits[i] < checkIp[i]) {
//          System.out.println("not in range");
//        } else {
//          System.out.println("In range");
//        }
//        break;
//      }
//    }
  }

//  public int[] test(String ip) {
//    String[] ipBits = ip.split("\\.");
//    int[] startBits = new int[4];
//    for (int i = 0; i < 4; i++) {
//      startBits[i] = Integer.parseInt(ipBits[i]);
//      ipBits[i] = Integer.toBinaryString(startBits[i]);
//    }
//    System.out.println(ip + " " + Arrays.toString(ipBits));
//    return startBits;
//  }


  public void printCidr() {
    int allSet = 0b11111111;
    int cidr = 29;

    int[] netMask = new int[4];
    for(int i=0; i<=3; i++){
      if(cidr > 0){
        if(cidr >= 8){
          netMask[i] = allSet;
        } else {
          int num = (1 << (8-cidr)) - 1;
          netMask[i] = allSet ^ num;
        }
      }
      cidr = cidr - 8;
    }

//    netMask[cidr / 8] = (1 << (cidr > 8 ? 8 : cidr)) - 1;
//    for (int i = (cidr / 8) + 1; i <= 3; i++) {
//      netMask[i] = 255;
//    }

    System.out.println(Arrays.toString(netMask));
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
