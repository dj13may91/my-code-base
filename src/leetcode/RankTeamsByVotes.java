package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//    https://leetcode.com/problems/rank-teams-by-votes/
public class RankTeamsByVotes {
    public static void main(String[] args) {
        String[] votes = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        System.out.println(rankTeams(votes));
    }

    public static String rankTeams(String[] votes) {
        if (votes.length == 1) {
            return votes[0];
        }
        int len = votes[0].length();

        Map<Character, int[]> charMap = new HashMap<>();
        Character[] arr = new Character[len];
        for (int i = 0; i < len; i++) {
            charMap.put(votes[0].charAt(i), new int[len]);
            arr[i] = votes[0].charAt(i);
        }
        for (String vote : votes) {
            for (int i = 0; i < len; i++) {
                int[] rankArr = charMap.get(vote.charAt(i));
                rankArr[i]++;
                charMap.put(vote.charAt(i), rankArr);
            }
        }
        for (char ch : charMap.keySet())
            System.out.println(ch + Arrays.toString(charMap.get(ch)) + "; ");

        Arrays.sort(arr, (o1, o2) -> {
            for (int i = 0; i < len; i++) {
                if (charMap.get(o1)[i] > charMap.get(o2)[i]) return -1;
                else if (charMap.get(o1)[i] < charMap.get(o2)[i]) return 1;
            }
            return o1 - o2;
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
