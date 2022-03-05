import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class Solution
{
  public static void main(String[] args)
  {
    //System.out.println("2021_RoundH_1 Start");
    Scanner scanner = new Scanner(System.in);

    ///--------------------------------------------------///
    int testCnt = 0;
    int testIdx = 0;
    testCnt = scanner.nextInt();

    //System.out.println("Get testCnt : " + testCnt);

    ///--------------------------------------------------///
    int ans = -1;

    ///--------------------------------------------------///
    /// test case variable
    String str1;
    String str2;

    while(true)
    {
      if(testIdx >= testCnt)
      {
        break;
      }
      
      ///--------------------------------------------------///
      /// init array & variable
      ///--------------------------------------------------///
      ans = 0;
      str1 = scanner.next();;
      str2 = scanner.next();

      ///--------------------------------------------------///
      /// solution start
      ///--------------------------------------------------///
      /// str1 sorting
      /// str2 sorting
      ////////////// Java 11 (OpenJDK) isn't work.
      // char[] str1Arr = str1.toCharArray();
      // Arrays.sort(str1Arr);
      // //System.out.println("Str1 : " + Arrays.toString(str1Arr));

      // char[] str2Arr = str2.toCharArray();
      // Arrays.sort(str2Arr);
      // //System.out.println("Str2 : " + Arrays.toString(str2Arr));

      int[] indexArr1 = new int[26];
      int[] indexArr2 = new int[26];

      for(int i = 0; i < str1.length(); i++) {
        //System.out.println("" + (int)(str1Arr[i]) + " = " + str1Arr[i]);
        int temp = (int)(str1.charAt(i));
        indexArr1[temp - 97] = indexArr1[temp - 97] + 1;
      }
      //System.out.println("indexArr1 : " + Arrays.toString(indexArr1));

      for(int i = 0; i < str2.length(); i++) {
        //System.out.println("" + (int)(str2Arr[i]) + " = " + str2Arr[i]);
        int temp = (int)(str2.charAt(i));
        indexArr2[temp - 97] = indexArr2[temp - 97] + 1;
      }
      //System.out.println("indexArr2 : " + Arrays.toString(indexArr2));

      int[] stepArray = new int[26];
      for(int i = 0; i < indexArr1.length; i++) {
        if(indexArr1[i] == 0) {
          continue;
        }

        int stepRight = Integer.MAX_VALUE;
        int pos = 0;
        for(int j = 0; j < indexArr2.length; j++) {
          pos = i + j;
          pos = pos % 26;
          if(indexArr2[pos] != 0) {
            stepRight = j;
            break;
          }
        }

        int stepLeft = Integer.MAX_VALUE;
        for(int j = 0; j < indexArr2.length; j++) {
          pos = i - j;
          if(pos < 0) {
            pos = 26 + pos;
          }
          if(indexArr2[pos] != 0) {
            stepLeft = j;
            break;
          }
        }

        stepArray[i] = Math.min(stepRight, stepLeft);
      }

      //System.out.println("stepArray : " + Arrays.toString(stepArray));

      for(int i = 0; i < indexArr1.length; i++) {
        ans = ans + indexArr1[i] * stepArray[i];
      }
      // Map<String, Integer> maps1 = new HashMap<String, Integer>();
      // for(int i = 0; i < str1Arr.length; i++) {
      //   String letter = String.valueOf(str1Arr[i]);
      //   int count = maps1.getOrDefault(letter, 0);
      //   maps1.put(letter, count + 1);
      // }

      // Map<String, Integer> maps2 = new HashMap<String, Integer>();
      // for(int i = 0; i < str2Arr.length; i++) {
      //   String letter = String.valueOf(str2Arr[i]);
      //   int count = maps2.getOrDefault(letter, 0);
      //   maps2.put(letter, count + 1);
      // }
      // for (Map.Entry<String, Integer> entry : maps1.entrySet()) {
      //   System.out.println("Map Key : " + entry.getKey() + ", Value : " + entry.getValue());
      // }


      ///--------------------------------------------------///
      /// solution end
      ///--------------------------------------------------///
      testIdx = testIdx + 1; 

      System.out.print("Case #" + testIdx + ": " + ans);
      System.out.println("");
    }
  }
}