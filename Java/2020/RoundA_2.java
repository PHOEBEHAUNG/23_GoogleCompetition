package phoebe.kickstart.year2020;

import java.util.Scanner;
import java.util.Arrays;

public class RoundA_2
{
  public static void main(String[] args)
  {
    /// System.out.println("2020_RoundA_2 Start");

    Scanner scanner = new Scanner(System.in);
    ///--------------------------------------------------///
    /// question variable
    ///--------------------------------------------------///
    float[][] stackN;
    int[][] stackNOrg;

    int[] stackStartIdx;

    int stackNum = 0;
    int stackPlateNum = 0;
    int targetPlateNum = 0;
    int maxFinalValue = 0;

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
      stackNum = scanner.nextInt();
      stackPlateNum = scanner.nextInt();
      targetPlateNum = scanner.nextInt();

      stackStartIdx = null;
      stackStartIdx = new int[stackNum];

      stackN = null;
      stackN = new float[stackNum][];
      for(int i = 0; i < stackNum; i++)
      {
        stackN[i] = new float[stackPlateNum];
      }

      stackNOrg = null;
      stackNOrg = new int[stackNum][];
      for(int i = 0; i < stackNum; i++)
      {
        stackNOrg[i] = new int[stackPlateNum];
      }

      int scannerInt = 0;
      for(int i = 0; i < stackNum; i++)
      {
        stackStartIdx[i] = 0;
        for(int j = 0; j < stackPlateNum; j++)
        {
          stackNOrg[i][j] = 0;
          stackN[i][j] = 0;
          scannerInt = scanner.nextInt();
          if(j == 0)
          {
            stackNOrg[i][j] = scannerInt;
            stackN[i][j] = (float)scannerInt / (j + 1);
            continue;
          }
          stackNOrg[i][j] = scannerInt;
          stackN[i][j] = (stackN[i][j - 1] * j + (float)scannerInt) / (j + 1);
        }
      }

      /// Check input sum
      // for(int i = 0; i < stackNum; i++)
      // {
      //   for(int j = 0; j < stackPlateNum; j++)
      //   {
      //     System.out.print(String.format("%.4f", stackN[i][j]) + " ");
      //   }
      //   System.out.println("");
      // }
      
      // for(int i = 0; i < stackNum; i++)
      // {
      //   for(int j = 0; j < stackPlateNum; j++)
      //   {
      //     System.out.print(String.format("%d", stackNOrg[i][j]) + " ");
      //   }
      //   System.out.println("");
      // }
      
      ///--------------------------------------------------///
      /// solution start
      ///--------------------------------------------------///
      maxFinalValue = 0;
      while(targetPlateNum > 0)
      {
        int getPlateIdx = 0;
        int getPlateStack = 0;
        float tempMax = 0.0f;
        for(int i = 0; i < stackNum; i++)
        {
          for(int j = stackStartIdx[i]; j < stackPlateNum; j++)
          {
            if(targetPlateNum < (j - stackStartIdx[i] + 1))
            {
              break;
            }
            if(tempMax < stackN[i][j])
            {
              tempMax = stackN[i][j];
              getPlateIdx = j;
              getPlateStack = i;
            }
          }
        }

        /// check plate cnt 
        int getPlateCnt = getPlateIdx + 1;
        stackStartIdx[getPlateStack] = getPlateCnt;
        for(int j = 0; j < getPlateCnt; j++)
        {
          if(stackN[getPlateStack][j] == 0)
          {
            getPlateCnt = getPlateCnt - 1;
          }
        }

        //System.out.println(String.format("Get stack %d, the %d plate", getPlateStack, getPlateIdx));
        targetPlateNum = targetPlateNum - getPlateCnt; 

        /// update get stack value & maxFinalValue
        for(int j = 0; j <= getPlateIdx; j++)
        {
          maxFinalValue = maxFinalValue + stackNOrg[getPlateStack][j];
          stackN[getPlateStack][j] = 0;
          stackNOrg[getPlateStack][j] = 0;
        }

        //// update array 
        int remainPlate = 0;
        for(int j = 0; j < stackPlateNum; j++)
        {
          if(stackNOrg[getPlateStack][j] == 0)
          {
            continue;
          }

          remainPlate = remainPlate + 1;
          // stackN[getPlateStack][j] = 0;
          // if(remainPlate == 1)
          // {
          //   stackN[getPlateStack][j] = (float)stackNOrg[getPlateStack][j];
          //   continue;
          // }
          // stackN[getPlateStack][j] = ((stackN[getPlateStack][j - 1] * (remainPlate - 1))+ (float)stackNOrg[getPlateStack][j]) / (float)remainPlate;
          
          stackN[getPlateStack][j] = 0;
          for(int i = 0; i <= j; i++)
          {
            stackN[getPlateStack][j] = stackN[getPlateStack][j] + (float)stackNOrg[getPlateStack][i];
          }
          stackN[getPlateStack][j] = stackN[getPlateStack][j] / (float)remainPlate;
        
        }
      }

      ///--------------------------------------------------///
      /// solution end
      ///--------------------------------------------------///
      testIdx = testIdx + 1; 
      System.out.println("Case #" + testIdx + ": " + maxFinalValue);
    }
  }
}