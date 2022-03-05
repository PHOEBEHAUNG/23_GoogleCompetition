import java.util.*;

public class Solution {
  private static String getRuler(String kingdom) {
    // TODO: implement this method to determine the ruler name, given the kingdom.
    String ruler = "";
    String ruler1 = "Alice";
    String ruler2 = "Bob";
    String ruler3 = "nobody";

    switch(kingdom.charAt(kingdom.length() - 1)) {
      case 'A':
        ruler = ruler1;
        break;
      case 'E':
        ruler = ruler1;
        break;
      case 'I':
        ruler = ruler1;
        break;
      case 'O':
        ruler = ruler1;
        break;
      case 'U':
        ruler = ruler1;
        break;
      case 'a':
        ruler = ruler1;
        break;
      case 'e':
        ruler = ruler1;
        break;
      case 'i':
        ruler = ruler1;
        break;
      case 'o':
        ruler = ruler1;
        break;
      case 'u':
        ruler = ruler1;
        break;
      case 'y':
        ruler = ruler3;
        break;
      case 'Y':
        ruler = ruler3;
        break;
      default:
        ruler = ruler2;
        break;
    }
    return ruler;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int T = in.nextInt();

      for (int t = 1; t <= T; ++t) {
        String kingdom = in.next();
        System.out.println(
            "Case #" + t + ": " + kingdom + " is ruled by " + getRuler(kingdom) + ".");
      }
    }
  }
}
