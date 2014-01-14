Given a binary tree and a number, find out whether any path of the binary tree sums up to k. 
The binary tree nodes contain numbers. The path can be starting from anywhere, but it should not
skip any node in its path. It should be continuous nodes along a path which sums up to k.
Solution

We try to solve it recursively, Suppose the given sum is k and the root of the binary tree is given. 
If k is equal to the value of the root node then we will return true. If the value is not equal to k 
then we will try to find the sum (k-value) in the left and right subtree by calling the same function. 
If anyone of those returns true, that means a path exists including the root which sums up to k. But 
the path may not start at the root, it can start anywhere. So along with the two calls with 'k-value'
we call the left and right subtree with the original sum k also. If that returns true that means the path 
starts from somewhere else other than root.
/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/does-any-path-adds-up-to-given-sum.html
*/

package com.dsalgo;

public class SumPossibleAlongPathBinaryTree
{
 public static void main(String[] args)
 {
  Node a = new Node(1);
  Node b = new Node(2);
  Node c = new Node(3);
  Node d = new Node(4);
  Node e = new Node(5);
  Node f = new Node(6);
  Node g = new Node(7);
  a.left = b;
  a.right = c;
  b.left = d;
  c.left = e;
  c.right = f;
  f.left = g;

  boolean result = isSumPossibleAlongAnyPath(a, 18);
  System.out.println(result);
 }

 private static boolean isSumPossibleAlongAnyPath(Node a, int k)
 {
  return isSumPossibleAlongAnyPath(a, k, k);
 }

 private static boolean isSumPossibleAlongAnyPath(Node a, int k,int originalK)
 {
  if (k == 0)
   return true;
  if (a == null)
   return false;
  return isSumPossibleAlongAnyPath(a.left, k - a.value,originalK)
    || isSumPossibleAlongAnyPath(a.right, k - a.value,originalK)
    || isSumPossibleAlongAnyPath(a.left,originalK,originalK)
    || isSumPossibleAlongAnyPath(a.right, originalK,originalK);
 }

 static class Node
 {
  Node left;
  Node right;
  int value;

  public Node(int value)
  {
   this.value = value;
  }
 }

}


