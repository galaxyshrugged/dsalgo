You are given a binary tree where each node has an integer value
, a left, right and parent pointer. Every node is an independent 
distributed system where a thread is running in each node. You can
talk to other node only by one method called "send(node, data)".
And a node can call "send" only to its children or parent. How will 
you design the system so that all the nodes know the total sum of values of all
the nodes in the binary tree and report them asynchronously.

/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/distributed-binary-tree-sum.html
*/

package com.dsalgo;

public class DistributedSystemSum
{
 public static volatile boolean startFlag = false;

 public static void main(String[] args)
 {
  Node a = new Node(1);
  Node b = new Node(2);
  Node c = new Node(3);
  Node d = new Node(4);
  Node e = new Node(5);
  Node f = new Node(6);
  Node g = new Node(7);
  Node h = new Node(8);
  a.left = b;
  b.parent = a;
  a.right = c;
  c.parent = a;
  b.left = d;
  d.parent = b;
  c.left = e;
  e.parent = c;
  c.right = f;
  f.parent = c;
  f.left = g;
  g.parent = f;
  f.right = h;
  h.parent = f;
  startFlag = true;
 }

 private static class Node
 {
  Node parent;
  Node left;
  Node right;
  int value;
  int sum = 0;
  int receiveCount = 0;

  public Node(int value)
  {
   this.value = value;
   NodeRunner nodeRunner = new NodeRunner(this, value);
   new Thread(nodeRunner).start();
  }

  public synchronized void send(Integer data)
  {
   sum += data;
   receiveCount++;
  }

  public synchronized int getReceivedCount()
  {
   return receiveCount;
  }
 }

 private static class NodeRunner implements Runnable
 {
  Node node;
  int id;

  NodeRunner(Node node, int id)
  {
   this.node = node;
   this.id = id;
  }

  @Override
  public void run()
  {
   while (!DistributedSystemSum.startFlag)
   {
   }
   int childCount = 0;
   if (node.left != null)
    childCount++;
   if (node.right != null)
    childCount++;
   while (node.getReceivedCount() != childCount)
   {
   }
   int sum = node.sum + node.value;
   node.sum = 0;
   if (node.parent != null)
   {
    node.parent.send(sum);
    while (node.getReceivedCount() != childCount + 1)
    {
    }
   } else
   {
    node.sum = sum;
   }
   if (node.left != null)
    node.left.send(node.sum);
   if (node.right != null)
    node.right.send(node.sum);
   System.out.println("Thread id=" + id + " sum=" + node.sum);

  }

 }
}

