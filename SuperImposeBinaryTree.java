Given two binary trees, find the resultant binary tree if we put one binary tree on top of another. For example,

          Below

             9
         /       \
      3          5
    /            /  \
  2            4    6

       Above

           7
       /      \
    3          8
              /
           1
              \
               5

         Result
            7
         /     \
       3        8
     /         /    \
   2        1        6
               \
                 5

Just look how the 2 and 6 are visible from the below tree and rest are covered by above tree.

/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/superimpose-binary-tree.html
*/

package com.dsalgo;

public class SuperImposeBinaryTree
{
 public static void main(String[] args)
 {
  Node a = new Node(1);
  Node b = new Node(2);
  Node c = new Node(3);
  Node d = new Node(4);
  Node e = new Node(5);
  Node f = new Node(6);
  a.left = b;
  a.right = c;
  b.left = d;
  c.left = e;
  c.right = f;

  Node u = new Node(4);
  Node v = new Node(7);
  Node w = new Node(2);
  Node x = new Node(8);
  Node y = new Node(1);
  Node z = new Node(5);

  u.left = v;
  u.right = w;
  w.left = x;
  w.right = y;
  y.right = z;
  printNice(a);
  System.out.println();
  printNice(u);
  System.out.println();
  Node result = superImpose(a, u);
  printNice(result);
 }

 private static Node superImpose(Node below, Node above)
 {
  if (above == null)
   return below;
  if (below == null)
   return above;
  above.left = superImpose(below.left, above.left);
  above.right = superImpose(below.right, above.right);
  return above;
 }

 public static void printNice(Node root)
 {
  if (root == null)
   return;
  else
  {
   System.out.print(root.value);
   if (root.left != null)
   {
    System.out.print("L->[");
    printNice(root.left);
    System.out.print("]");
   }
   if (root.right != null)
   {
    System.out.print("R->[");
    printNice(root.right);
    System.out.print("]");
   }
  }
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

  public static void printNice(Node root)
  {
   if (root == null)
    return;
   else
   {
    System.out.print(root.value);
    if (root.left != null)
    {
     System.out.print("L->[");
     printNice(root.left);
     System.out.print("]");
    }
    if (root.right != null)
    {
     System.out.print("R->[");
     printNice(root.right);
     System.out.print("]");
    }
   }
  }
 }
}

       
