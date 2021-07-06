package leetcode;

//https://leetcode.com/problems/count-and-say/
public class CountAndSay {

  public static void main(String[] args) {
    System.out.println(countAndSay(3));
  }

  public static String countAndSay(int n) {
    if(n== 1){
      return "1";
    }
    StringBuilder say = new StringBuilder("1");
    while(--n > 0){
      int startIndex = 0;
      int currIndex = 0;
      int count = 0;
      StringBuilder currSay = new StringBuilder();
      while(currIndex < say.length()){
        while(currIndex < say.length() && say.charAt(startIndex) == say.charAt(currIndex)){
          count++;
          currIndex++;
        }
        currSay.append(count).append(say.charAt(startIndex));
        startIndex = currIndex;
        count=0;
      }
      say= new StringBuilder(currSay);
    }
    return String.valueOf(say);
  }

  public static void sayAndAppend(int n,StringBuilder say){

  }
}
