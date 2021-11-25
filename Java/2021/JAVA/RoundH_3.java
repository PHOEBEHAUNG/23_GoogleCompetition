import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class RoundH_3
{
  public static void println(String msg) {
    //System.out.println(msg);
  }
  
  public static void main(String[] args)
  {
    println("2021_RoundH_1 Start");
    Scanner scanner = new Scanner(System.in);

    ///--------------------------------------------------///
    int testCnt = 0;
    int testIdx = 0;
    testCnt = scanner.nextInt();

    println("Get testCnt : " + testCnt);

    ///--------------------------------------------------///
    String ans = "";

    ///--------------------------------------------------///
    /// test case variable
    int strLength;
    String str;

    while(true)
    {
      if(testIdx >= testCnt)
      {
        break;
      }
      
      ///--------------------------------------------------///
      /// init array & variable
      ///--------------------------------------------------///
      ans = "";
      strLength = scanner.nextInt();;
      str = scanner.next();

      /// how to find the patterns  
      ///--------------------------------------------------///
      /// solution start
      ///--------------------------------------------------///
      String processStartStr = str;
      String processEndStr = str;
      String[] patterns = {"01", "12", "23", "34", "45", "56", "67", "78", "89", "90"};

      while(true) {
        for(int i = 0; i < patterns.length; i++) {
          String pattern = patterns[i];
          switch(pattern) {
            case "01":
              processEndStr = processEndStr.replace(pattern, "2");
              break;
            case "12":
              processEndStr = processEndStr.replace(pattern, "3");
              break;
            case "23":
              processEndStr = processEndStr.replace(pattern, "4");
              break;
            case "34":
              processEndStr = processEndStr.replace(pattern, "5");
              break;
            case "45":
              processEndStr = processEndStr.replace(pattern, "6");
              break;
            case "56":
              processEndStr = processEndStr.replace(pattern, "7");
              break;
            case "67":
              processEndStr = processEndStr.replace(pattern, "8");
              break;
            case "78":
              processEndStr = processEndStr.replace(pattern, "9");
              break;
            case "89":
              processEndStr = processEndStr.replace(pattern, "0");
              break;
            case "90":
              processEndStr = processEndStr.replace(pattern, "1");
              break;
          }
        }

        if(processEndStr.equals(processStartStr)) {
          break;
        }

        processStartStr = processEndStr;
      }

      ans = processEndStr;
      ///--------------------------------------------------///
      /// solution end
      ///--------------------------------------------------///
      testIdx = testIdx + 1; 

      System.out.print("Case #" + testIdx + ": " + ans);
      System.out.println("");
    }
  }
}