package datastructures.heap.easy.qheap1.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

@SuppressWarnings("unused")

public class Solution {
  
  class Node {
    
    int  value;
    Node left = null, right = null;
    
    public int getValue()
    {
      return value;
    }
    
    public void setValue(int value)
    {
      this.value = value;
    }
    
    public Node getLeft()
    {
      return left;
    }
    
    public void setLeft(Node left)
    {
      this.left = left;
    }
    
    public Node getRight()
    {
      return right;
    }
    
    public void setRight(Node right)
    {
      this.right = right;
    }
    
    public Node(int value)
    {
      this.value = value;
    }
    
  }
  
  class Heap {
    
    Node root = null;
    
    public Heap(Node root)
    {
      super();
      this.root = root;
    }
    
    public Heap()
    {
      super();
    }
    
    public void addNode(Node n)
    {
      
    }
    
    public List<Node> lastNode()
    {
      return null;
      
    }
    
    public void addRoot(Node n)
    {
      this.root = n;
    }
    
    public boolean isEmpty()
    {
      return (this.root == null) ? true : false;
    }
    
    public Node getRoot()
    {
      return root;
    }
    
    public void getTraverseLeft()
    {
      // TODO Auto-generated method stub
      
    }
    
    public void getTraverseRight()
    {
      Node node = this.root.right;
      Stack<Node> stack = new Stack<>();
      stack.push(node);
      while (!stack.isEmpty()&& node!=null) {
        node = stack.pop();
        Node n = node.getRight();
        n.getValue();
      }
    }
    
  }
  
  public static void main(String[] args)
  {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    System.out.println("Total -");
    Scanner scanner = new Scanner(System.in);
    int total = Integer.parseInt(scanner.nextLine()
        .trim());
    int i = 0;
    int arr[][] = new int[total][2];
    while (i < total) {
      System.out.println("Start Input -");
      String input = scanner.nextLine();
      String[] split = input.split(" ");
      int parseInt = Integer.parseInt(split[0]);
      if (split.length >= 2) {
        int value = Integer.parseInt(split[1]);
        
        if (parseInt == 1 || parseInt == 2) {
          arr[i][0] = parseInt;
          arr[i][1] = value;
        }
      }
      else {
        arr[i][0] = parseInt;
      }
      
      i++;
    }
    scanner.close();
    Solution solution = new Solution();
    solution.process(arr);
  }
  
  private void process(int[][] arr)
  {
    Heap heap = new Heap();
    LinkedList<Integer> insertArr = new LinkedList<>();
    LinkedList<Integer> delArr = new LinkedList<>();
    Arrays.stream(arr)
        .forEachOrdered(a -> {
          int key = a[0];
          int value = a[1];
          switch (key) {
            case 1:
              // insertArr.add(value);
              insert(value, heap);
              break;
            case 2:
              delArr.add(value);
              // delete(value, heap);
              break;
            case 3:
              // print(heap);
              break;
          }
        });
    System.out.println(insertArr);
  }
  
  private void insert(int value, Heap heap)
  {
    Node node = new Node(value);
    if (heap.isEmpty()) {
      heap.addRoot(node);
    }
    else {
      int rootValue = heap.getRoot()
          .getValue();
      if (value > rootValue) {
        heap.getTraverseRight();
      }
      else {
        heap.getTraverseLeft();
      }
    }
  }
  
  private void print(LinkedList<Integer> heap)
  {
    
  }
  
  private void delete(Integer value, LinkedList<Integer> heap)
  {
    
  }
  
  private void insert(Integer value, LinkedList<Integer> heap)
  {
    if (heap.isEmpty()) {
      heap.add(0, value);
    }
    else {
      Integer root = heap.get(0);
      heap.size();
      if (root > value) {
        heap.add(1, value);
      }
      else {
      }
    }
  }
}