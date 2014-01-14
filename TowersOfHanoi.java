Towers of Hanoi

Problem
There are 3 rods where discs can be stacked. All the discs are having different diameters. 
The goal of the game is to move all discs from one tower to another using the third tower. 
The rules are simple. Only smaller disc can go on top of the bigger discs. So the discs will
be sorted according to their sizes and bigger one will be at the bottom. Only one disc can be
moved at a time. you must put the removed disc in some tower, it cannot be left in any other places. 
At the beginning there are some discs in tower one. The goal is to move them to tower 2 following 
the above rules.

Solution
Suppose we are moving discs from tower 1 to tower 2 with the help of tower 3. We can see that the 
bigger disc of the bottom can only be moved when all top discs are moved out of tower 1. As this is 
the bigger disc it can only go to an empty rod. So this creates a subproblem. To move all the disc 
from 1 to 2, we need to move n-1 discs from 1 to 3 using 2. Now after moving the top n-1, we can move
the bottom one to tower2 as it is empty at that point. After that we need to move all discs from
tower3 to tower 2 with the help of tower 1, as this is currently empty.

/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/towers-of-hanoi.html
*/

package com.dsalgo;
import java.util.Stack;


public class TowersOfHanoi
{
	public static void main(String[] args)
	{
		Tower towerSource = new Tower("1");
		Tower towerDestination = new Tower("2");
		Tower towerHelper = new Tower("3");
		towerSource.stack.push(4);
		towerSource.stack.push(3);
		towerSource.stack.push(2);
		towerSource.stack.push(1);
		move(towerSource.stack.size(), towerSource, towerDestination,
				towerHelper);
	}

	private static void move(int size, Tower towerSource,
			Tower towerDestination, Tower towerHelper)
	{
		if (towerSource.stack.isEmpty())
			return;
		if (size == 1)
		{
			System.out.println("Move " + towerSource.stack.peek()
					+ " from tower " + towerSource.name + " to tower "
					+ towerDestination.name);
			towerDestination.stack.push(towerSource.stack.pop());
			return;
		}
		move(size - 1, towerSource, towerHelper, towerDestination);
		move(1, towerSource, towerDestination, towerHelper);
		move(size - 1, towerHelper, towerDestination, towerSource);
	}

	private static class Tower
	{
		public String name;
		public Stack<Integer> stack = new Stack<Integer>();

		public Tower(String name)
		{
			this.name = name;
		}
	}
}
