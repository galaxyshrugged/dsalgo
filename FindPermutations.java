Find all permutations

Problem


Find all the permutations of a given string whose letters are unique.
Solution


Suppose the string is abcd. Then in its permutations, first letter can be a, b, c or d. 
If we decide any one of these as the first letter. Then the subproblem arises of having permutations
of the rest of the letters. We solve this by recursion.





/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/find-all-permutations.html
*/

package com.dsalgo;

import java.util.ArrayList;
import java.util.List;

public class FindPermutations
{
	public static void main(String[] args)
	{
		findAllPermutations("abcde");
	}

	private static void findAllPermutations(String string)
	{
		List<Character>characters=new ArrayList<Character>();
		for(char ch:string.toCharArray())
			characters.add(ch);
		findAllPermutations(new ArrayList<Character>(),characters);
	}

	private static void findAllPermutations(List<Character> prefix,
			List<Character> suffix)
	{
		if(suffix.size()==1)
		{
			for(Character ch:prefix)
				System.out.print(ch);
			System.out.println(suffix.get(0));
			return;
		}
		for(int i=0;i<suffix.size();++i)
		{
			Character ch=suffix.get(i);
			prefix.add(ch);
			suffix.remove(i);
			findAllPermutations(prefix,suffix);
			suffix.add(i,ch);
			prefix.remove(ch);
		}
	}

	
}
