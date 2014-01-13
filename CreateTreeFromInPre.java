Create a binary tree from given inorder and preorder traversal.
Solution

The first node in the preorder traversal is the root. Now if we try to find the root node
in the inorder array, all the elements to its left will be in left subtree of root and elements
to its right will be in right subtree of root. We recursively call the function for its left and 
right and continuously increase the preorder index. As java does not support pass by reference,
we will pass an single element array so that the value change can be reflected outside the function.



/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/CreateTreeFromInPre.php.html
*/

package com.dsalgo;

public class CreateTreeFromInPre
{
 public static void main(String[] args)
 {
  int[] inorder =
  { 4, 2, 5, 1, 6, 3 };
  int[] preorder =
  { 1, 2, 4, 5, 3, 6 };
  Node root = buildBinaryTree(inorder, preorder);
  printNice(root);
 }

 public static Node buildBinaryTree(int[] inorder, int[] preorder)
 {
  return buildBinaryTree(inorder, 0, inorder.length, preorder, new int[]
  { 0 });
 }

 private static Node buildBinaryTree(int[] inorder, int inStartIndex,
   int inEndIndex, int[] preorder, int[] preIndex)
 {
  if (preIndex[0] == preorder.length)
   return null;
  Node root = new Node(preorder[preIndex[0]]);
  int findIndex = -1;
  for (int i = inStartIndex; i < inEndIndex; ++i)
  {
   if (preorder[preIndex[0]] == inorder[i])
   {
    findIndex = i;
   }
  }
  if (findIndex == -1)
   return null;
  preIndex[0]++;
  root.left = buildBinaryTree(inorder, inStartIndex, findIndex, preorder,
    preIndex);
  root.right = buildBinaryTree(inorder, findIndex + 1, inEndIndex,
    preorder, preIndex);
  return root;
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
        
