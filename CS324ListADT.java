/* @author Joe Bofani
 * @since 2/28/2020
 * CS 324
 * Program Project 1
 * Read the ReadMe.txt for description
 */

import java.util.*;

public class CS324ListADT
{
  public static String partSums (ArrayList<Integer> l0)
  {
    Collections.sort(l0);  //sorts integers in numerical order
    int l0size = l0.size();
    ArrayList<Integer> p0 = new ArrayList<Integer>();  //create 2 partitions
    ArrayList<Integer> p1 = new ArrayList<Integer>();
    
    if (l0size == 0)  //start of 5 unique exception cases 
    {
      System.out.println("List size equals 0");
    }
    
    else if (l0size == 1)
    {
      p1.add(l0.get(0));
    }
    
    else if (l0size == 2)
    {
      p0.add( l0.get(l0size-1) );  //Note: for all cases, split the 2 biggest values into seperate partitions
      p1.add( l0.get(l0size-2) );
    }
    
    else if (l0size == 3)
    {
      p0.add( l0.get(l0size-1) ); 
      p1.add( l0.get(l0size-2) );
      p1.add( l0.get(l0size-3) );
    }
    else if (l0size == 4)
    {
      p0.add( l0.get(l0size-1) ); 
      p1.add( l0.get(l0size-2) );
      p0.add( l0.get(l0size-4) ); 
      p1.add( l0.get(l0size-3) );  //end of 5 unique exception cases
    }
    
    p0.add( l0.get(l0size-1) );  //for all list sizes > 4, split the 2 biggest values into seperate partitions
    p1.add( l0.get(l0size-2) );
    
    for (int i=l0size-3; i > (l0size/2) ; i--)  //assign the first half of the list's values to thier respective partition 
    {                                           //Note: 2 biggest values already added, so i=l0size-3
      if( (Math.abs((sum(p0) + l0.get(i))-sum(p1)) >= Math.abs(((sum(p1) + l0.get(i)))-sum(p0)))) 
        p1.add(l0.get(i));
      else
        p0.add(l0.get(i));
    }
    
    if (l0size%2 != 0) //when the list's size is ODD, this for loop assigns the last half of the list's values to thier respective partition
    {
      for (int i=(l0size/2) ; i >= 0 ; i--)  
      {
        if( Math.abs(((sum(p0) + l0.get(i))-sum(p1))) >= Math.abs(((sum(p1) + l0.get(i)))-sum(p0)) && (p1.size()+1 <= p0.size()+i+1))
        {   //if [(sump0 + i) - sump1 >= (sump1 + i) - sump0] && [(sizep1 + 1) <= (sizep0 + total amount of unnasigned list #'s + 1)]                          
          p1.add(l0.get(i));
        }
        else
        {
          p0.add(l0.get(i));
        }
      }
    }
    
    if (l0size%2 == 0) //when the list's size is EVEN, this for loop assigns the last half of the list's values to thier respective partition
    {
      for (int i=(l0size/2) ; i >= 0 ; i--)  
      {
        if( Math.abs(((sum(p0) + l0.get(i))-sum(p1))) >= Math.abs(((sum(p1) + l0.get(i)))-sum(p0)) && (p1.size()+1 <= p0.size()+i))
        {                            //Note: as compared to odd loop, the only difference is the p0.size()+i...odd is p0.size()+i+1 
          p1.add(l0.get(i));                  
        }
        else
        {
          p0.add(l0.get(i));
        }
      }
    }
    
    //returns sorted list, both partitions, and their minimal difference
    return ("Sorted list:   " + l0 +
            "\nPartition0: " + p0 +
            "\nPartition1: " + p1 +
            "\nThe minimal difference b/w the sums of the two partitions is: " + Math.abs(sum(p0)-sum(p1)));
  }
  
  public static int sum(List<Integer> list) //sum method
  {
    int sum = 0; 
    for (int i : list)
      sum = sum + i;
    return sum;
  }
}