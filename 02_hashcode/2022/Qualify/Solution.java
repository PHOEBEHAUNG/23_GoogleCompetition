import java.util.*;
import java.io.*;

/**
 * Data Structure
 * 
 * Map<String, Map<String, Integer>> skillMaps = new HashMap<>();
 * Map<String, Map<String, Integer>> projectPropMaps = new HashMap<>();
 * "duration", "score", "bestbefore", "skillnum"
 * Map<String, Map<String, List<Integer>>> projectSkillMaps = new HashMap<>();
 */
public class Solution
{
  public static List<String> participateList;
  public static String findExecutableProject(Map<String, Map<String, Integer>> skillMaps, Map<String, Map<String, List<Integer>>> projectSkillMaps, List<String> projectRemain) {
    String res = "";
    
    participateList = new ArrayList<>();
    //System.out.println("====================================================");
    for(String project : projectRemain) {
      participateList.clear();
      // System.out.println("Check projectRemain Size: " + projectRemain.size());
      Map<String, List<Integer>> needSkill = projectSkillMaps.get(project);
      int needSkillCnt = 0;

      for(Map.Entry<String, List<Integer>> entry : needSkill.entrySet()) {
        needSkillCnt = needSkillCnt + entry.getValue().size();
      }

      int participateCnt = 0;

      /// Key point
      for(Map.Entry<String, List<Integer>> entry1 : needSkill.entrySet()) {
        boolean select = false;
        // System.out.println("Check skill : " + entry1.getKey());
        for(int i = 0; i < entry1.getValue().size(); i++) {
          for(Map.Entry<String, Map<String, Integer>> entry2 : skillMaps.entrySet()) {
            if(participateList.contains(entry2.getKey())) {
              continue;
            }
            // System.out.println("Check person skill start : " + entry2.getKey());
            Map<String, Integer> personSkill = entry2.getValue();

            for(Map.Entry<String, Integer> entry3 : personSkill.entrySet()) {
              String skill = entry3.getKey();
              int level = entry3.getValue();

              if(level >= entry1.getValue().get(i) && skill.equals(entry1.getKey())) {
                participateList.add(entry2.getKey());
                participateCnt++;
                select = true;
                break;
              }
            }
            if(select) {
              break;
            }
          }
        }
      }

      if(needSkillCnt == participateCnt) {
        // System.out.println("project finish : " + project + ", needSkillCnt : " + needSkillCnt+ ", participateCnt : " + needSkillCnt);
        res = project;
        break;
      }
    }
    return res;
  }

  public static List<String> findContributor(Map<String, Map<String, Integer>> skillMaps, Map<String, Map<String, List<Integer>>> projectSkillMaps, String project) {
    List<String> res = new ArrayList<>();

    return res;
  }

  public static void updateLevel(List<String> contributorList, Map<String, Map<String, Integer>> skillMaps, Map<String, Map<String, List<Integer>>> projectSkillMaps, String project) {
    
  }

  public static void main(String[] args) throws FileNotFoundException
  {
    ////System.out.println("RoundPractice Start");
    String fName = args[0];
    File f = new File(".\\input_data\\" + fName + ".in.txt");
    Scanner scanner = new Scanner(f);
    Map<String, Map<String, Integer>> skillMaps = new LinkedHashMap<>();
    Map<String, Map<String, Integer>> projectPropMaps = new LinkedHashMap<>();
    Map<String, Map<String, List<Integer>>> projectSkillMaps = new LinkedHashMap<>();

    List<String> projectRemain = new ArrayList<>();
    ///--------------------------------------------------///
    int contributorNum = 0;
    int projectNum = 0;
    contributorNum = scanner.nextInt();
    projectNum = scanner.nextInt();

    scanner.nextLine();
    //System.out.println("Get contributorNum : " + contributorNum);
    //System.out.println("Get projectNum : " + projectNum);

    int index = 0;
    while(true)
    {
      if(index >= contributorNum)
      {
        break;
      }

      ///--------------------------------------------------///
      /// init array & variable
      ///--------------------------------------------------///
      String name = scanner.next();
      int skillCount = scanner.nextInt();
      scanner.nextLine();

      skillMaps.put(name, skillMaps.getOrDefault(name, new LinkedHashMap<>()));
      //System.out.println("======================================================");
      //System.out.println("contributor name : " + name);
      //System.out.println("contributor skill number : " + skillCount);
      index = index + 1; 
      //System.out.println("Contributor #" + index);
      
      for(int i = 0; i < skillCount; i++) {
        String skillName = scanner.next();
        int skillLevel = scanner.nextInt();
        scanner.nextLine();
        //System.out.println("skillName " + skillName + ", skillLevel " + skillLevel);

        Map<String, Integer> maps = skillMaps.get(name);
        maps.put(skillName, skillLevel);
        skillMaps.put(name, maps);
      }
    }

    /// Check Contributor
    //System.out.println("********************************************************");
    for(Map.Entry<String, Map<String, Integer>> entry1 : skillMaps.entrySet()) {
      Map<String, Integer> maps = entry1.getValue();
      //System.out.println("contributor name " + entry1.getKey());
      for(Map.Entry<String, Integer> entry2 : maps.entrySet()) {
        //System.out.println("skill name " + entry2.getKey());
        //System.out.println("skill level " + entry2.getValue());
      }
    }

    index = 0;
    while(true)
    {
      if(index >= projectNum)
      {
        break;
      }

      ///--------------------------------------------------///
      /// init array & variable
      ///--------------------------------------------------///
      String name = scanner.next();
      int duration = scanner.nextInt();
      int score = scanner.nextInt();
      int bestbefore = scanner.nextInt();
      int skillnum = scanner.nextInt();
      scanner.nextLine();

      projectPropMaps.put(name, projectPropMaps.getOrDefault(name, new LinkedHashMap<>()));
      projectRemain.add(name);

      Map<String, Integer> maps = projectPropMaps.get(name);
      maps.put("duration", duration);
      maps.put("score", score);
      maps.put("bestbefore", bestbefore);
      maps.put("skillnum", skillnum);
      projectPropMaps.put(name, maps);

      // System.out.println("======================================================");
      // System.out.println("project name : " + name);
      // System.out.println("duration : " + maps.get("duration"));
      // System.out.println("score : " + maps.get("score"));
      // System.out.println("bestbefore : " + maps.get("bestbefore"));
      // System.out.println("skillnum : " + maps.get("skillnum"));

      index = index + 1; 
      //System.out.println("Project #" + name);
      
      for(int i = 0; i < skillnum; i++) {
        String skillName = scanner.next();
        int skillLevel = scanner.nextInt();
        scanner.nextLine();

        Map<String, List<Integer>> maps2 = projectSkillMaps.getOrDefault(name, new LinkedHashMap<>());
        List<Integer> skillLevelList = maps2.getOrDefault(skillName, new ArrayList<>());
        skillLevelList.add(skillLevel);
        maps2.put(skillName,skillLevelList);
        projectSkillMaps.put(name, maps2);
      }
    }

    /// Check Project
    //System.out.println("********************************************************");
    for(Map.Entry<String, Map<String, List<Integer>>> entry1 : projectSkillMaps.entrySet()) {
      Map<String, List<Integer>> maps = entry1.getValue();
     
      //System.out.println("project name " + entry1.getKey());
      for(Map.Entry<String, List<Integer>> entry2 : maps.entrySet()) {
        //System.out.println("skill name " + entry2.getKey());
        //System.out.println("skill level " + entry2.getValue());
      }
    }

    scanner.close();
    ///--------------------------------------------------///
    /// solution start
    ///--------------------------------------------------///
    Map<String, List<String>> participateMaps = new LinkedHashMap<>(); /// ans 

    while(true) {
      String finishProject = findExecutableProject(skillMaps, projectSkillMaps, projectRemain);
      if(!finishProject.equals("")) {
        projectRemain.remove(finishProject);
        //System.out.println("Project remove : " + finishProject);
        // List<String> contributorList = findContributor(skillMaps, projectSkillMaps, finishProject);
        List<String> contributorList = participateList;
        //System.out.println("ParticipateList size : " + contributorList.size());
        participateMaps.put(finishProject, contributorList);
        updateLevel(contributorList, skillMaps, projectSkillMaps, finishProject);
      } else {
        break;
      }
    }
    ///--------------------------------------------------///
    /// solution end
    ///--------------------------------------------------///
    /**
      3
      WebServer
      Bob Anna
      Logging
      Anna
      WebChat
      Maria Bob
     */
    String fileName = ".\\output_data\\" + fName + ".out.txt";
    String encoding = "UTF-8";

    try {
      PrintWriter writer = new PrintWriter(fileName, encoding);
      writer.println("" + participateMaps.size());
      for(Map.Entry<String, List<String>> entry1 : participateMaps.entrySet()) {
        writer.println("" + entry1.getKey());
        for(String contributor : entry1.getValue()) {
          writer.print("" + contributor + " ");
        }
        writer.println("");
      }
      writer.close();
    }
    catch (IOException e) {
      // //System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}