package phoebe.kickstart.year2020;

import java.util.Scanner;
import java.util.Arrays;

public class RoundA_1
{
  public static void main(String[] args)
  {
    //System.out.println("2020_RoundA_1 Start");
    Scanner scanner = new Scanner(System.in);
    int[] housesPrice;

    int houseCnt = 0;
    int budget = 0;
    int maxNumHouse = 0;
    int[] housesPriceMaxNumber

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
      houseCnt = scanner.nextInt();
      budget = scanner.nextInt();
      //System.out.println("Case #" + testIdx + " : " + houseCnt + ", " + budget);
      housesPrice = new int[houseCnt];
      housesPriceMaxNumber = new int[budget + 1];

      Arrays.fill(housesPrice, 0);
      for(int i = 0; i < houseCnt; i++)
      {
        housesPrice[i] = scanner.nextInt();
        //System.out.println("House #" + i + " Price : " + housesPrice[i]);
      }

      Arrays.sort(housesPrice);
      ///--------------------------------------------------///
      /// solution start
      ///--------------------------------------------------///
      /// solution 1  /// repeat get 
      // int iTempNumHouse = 0;
      // for(int i = 0; i <= budget; i++)
      // {
      //   for(int j = 0; j < houseCnt; j++)
      //   {
      //     if(housesPrice[j] <= i)
      //     {
      //       iTempNumHouse = housesPriceMaxNumber[i - housesPrice[j]] + 1;
      //       housesPriceMaxNumber[i] = Math.max(iTempNumHouse, housesPriceMaxNumber[i]);
      //     }
      //   }
      // }
      // maxNumHouse = 0;
      // for(int i = 0; i <= budget; i++)
      // {
      //   if(maxNumHouse < housesPriceMaxNumber[i])
      //   {
      //     maxNumHouse = housesPriceMaxNumber[i];
      //   }
      //   System.out.println(i + " : " + housesPriceMaxNumber[i]);
      // }

      /// solution 2 /// don't repeat get
      int iTempSumPrice = 0;
      maxNumHouse = 0;
      for (int i = 0; i < houseCnt; i++)
      {
        //System.out.println(i + " : " + housesPrice[i]);
        if (iTempSumPrice + housesPrice[i] > budget) 
        {
          continue;
        }
        iTempSumPrice += housesPrice[i];
        ++maxNumHouse;
      }
      ///--------------------------------------------------///
      /// solution end
      ///--------------------------------------------------///
      testIdx = testIdx + 1; 
      System.out.println("Case #" + testIdx + ": " + maxNumHouse);
    }
  }
}