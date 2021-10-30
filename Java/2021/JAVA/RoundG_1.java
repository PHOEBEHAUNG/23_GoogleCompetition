

import java.util.Scanner;
import java.util.Arrays;

public class RoundG_1
{
  public static void main(String[] args)
  {
    System.out.println("2021_RoundG_1 Start");
    Scanner scanner = new Scanner(System.in);

    ///--------------------------------------------------///
    int testCnt = 0;
    int testIdx = 0;
    testCnt = scanner.nextInt();

    System.out.println("Get testCnt : " + testCnt);

    ///--------------------------------------------------///
    /// test case variable
    String str;
    int animalCnt = 0;
    long DCnt = 0;
    long CCnt = 0;
    int extraCnt = 0; /// how many extra C can get after D is fed

    while(true)
    {
      if(testIdx >= testCnt)
      {
        break;
      }

      ///--------------------------------------------------///
      /// init array & variable
      ///--------------------------------------------------///
      animalCnt = scanner.nextInt();
      DCnt = scanner.nextInt();
      CCnt = scanner.nextInt();
      extraCnt = scanner.nextInt();
      
      str = scanner.next();

      System.out.println("Case #" + (testIdx + 1) + " : " + animalCnt + ", " + str);
      ///--------------------------------------------------///
      /// solution start
      ///--------------------------------------------------///
      int cntOf = 0;
      for(int i = 0; i < str.length(); i++) 
      {
        System.out.println("[Start] " + str.charAt(i) + " <= DCnt : " + DCnt + ", CCnt : " + CCnt);
        if(DCnt <= 0)
        {
          break;
        }

        if(CCnt < 0)
        {
          break;
        }

        if(str.charAt(i) == 'D')
        {
          DCnt = DCnt - 1;
          CCnt = CCnt + extraCnt;
        }
        else
        {
          CCnt = CCnt - 1;
        }

        cntOf = i + 1;
        System.out.println("[End] " + str.charAt(i) + " <= DCnt : " + DCnt + ", CCnt : " + CCnt);
      }

      ///--------------------------------------------------///
      /// solution end
      ///--------------------------------------------------///
      testIdx = testIdx + 1; 

      boolean ans = true;
      str = str.substring(cntOf);
      System.out.println("[Remain] " + str);
      if(str.contains("D")) 
      {
        ans = false;
      }

      if(ans)
      {
        System.out.print("Case #" + testIdx + ": YES");
      }
      else 
      {
        System.out.print("Case #" + testIdx + ": NO");
      }
      
      System.out.println("");
    }
  }
}