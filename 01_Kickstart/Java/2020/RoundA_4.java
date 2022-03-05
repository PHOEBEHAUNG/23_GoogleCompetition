package phoebe.kickstart.year2020;

import java.util.Scanner;
import java.util.Arrays;

public class RoundA_4
{
  public static void main(String[] args)
  {
    /// System.out.println("2020_RoundA_4 Start");

    Scanner scanner = new Scanner(System.in);
    ///--------------------------------------------------///
    /// question variable
    ///--------------------------------------------------///
    int totalStrCnt = 0;
    int targetGroup = 0;
    String[] strings;

    ///--------------------------------------------------///
    int testCnt = 0;
    int testIdx = 0;
    testCnt = scanner.nextInt();
    
    System.out.println("Get testCnt : " + testCnt);
    while(true)
    {
      if(testIdx >= testCnt)
      {
        break;
      }

      ///--------------------------------------------------///
      /// init array & variable
      ///--------------------------------------------------///
      totalStrCnt = scanner.nextInt();
      targetGroup = scanner.nextInt();
      strings = null;

      strings = new String[totalStrCnt];
      for(int i = 0; i < totalStrCnt; i++)
      {
        strings[i] = scanner.next();
      }

      ///--------------------------------------------------///
      /// Check input 
      ///--------------------------------------------------///
      
      
      ///--------------------------------------------------///
      /// solution start
      ///--------------------------------------------------///
      
      ///--------------------------------------------------///
      /// solution end
      ///--------------------------------------------------///
      testIdx = testIdx + 1; 
      System.out.println("Case #" + testIdx + ": " + testIdx);
    }
  }
}














import java.util.Scanner;

public class RoundA_4_2020 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCasesNumber = in.nextInt();
        for (int i = 0; i < testCasesNumber; i++){
            int n = in.nextInt();
            int k = in.nextInt();
            String[] strings = new String[n];
            for (int string = 0; string < n; string++){
                strings[string] = in.next();
            }
            System.out.printf("Case #%d: %d\n", i + 1, maxScoreSum(strings, k));
        }
    }

    public static int maxScoreSum(String[] strings, int groupSize){
        TrieNode root = new TrieNode();
        for (String word : strings){
            root.insert(word);
        }
        return root.count(groupSize); // find the max sum of scores possible
    }

    private static class TrieNode {
        private final TrieNode[] children;
        private char content;
        /**
         * The number of strings where the prefix occurred.
         */
        private int count;

        public TrieNode() {
            int count = 0;
            children = new TrieNode[26];
        }

        public TrieNode(char content){
            this();
            this.content = content;
        }

        /**
         * Inserts a new word to the trie.
         *
         * @param word  the word
         */
        public void insert(String word){
            insert(word.toCharArray(), 0);
        }

        /**
         * Inserts a word's character to the trie and updates the count.
         *
         * @param word  the word
         * @param index  the character's index
         */
        private void insert(char[] word, int index){
            if (word.length == index)
                return;
            char letter = word[index];
            if (children[letter - 'A'] == null)
                children[letter - 'A'] = new TrieNode(letter);
            children[letter - 'A'].count++;
            children[letter - 'A'].insert(word, index + 1);
        }

        /**
         * Counts the number of bundles the prefix of the trie contributed to
         * and finds the sum of this counts for all prefixes of the trie.
         *
         * @param groupSize  the group size
         * @return the sum of numbers of bundles each prefix of the trie contributed to
         */
        public int count(int groupSize){
            int generalCount = this.count / groupSize;
            for (int i = 0; i < 26; i++){
                if (children[i] != null){
                    generalCount += children[i].count(groupSize);
                }
            }
            return generalCount;
        }
    }
}