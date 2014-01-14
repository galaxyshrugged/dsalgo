Problem

Implement a stack which provides an efficient get minimum function along with 
regular push and pop functionality.
Brute force

In normal implementation of the stack with array or linked list the push and pop has
O(1) complexity, But the brute force implementation of get minimum will result in a O(n) complexity.
Solution

We can implement a O(1) complexity for push, pop and get minimum by using O(n) extra space. 
In this solution we keep another stack for minimum calculation. Whenever a new number is inserted 
if it is smaller than the stack top it is inserted into this special stack otherwise the minimum is
again inserted into the special stack. When get minimum is called, top of minimum stack is returned.
When a number is popped from the stack, one number is popped from the min stack also. This can be done
in other way also, if the number being inserted is bigger than the min stack top, nothing is done on
the min stack. when a number is popped min stack is popped only when its top is equal to the number.
But the former one is easy to code and both has same complexity.
/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/StackMinimum.php.html
*/

package com.dsalgo;

import java.util.Stack;

public class StackMinimum
{
 private Stack<Integer> stack = new Stack<Integer>();
 private Stack<Integer> minStack = new Stack<Integer>();

 public Integer push(Integer item)
 {
  if(stack.empty())
  {
   stack.push(item);
   minStack.push(item);
   return item;
  }
  Integer currentMin=minStack.peek();
  if(currentMin < item)
   minStack.push(currentMin);
  else
   minStack.push(item);
  stack.push(item);
  return item;
 }

 public Integer pop()
 {
  if(stack.size()==0)
   return null;
  minStack.pop();
  return stack.pop();
 }
 
 public Integer getMinimum()
 {
  if(minStack.empty())
   return null;
  return minStack.peek();
 }
 
 public int size()
 {
  return stack.size();
 }

}
        
