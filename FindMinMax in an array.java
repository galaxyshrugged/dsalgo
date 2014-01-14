Problem
Given an array of integers, find the maximum and minimum of the array.

Constraint
Find the answer in minimum number of comparisons.

Brute force
We can keep two variables named max and min. We can iterate over the list and compare each number
with the min and the max, if the number is greater than the max update max, if the number is less
than the min, update the min. In this brute force solution the number of comparison is 2*n.

Better solution
If rather than comparing each number with max and min, we can first compare the numbers in pair with
each other. Then compare the larger number with max and compare the smaller number with min. in this 
way the number of comparison for a pair of numbers are 3. So number of comparisons are 1.5 *n.


/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/FindMinMax.php.html
*/

package com.dsalgo;

public class FindMinMax
{

 public static void main(String[] args)
 {
  int[] arr = {4, 3, 5, 1, 2, 6, 9, 2, 10, 11};
  int max = arr[0];
  int min = arr[0];
  int i = 0;
  for (; i < arr.length / 2; i++)
  {
   int num1 = arr[i * 2];
   int num2 = arr[i * 2 + 1];
   if (arr[i * 2] >= arr[i * 2 + 1])
   {
    if (num1 > max)
     max = num1;
    if (num2 < min)
     min = num2;
   }
   else
   {
    if (num2 > max)
     max = num2;
    if (num1 < min)
     min = num1;
   }
  }
  if (i * 2 < arr.length)
  {
   int num = arr[i * 2];
   if (num > max)
    max = num;
   if (num < min)
    min = num;
  }
  System.out.println("maximum= " + max);
  System.out.println("minimum= " + min);
 }

}
