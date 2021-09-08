package Competitive_programming;

import java.util.ArrayList;
import java.util.List;

public class CalenderInvite {
/*
We are writing a tool to help users manage their calendars. Given an unordered list of times of day when someone is busy, write a function that tells us whether they're available during a specified period of time.

Each time is expressed as an integer using 24-hour notation, such as 1200 (12:00), 1530 (15:30), or 800 (8:00).

Sample input:

meetings = [
  [1230, 1300], // 12:30 PM to 1:00 PM
  [845, 900],   //  8:45 AM to 9:00 AM
  [1300, 1500]  //  1:00 PM to 3:00 PM

isAvailable(meetings, 915, 1215)   => true
isAvailable(meetings, 900, 1230)   => true
isAvailable(meetings, 850, 1240)   => false
isAvailable(meetings, 1200, 1300)  => false
isAvailable(meetings, 700, 1600)   => false
isAvailable(meetings, 800, 845)    => true
isAvailable(meetings, 1500, 1800)  => true
isAvailable(meetings, 845, 859)    => false
isAvailable(meetings, 846, 900)    => false
isAvailable(meetings, 846, 859)    => false
isAvailable(meetings, 845, 900)    => false
isAvailable(meetings, 2359, 2400)  => true
isAvailable(meetings, 930, 1600)   => false
isAvailable(meetings, 800, 850)    => false
isAvailable(meetings, 1400, 1600)  => false
isAvailable(meetings, 1300, 1501)  => false
*/

  public static void main(String[] args) {
    List<Meeting> meetings = new ArrayList<Meeting>() {{
      add(new Meeting(1230, 1300));
      add(new Meeting(845, 900));
      add(new Meeting(1300, 1500));
    }};
    System.out.println(isAvailable(meetings, 915, 1215));
    System.out.println(isAvailable(meetings, 900, 1230));
    System.out.println(isAvailable(meetings, 850, 1240));
    System.out.println(isAvailable(meetings, 1200, 1300));
    System.out.println(isAvailable(meetings, 700, 1600));
    System.out.println(isAvailable(meetings, 800, 845));
    System.out.println(isAvailable(meetings, 1500, 1800));
    System.out.println(isAvailable(meetings, 845, 859));
    System.out.println(isAvailable(meetings, 846, 900));
    System.out.println(isAvailable(meetings, 846, 859));
    System.out.println(isAvailable(meetings, 845, 900));
    System.out.println(isAvailable(meetings, 2359, 2400));
    System.out.println(isAvailable(meetings, 930, 1600));
    System.out.println(isAvailable(meetings, 800, 850));
    System.out.println(isAvailable(meetings, 1400, 1600));
    System.out.println(isAvailable(meetings, 1300, 1501));
  }

  // start >= any.end and end <= any.start
  public static boolean isAvailable(List<Meeting> meetings, int start, int end) {
    int startLeast = 2400;
    int endMax = 0;
    for (Meeting m : meetings) {
      if (endMax < m.end) {
        endMax = m.end;
      }
      if (startLeast > m.start) {
        startLeast = m.start;
      }
      if ((m.start <= start && m.end > start) || (m.start < end && m.end >= end)) {
        return false;
      }

      if ((m.start > start && m.end <= start) || (m.start >= end && m.end < end)) {
        return false;
      }
    }

    return true;
  }

  static class Meeting {

    int start;
    int end;

    public Meeting(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
