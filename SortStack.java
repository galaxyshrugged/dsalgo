A stack is given which supports the following methods. Push, pop, peek and isEmpty. 
Sort this stack irrespective of its inner structure.
Solution

We will recursively pop the stack till it is empty, Then we will try to put the popped number with 
another recursive function named insertSorted. This will push to the stack if the top of the stack is
greater than the number, if it is not, then it will pop the number and call the insertSorted with the
popped number and the rest of the stack. After it returns it will push the number in correct place.


/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/sort-stack.html
*/

package com.dsalgo;

import java.util.Stack;

public class SortStack
{
	public static void main(String[] args)
	{
		Stack<Integer>stack=new Stack<Integer>();
		stack.push(5);
		stack.push(3);
		stack.push(9);
		stack.push(2);
		stack.push(6);
		sort(stack);
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
	}

	static void sort(Stack<Integer> stack)
	{
		if (stack.isEmpty())
			return;
		Integer top = stack.pop();
		sort(stack);
		insertSorted(top, stack);
		return;
	}

	static void insertSorted(Integer top, Stack<Integer> stack)
	{
		if (stack.isEmpty() || stack.peek() > top)
		{
			stack.push(top);
			return;
		}
		Integer smaller = stack.pop();
		insertSorted(top, stack);
		stack.push(smaller);
	}
}
