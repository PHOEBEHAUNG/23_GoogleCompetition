
import java.util.Scanner;
import java.util.Arrays;

public class RoundB_1
{
  public static void main(String[] args)
  {
    //System.out.println("2020_RoundA_1 Start");
    Scanner scanner = new Scanner(System.in);
    int[] indexs;
    String str;

    int strCnt = 0;
    ///--------------------------------------------------///
    int testCnt = 0;
    int testIdx = 0;
    testCnt = scanner.nextInt();

    //System.out.println("Get testCnt : " + testCnt);
    while(true)
    {
      if(testIdx >= testCnt)
      {
        break;
      }

      ///--------------------------------------------------///
      /// init array & variable
      ///--------------------------------------------------///
      strCnt = scanner.nextInt();
      str = scanner.next();
      indexs = new int[strCnt];

      //System.out.println("Case #" + (testIdx + 1) + " : " + strCnt + ", " + str);
      ///--------------------------------------------------///
      /// solution start
      ///--------------------------------------------------///
      int pos = 1;
      char c = 64;

      for(int i = 0; i < strCnt; i++)
      {
        if(str.charAt(i) > c)
        {
          c = str.charAt(i);
          indexs[i] = pos;
          pos = pos + 1;
        }
        else
        {
          pos = 1;
          c = str.charAt(i);
          indexs[i] = pos;
          pos = pos + 1;
        }
      }

      ///--------------------------------------------------///
      /// solution end
      ///--------------------------------------------------///
      testIdx = testIdx + 1; 
      System.out.print("Case #" + testIdx + ":");

      for(int i = 0; i < strCnt; i++)
      {
        System.out.print(" " + indexs[i]);
      }
      System.out.println("");
    }
  }
}