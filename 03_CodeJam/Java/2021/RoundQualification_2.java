import java.util.Scanner;
import java.util.Arrays;

public class RoundQualification_2
{
  public static void main(String[] args)
  {
    //System.out.println("2020_RoundA_1 Start");
    Scanner scanner = new Scanner(System.in);
    
    int costX = 0;
    int costY = 0;

    char strPattern[];
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
      costX = scanner.nextInt();
      costY = scanner.nextInt();
      // System.out.println("costX " + costX);
      // System.out.println("costY " + costY);

      String str = scanner.nextLine();
      strPattern = new char[str.length()];
      int cnt = 0;
      for (int i = 0; i < str.length(); i++) 
      {
        if(str.charAt(i) == '?')
        {
          continue;
        }
        if(str.charAt(i) == ' ')
        {
          continue;
        }
        strPattern[cnt] = str.charAt(i);
        cnt = cnt + 1;
      }

      // for (int i = 0; i < cnt; i++) 
      // {
      //    System.out.println("Char" + i + " : " + strPattern[i]);
      // }

      // System.out.println("Get str : " + str);
      ///--------------------------------------------------///
      /// solution start
      ///--------------------------------------------------///
      int res = 0;
      for(int i = 0; i < cnt - 1; i++)
      {
        if((strPattern[i] == 'C') && (strPattern[i + 1] == 'J'))
        {
          res = res + costX;
          //System.out.println("CJ");
        }

        if((strPattern[i] == 'J') && (strPattern[i + 1] == 'C'))
        {
          res = res + costY;
          //System.out.println("JC");
        }
      }

      ///--------------------------------------------------///
      /// solution end
      ///--------------------------------------------------///
      testIdx = testIdx + 1; 
      System.out.println("Case #" + testIdx + ": " + res);
    }
  }
}