import java.util.*;

public class Solution {
  // 1 3 3 2 2 15
  // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 
  // 1 0 0 0 0 0 0 
  // 2 1 1 0 0 0 0
  // 3 2 2 0 0 0 0
  // 4 3 2
  // 5 4 2
  // 6 5
  // 6 5 3 1 1 1 1 1 1 1  1  1  1  1  1 
  public static int[] getHIndexScore(int[] citationsPerPaper) {
    int[] keep = new int[7];
    int[] hIndex = new int[citationsPerPaper.length];
    // TODO: Add logic to calculate h-index score for each paper
    for(int i = 0; i < citationsPerPaper.length; i++) {
      int num = citationsPerPaper[i];
      for(int j = num; j >= 1; j--) {
        keep[j] = keep[j] + 1;
      }
      System.out.println("Arr : " + Arrays.toString(keep));

      if(i == 0) {
        hIndex[i] = 1;
        continue;
      }
      /// check 
      if(keep[i + 1] >= (i)) {
        System.out.println("check " + keep[i + 1] + ", " + i);
        hIndex[i] = hIndex[i - 1];
      } else {
        hIndex[i] = hIndex[i - 1] + 1;
      }
    }

    return hIndex;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Get number of test cases in input
    int testCaseCount = scanner.nextInt();
    // Iterate through test cases
    for (int tc = 1; tc <= testCaseCount; ++tc) {
      // Get number of papers for this test case
      int paperCount = scanner.nextInt();
      // Get number of citations for each paper
      int[] citations = new int[paperCount];
      for (int p = 0; p < paperCount; ++p) {
        citations[p] = scanner.nextInt();
      }
      // Print h-index score after each paper in this test case
      System.out.print("Case #" + tc + ":");
      for (int score : getHIndexScore(citations)) {
        System.out.append(" ").print(score);
      }
      System.out.println();
    }
  }
}
