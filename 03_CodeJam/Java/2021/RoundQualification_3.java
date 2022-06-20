import java.util.Scanner;
import java.util.Arrays;

public class RoundQualification_3
{
  static int[] numList;

  static void reverse(int start, int n)
  {
    int i, k, t;
    int cnt = 0;
    i = start + (n - start) / 2;
    for (i = start; i <= start + (n - start) / 2; i++) 
    {
      t = numList[i];
      numList[i] = numList[n - cnt];
      numList[n - cnt] = t;
      cnt = cnt + 1;
    }
  }

  public static void main(String[] args)
  {
    //System.out.println("2020_RoundA_1 Start");
    Scanner scanner = new Scanner(System.in);
    
    int numCnt = 0;
    int numCost = 0;
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
      numCnt = scanner.nextInt();
      numList = new int[numCnt];
      numCost = scanner.nextInt();

      for(int i = 0; i < numCnt; i++)
      {
        numList[i] = i + 1;
      }

      ///--------------------------------------------------///
      /// solution start
      ///--------------------------------------------------///
      int res = 0;
      int maxCost = 0;
      for(int i = 2; i <= numCnt; i++)
      {
        maxCost = maxCost + i;
      }
      int minCost = numCnt - 1;

      if(numCost < minCost)
      {
        System.out.println("Case #" + testIdx + ": IMPOSSIBLE");
        testIdx = testIdx + 1; 
        continue;
      }

      if(numCost > maxCost)
      {
        System.out.println("Case #" + testIdx + ": IMPOSSIBLE");
        testIdx = testIdx + 1; 
        continue;
      }

      int minNum = 0;
      int minIdx = 0;
      for (int i = 0; i < numCnt - 1; i++)
      {
        minNum = numList[i];
        minIdx = i;
        for (int j = i; j < numCnt; j++)
        {
          if(numList[j] < minNum)
          {
            minIdx = j;
            minNum = numList[j];
          }
        }
        int cost = (minIdx - i + 1);
        if(minIdx == i)
        {
          res = res + 1;
        }
        else
        {
          res = res + (minIdx - i + 1);
          //System.out.println("["+ i +"] : " + "minIdx : " + minIdx);
          //System.out.println("cost : " + cost);
          reverse(i, minIdx);
        }
      }
      ///--------------------------------------------------///
      /// solution end
      ///--------------------------------------------------///
      testIdx = testIdx + 1; 
      System.out.print("Case #" + testIdx + ": ");

      for(int i = 0; i < numCnt; i++)
      {
        System.out.print(numList[i] + " ");
      }
      System.out.println("");
    }
  }
}