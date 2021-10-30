import java.util.Scanner;
import java.util.Arrays;

public class RoundG_3
{
  public static void main(String[] args)
  {
    System.out.println("2021_RoundG_3 Start");
    Scanner scanner = new Scanner(System.in);

    ///--------------------------------------------------///
    int testCnt = 0;
    int testIdx = 0;
    testCnt = scanner.nextInt();

    System.out.println("Get testCnt : " + testCnt);

    ///--------------------------------------------------///
    int ans = -1;

    ///--------------------------------------------------///
    /// test case variable
    String str;
    int treeCnt = 0;
    int capacity = 0;
    int[] treeForms;

    long[][] treeBunches;

    while(true)
    {
      if(testIdx >= testCnt)
      {
        break;
      }
      
      ///--------------------------------------------------///
      /// init array & variable
      ///--------------------------------------------------///
      ans = -1;
      treeCnt = scanner.nextInt();
      capacity = scanner.nextInt();

      treeForms = new int[treeCnt];
      treeBunches = new long[treeCnt + 1][treeCnt + 1];

      for(int i = 0; i < treeCnt; i++)
      {
        treeForms[i] = scanner.nextInt();
      }

      ///--------------------------------------------------///
      /// solution start
      ///--------------------------------------------------///
      for(int i = 1; i <= treeCnt; i++)
      {
        for(int j = i; j <= treeCnt; j++)
        {
          treeBunches[i][j] = treeBunches[i][j - 1] + treeForms[j - 1];
        }
      }

      for(int i = 0; i <= treeCnt; i++)
      {
        for(int j = 0; j <= treeCnt; j++)
        {
          System.out.print(String.format("%02d ", treeBunches[i][j]));
        }
        System.out.println("");
      }

      for(int i = 1; i <= treeCnt; i++)
      {
        for(int j = i; j <= treeCnt; j++)
        {
          int castJ = j - i + 1;
          if(treeBunches[i][j] == capacity)
          {
            if((ans == -1) || (ans >= castJ))
            {
              ans = castJ;
              System.out.println(String.format("[%02d][%02d] : %02d", i, j, ans));
              continue;
            }
          }

          for(int k = j + 1; k <= treeCnt; k++)
          {
            for(int l = k; l <= treeCnt; l++)
            {
              int castL = l - k + 1;
              if((treeBunches[i][j] + treeBunches[k][l]) == capacity)
              {
                if((ans == -1) || (ans >= castJ + castL))
                {
                  ans = castJ + castL;
                  System.out.println(String.format("[%02d][%02d] - [%02d][%02d]: %02d", i, j, k, l,ans));
                  break;
                }
              }
            }
          }
        }
      }
      ///--------------------------------------------------///
      /// solution end
      ///--------------------------------------------------///
      testIdx = testIdx + 1; 

      System.out.print("Case #" + testIdx + ": " + ans);
      System.out.println("");
    }
  }
}