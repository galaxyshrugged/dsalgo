Increasing array subsequence

Problem


You are given an integer array. Find all the subsequences of the array which has the elements
in increasing order. B is a subsequence of array A if B can be formed by removing some elements 
from the array A without disturbing the order of elements. For example {2,5,6,1,3} is the input array,
Then {2,5}, {2,6}, {2,6,1}, {2,1,3} are some of its subsequences. In these {2,5}, {2,6} are increasing 
subsequences. 
Solution


We will use memoization to solve this problem. At any index i of the given array we will have a 
subproblem of finding all the increasing subsequences till the index i. Then we will check with i+1th
element. Some of these subsequences maintain the increasing property after adding this element. we will
add this i+1th element to those subsequences and add the number itself as a single element subsequence to
the previously memoized solution. As this i+1th element can itself be starting of another sequence. 
The complexity of the algorithm is output sensitive as we have to find all possible outputs.
Let there be k number of increasing subsequences possible. Then the complexity is O(n*k). 
The term k is the total possible subsequeces. Which is of the order of 2^n. So in upper bound 
term it is O(n*2^n). But this complexity will only arises when all the subsequences are increasing 
subsequences. That occurs when the given array is sorted increasingly. In a random array the value 
of k is supposed to be much less than 2^n. 


/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/back-to-content-increasing-array.html
*/

package com.dsalgo;
import java.util.ArrayList;

public class IncreasingArraySubsequence
{

	/**
	 * create subsequence of a given array where every element in the
	 * subsequence is greater than its previous element
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] input =
		{ 2, 5, 6, 1, 3 };
		int length = input.length;
		ArrayList<ArrayList<Integer>> table = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < length; ++i)
		{
			ArrayList<ArrayList<Integer>> tempTable = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> j : table)
			{
				if (j.get(j.size() - 1) <= input[i])
				{
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.addAll(j);
					temp.add(input[i]);
					tempTable.add(temp);
				}
			}
			table.addAll(tempTable);
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(input[i]);
			table.add(temp);
		}

		// output
		for (ArrayList<Integer> i : table)
		{
			for (Integer j : i)
			{
				System.out.print(j + ", ");
			}
			System.out.println();
		}
	}

}
