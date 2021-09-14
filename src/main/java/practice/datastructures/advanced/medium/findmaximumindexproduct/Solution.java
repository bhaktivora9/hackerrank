package practice.datastructures.advanced.medium.findmaximumindexproduct;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
  
  // Complete the solve function below.
  static int MAX = 100000; 

static int[] nextGreaterInLeft(int []a,  
                               int n) 
{ 
    int []left_index = new int[MAX]; 
    Stack<Integer> s = new Stack<Integer>(); 
  
    for (int i = n - 1; i >= 0; i--) 
    { 
  
        // checking if current  
        // element is greater than top 
        while (s.size() != 0 &&  
                 a[i] > a[s.peek() - 1]) 
        { 
            int r = s.peek(); 
            s.pop(); 
  
            // on index of top store  
            // the current element  
            // index which is just  
            // greater than top element 
            left_index[r - 1] = i + 1; 
        } 
  
        // else push the current 
        // element in stack 
        s.push(i + 1); 
    } 
    return left_index; 
} 
  
// function to find just next  
// greater element in right side 
static int[] nextGreaterInRight(int []a,  
                                int n) 
{ 
    int []right_index = new int[MAX]; 
    Stack<Integer> s = new Stack<Integer>(); 
    for (int i = 0; i < n; ++i) { 
  
        // checking if current element  
        // is greater than top 
        while (s.size() != 0 &&  
                    a[i] > a[s.peek() - 1])  
        { 
            int r = s.peek(); 
            s.pop(); 
  
            // on index of top store  
            // the current element index 
            // which is just greater than  
            // top element stored index  
            // should be start with 1 
            right_index[r - 1] = i + 1; 
        } 
  
        // else push the current  
        // element in stack 
        s.push(i + 1); 
    } 
    return right_index; 
}
 static int solve(int[] arr) {
     int n =arr.length;
int []left = nextGreaterInLeft(arr,n ); 
  
    // for each element storing 
    // the index of just greater 
    // element in right side 
    int []right = nextGreaterInRight(arr, n); 
    int ans = -1; 
    for (int i = 1; i <= n; i++) 
    { 
  
        // finding the max 
        // index product 
        ans = Math.max(ans, left[i] *  
                            right[i]); 
    } 
  
    return ans; 

}

  
  private static final Scanner scanner = new Scanner(System.in);
  
  public static void main(String[] args) throws IOException
  {
    /*BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));*/
    
    int arrCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
    int[] arr = new int[arrCount];
    
    String[] arrItems = scanner.nextLine()
        .split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
    for (int arrItr = 0; arrItr < arrCount; arrItr++) {
      int arrItem = Integer.parseInt(arrItems[arrItr]);
      arr[arrItr] = arrItem;
    }
    
    scanner.close();
    int result = solve(arr);
    
    /*bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();
    
    bufferedWriter.close();*/
    System.out.println(result);
    
  }
}
