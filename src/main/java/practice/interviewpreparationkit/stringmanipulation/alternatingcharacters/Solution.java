package practice.interviewpreparationkit.stringmanipulation.alternatingcharacters;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Problem Statement : You are given a string containing characters and only.
 * Your task is to change it into a string such that there are no matching
 * adjacent characters. To do this, you are allowed to delete zero or more
 * characters in the string. Your task is to find the minimum number of required
 * deletions.
 * 
 * 
 * Example : s = AABAAB 
 * Remove an A at positions 0 and 3 to make s = ABAB in 2 deletions.
 * 
 * Function Description :
 * 
 *
 * alternatingCharacters has the following parameter(s):
 * 
 * string s: a string Returns
 * 
 * int: the minimum number of deletions required Input Format
 * 
 * The first line contains an integer , the number of queries. The next lines
 * each contain a string to analyze.
 * 
 * Constraints 1<= q <= 10^5 1<= length of s <= 10^5 Each string will consist
 * only of characters A and B.
 * 
 * @author Bhakti.Vora
 *
 */

public class Solution {
  
  // Complete the alternatingCharacters function below.
  static int alternatingCharacters(String s)
  {
    
    long count = IntStream.range(0, s.length() - 1)
        .parallel()
        .filter(i -> s.charAt(i) == s.charAt(i + 1)
        
        )
        .count();
        
    return (int) count;
  }
  
  private static final Scanner scanner = new Scanner(System.in);
  
  public static void main(String[] args) throws IOException
  {
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));
    
    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
    for (int qItr = 0; qItr < q; qItr++) {
      String s = scanner.nextLine();
      
      int result = alternatingCharacters(s);
      
      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }
    
    bufferedWriter.close();
    
    scanner.close();
  }
}
