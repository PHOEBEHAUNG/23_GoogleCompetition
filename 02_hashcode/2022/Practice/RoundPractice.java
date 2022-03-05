import java.util.*;
import java.io.*;

public class RoundPractice
{
  public static void main(String[] args) throws FileNotFoundException
  {
    //System.out.println("RoundPractice Start");
    String fName = args[0];
    File f = new File(".\\input_data\\" + fName + ".in.txt");
    Scanner scanner = new Scanner(f);
    Map<String, Integer> ingredients = new HashMap<>();

    ///--------------------------------------------------///
    int numClient = 0;
    int clientIdx = 0;
    numClient = scanner.nextInt();

    scanner.nextLine();
    // System.out.println("Get numClient : " + numClient);
    while(true)
    {
      if(clientIdx >= numClient)
      {
        break;
      }

      ///--------------------------------------------------///
      /// init array & variable
      ///--------------------------------------------------///
      String strLike = scanner.nextLine();
      String strDislike = scanner.nextLine();

      // System.out.println("============================");
      clientIdx = clientIdx + 1; 
      // System.out.println("Case #" + clientIdx);

      // System.out.println("strLike " + strLike);
      // System.out.println("strDislike " + strDislike);
      
      String[] likes = strLike.split(" ");
      for(int i = 1; i < likes.length; i++) {
        // System.out.println("likes " + likes[i]);
        ingredients.put(likes[i], ingredients.getOrDefault(likes[i], 0) + 1);
      }

      String[] disLikes = strDislike.split(" ");
      for(int i = 1; i < disLikes.length; i++) {
        // System.out.println("disLikes " + disLikes[i]);
        ingredients.put(disLikes[i], ingredients.getOrDefault(disLikes[i], 0) - 1);
      }
    }

    scanner.close();
    ///--------------------------------------------------///
    /// solution start
    ///--------------------------------------------------///
    List<String> ans = new ArrayList<>();
    for(String key : ingredients.keySet()) {
      if(ingredients.get(key) >= 0){
        ans.add(key);
      }
    }
    ///--------------------------------------------------///
    /// solution end
    ///--------------------------------------------------///
    String fileName = ".\\output_data\\" + fName + ".out.txt";
    String encoding = "UTF-8";
    try{
    PrintWriter writer = new PrintWriter(fileName, encoding);
    writer.print("" + ans.size());
    for(int i = 0; i < ans.size(); i++) {
      writer.print(" " + ans.get(i));
    }
    writer.close();
    }
    catch (IOException e){
      // System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}