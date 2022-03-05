
import java.util.Scanner;
import java.util.Arrays;

public class RoundC_2
{
  public static void main(String[] args)
  {
    //System.out.println("2020_RoundA_1 Start");
    Scanner scanner = new Scanner(System.in);

    int GNumber = 0;
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
      GNumber = scanner.nextInt();

      //System.out.println("Case #" + (testIdx + 1) + " : " + GNumber);
      ///--------------------------------------------------///
      /// solution start
      ///--------------------------------------------------///
      int res = 0;
      
      int[] GMap = new int[GNumber + 1];
    
      GMap[0] = 0;
      for(int i = 1; i <= GNumber; i++)
      {
        GMap[i] = GMap[i - 1] + i;
        System.out.println("Check GMap : " + i + " => " +  GMap[i]);
      }

      for(int i = GNumber; i >= 0; i--)
      {
        for(int j = i - 1; j >= 0; j--)
        {
            if((GMap[i] - GMap[j]) >= GNumber)
            {
                if((GMap[i] - GMap[j]) == GNumber)
                {
                    System.out.println("K : " + (j + 1));
                    res = res + 1;
                }
                break;
            }
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