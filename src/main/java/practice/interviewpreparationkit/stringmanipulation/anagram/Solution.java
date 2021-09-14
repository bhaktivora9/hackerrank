package practice.interviewpreparationkit.stringmanipulation.anagram;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
  
  /**
   * A student is taking a cryptography class and has found anagrams to be very
   * useful. Two strings are anagrams of each other if the first string's
   * letters can be rearranged to form the second string. In other words, both
   * strings must contain the same exact letters in the same exact frequency.
   * For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.
   * 
   * The student decides on an encryption scheme that involves two large
   * strings. The encryption is dependent on the minimum number of character
   * deletions required to make the two strings anagrams. Determine this number.
   * 
   * Given two strings,a and b, that may or may not be of the same length,
   * determine the minimum number of character deletions required to make a and
   * b anagrams. Any characters can be deleted from either of the strings.
   * 
   * @param a
   * @param b
   * @return
   */
  
  // Complete the makeAnagram function below.
  static int makeAnagram(String a, String b)
  {
    Stream<Character> characterStreamA = a.chars()
        .mapToObj(c -> (char) c);
    HashMap<Character, Long> freqA = characterStreamA
        .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
    Stream<Character> characterStreamB = b.chars()
        .mapToObj(c -> (char) c);
    HashMap<Character, Long> freqB = characterStreamB
        .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
    
    int toDeleteA = freqA.entrySet()
        .parallelStream()
        .mapToInt(f -> {
          int diff;
          Character c = f.getKey();
          Long value1 = f.getValue();
          if (freqB.containsKey(c)) {
            Long value2 = freqB.get(c);
            freqB.remove(c);
            diff = (int) ((value1 - value2 > 0) ? value1 - value2 : value2 - value1);
          }
          else {
            diff = value1.intValue();
          }
          return diff;
        })
        .sum();
    
    int toDeleteB = freqB.entrySet()
        .parallelStream()
        .mapToInt(f -> {
          int diff;
          Character c = f.getKey();
          Long value1 = f.getValue();
          if (freqA.containsKey(c)) {
            Long value2 = freqA.get(c);
            diff = (int) ((value1 - value2 > 0) ? value1 - value2 : value2 - value1);
          }
          else {
            diff = value1.intValue();
          }
          return diff;
        })
        .sum();
    
    return (toDeleteA + toDeleteB);
    
  }
  
  private static final Scanner scanner = new Scanner(System.in);
  
  public static void main(String[] args) throws IOException
  {
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));
    
    String a = scanner.nextLine();
    
    String b = scanner.nextLine();
    
    int res = makeAnagram(a, b);
    
    bufferedWriter.write(String.valueOf(res));
    bufferedWriter.newLine();
    
    bufferedWriter.close();
    
    scanner.close();
  }
}
