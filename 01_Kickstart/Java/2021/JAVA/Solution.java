import java.util.Arrays;
import java.util.Scanner;

public class Solution
{
  private static int solution1(int treeCnt, int capacity, int[] treeForms) 
  {
    int ans = -1;
    long[][] treeBunches;
    treeBunches = new long[treeCnt + 1][treeCnt + 1];

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

    return ans;
  }

  private static int solution2(int treeCnt, int capacity, int[] treeForms) 
  {
    int ans = -1;
    int[] best = new int[capacity + 1];

    for(int i = 0; i <= capacity; i++)
    {
      best[i] = Integer.MAX_VALUE;
    }
// capacity :
//     10

// origial : 
//     5 2 6 8 3

// accumulate :
//     0  5 7 13 21 24      

// best : 
//     0  1  2  3  4  5  6  7  8  9  10
//           1  1     1  1     1      
  
// 24
// 21
// 13   


///======================================================///
    // for(int i = 0; i < treeCnt; i++)
    // {
    //   int count = 0;
    //   for(int j = i; j < treeCnt; j++) 
    //   {
    //       count += treeForms[j];
    //       if(count <= capacity)
    //       {
    //           best[count] = Math.min(best[count], j - i + 1);
    //       }
    //   }
    //   System.out.println(Arrays.toString(best));

    //   int currSum = 0;
    //   for(int j = i - 1; j >= 0; j--)
    //   {
    //     currSum += treeForms[j];
    //     System.out.println("[" + j + "] = " + currSum);
    //     if(currSum <= capacity) 
    //     {
    //       if(best[capacity - currSum] == Integer.MAX_VALUE)
    //       {
    //           continue;
    //       }
    //       System.out.println("ans compare : " + ans + ", " + String.valueOf(i - j + best[capacity - currSum]));
    //       ans = Math.min(ans, i - j + best[capacity - currSum]);
    //     }
    //   }
    // }

  //   System.out.println("==========================================================");
  /// repeat get 
  //   int bestCurrent = 0;
  //   for(int j = 1; j < capacity + 1; j++) 
  //   {
  //     if(best[j] == Integer.MAX_VALUE || best[capacity - j] == Integer.MAX_VALUE)
  //     {
  //         continue;
  //     }
  //     bestCurrent = best[j] + best[capacity - j];
  //     best[capacity] = Math.min(best[capacity], bestCurrent);
  //     System.out.println(Arrays.toString(best));
  //   }
    
///======================================================///
  //   for(int i = treeCnt - 1; i >= 0; i--)
  //   {
  //     int count = 0;
  //     for(int j = i; j < treeCnt; j++) 
  //     {
  //         count += treeForms[j];
  //         if(count <= capacity)
  //         {
  //             best[count] = Math.min(best[count], j - i + 1);
  //         }
  //     }
  //     System.out.println(Arrays.toString(best));
  //   }

    if(ans == Integer.MAX_VALUE) 
    {
      ans = -1;
    }
    /// Sol. 2
  // for i = 0 to K:
  //   Best[i] = inf
  // ans = inf

  // for i = N to 1:
  //   currSum = 0
  //   for j = i to 1:
  //     // |currSum| denotes sum of subarray(j, i).
  //     currSum += B[j]
  //     if currSum <= K:
  //       // Best[K - currSum] denotes the minimum length of subarray starting after index i which has sum equal to K - currSum.
  //       ans = min(ans, j - i + 1 + Best[K - currSum])

  //   currPostSum = 0
  //   for x = i to N:
  //     // |currPostSum| denotes sum of subarray(i, x).
  //     currPostSum += B[x]
  //     if currPostSum <= K:
  //       // Update the minimum length of subarray with sum equal to |currPostSum|.
  //       Best[currPostSum] = min(Best[currPostSum], x - i + 1)

// treeCnt = N;
// capacity = K;
    // int[] best = new int[capacity];
    // int currSum = 0;
    // int currPostSum = 0;
    // for(int i = 0; i < capacity; i++) {
    //   best[i] = -1;
    // }

    // for(int i = treeCnt - 1; i > 0; i--) {
    //   currSum = 0;
    //   for(int j = i; j > 0; j--) {
    //     currSum += treeForms[j];
    //     if(currSum <= capacity) {
    //       ans = Math.min(ans, j - i + 1 + best[capacity - currSum]);
    //     }
    //   }
    //   currPostSum = 0;
    //   for(int x = i; x < treeCnt; x++) {
    //     currPostSum += treeForms[x];
    //     if(currPostSum <= capacity) {
    //       best[currPostSum] = Math.min(best[currPostSum], x - i + 1);
    //     }
    //   }
    // }

    return ans;
  }

  private static int solution3(int treeCnt, int capacity, int[] treeForms) 
  {
    int ans = -1;
    int[] best = new int[capacity + 1];

    for(int i = 0; i <= capacity; i++)
    {
      best[i] = Integer.MAX_VALUE;
    }

    for(int i = 0; i < treeCnt; i++)
    {
      int count = 0;
      for(int j = i; j < treeCnt; j++) 
      {
        count += treeForms[j];
        if(count <= capacity)
        {
          best[count] = Math.min(best[count], j - i + 1);
        } 
      }
      System.out.println(Arrays.toString(best));

      int currSum = 0;
      for(int j = i - 1; j >= 0; j--)
      {
        currSum += treeForms[j];
        System.out.println("[" + j + "] = " + currSum);
        if(currSum <= capacity) 
        {
          if(best[capacity - currSum] == Integer.MAX_VALUE)
          {
            continue;
          }
          System.out.println("ans compare : " + ans + ", " + String.valueOf(i - j + best[capacity - currSum]));
          ans = Math.min(ans, i - j + best[capacity - currSum]);
        }
      }
    }

    if(ans == Integer.MAX_VALUE) 
    {
      ans = -1;
    }

    return ans;
  }

  public static void main(String[] args)
  {
    //System.out.println("2021_RoundG_3 Start");
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
    int treeCnt = 0;
    int capacity = 0;
    int[] treeForms;

    while(true)
    {
      if(testIdx >= testCnt)
      {
        break;
      }
      
      ///--------------------------------------------------///
      /// init array & variable
      ///--------------------------------------------------///
      ans = Integer.MAX_VALUE;
      treeCnt = scanner.nextInt();
      capacity = scanner.nextInt();

      treeForms = new int[treeCnt];

      for(int i = 0; i < treeCnt; i++)
      {
        treeForms[i] = scanner.nextInt();
      }

      ///--------------------------------------------------///
      /// solution start
      ///--------------------------------------------------///
      ans = solution3(treeCnt, capacity, treeForms);
      
      ///--------------------------------------------------///
      /// solution end
      ///--------------------------------------------------///
      testIdx = testIdx + 1; 

      System.out.print("Case #" + testIdx + ": " + ans);
      System.out.println("");
    }

    scanner.close();
  }
}