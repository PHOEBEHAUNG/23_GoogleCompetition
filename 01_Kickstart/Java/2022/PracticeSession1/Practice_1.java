
import java.util.Scanner;
import java.util.Arrays;

public class Practice_1
{
  public static void main(String[] args)
  {
    //System.out.println("2020_RoundA_1 Start");
    Scanner scanner = new Scanner(System.in);
    int N = 0;
    int M = 0;
    int[] indexs;

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
      N = scanner.nextInt();
      M = scanner.nextInt();
      indexs = new int[N];

      //System.out.println("Case #" + (testIdx + 1) + " : " + strCnt + ", " + str);
      ///--------------------------------------------------///
      /// solution start
      ///--------------------------------------------------///
      int sum = 0;
      for(int i = 0; i < N; i++) {
        sum += scanner.nextInt();
      }

      sum = sum % M;
      ///--------------------------------------------------///
      /// solution end
      ///--------------------------------------------------///
      testIdx = testIdx + 1; 
      System.out.print("Case #" + testIdx + ":");

      System.out.print(" " + sum);
      System.out.println("");
    }
  }
}