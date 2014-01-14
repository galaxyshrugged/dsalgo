Problem

You are given a character array like this a3b1c1d1e4f0g11. 
You will have to expand the array by repeating the characters denoted by the following numbers.
For example the above character array will be expanded to aaabcdeeeeggggggggggg. The given array will
have more than enough trailing spaces such that you can modify the array in place.

Solution

We will solve this by recursion. Our first reading location and writing location is 0. 
As we find a3 we know that this will take 3 spaces. But if we write it now it will override b. 
So we know from a3 that next write will begin from 4th position and reading will start from 3rd position.
So we call this recursive function to read from 3rd position and write it from 4th position.
Then after the recursive function returns, we write the first 3 positions. The recursion ends when we
find space character in the reading position.
/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/expand-array.html
*/

package com.dsalgo;

public class ExpandArray
{
 public static void main(String[] args)
 {
  char[] arr = "a2b1c1d1e4f0g11                 ".toCharArray();
  expand(arr);
  for (char ch : arr)
   System.out.print(ch);
 }

 private static void expand(char[] arr)
 {
  expand(arr, 0, 0);
 }

 private static void expand(char[] arr, int startReading, int startWriting)
 {
  char ch = arr[startReading++];
  if (ch == ' ')
   return;
  int count = 0;
  while (Character.isDigit(arr[startReading]))
  {
   count = count * 10 + arr[startReading] - 48;
   startReading++;
  }
  expand(arr, startReading, startWriting + count);
  for (int i = 0; i < count; ++i)
   arr[startWriting + i] = ch;
 }
}

