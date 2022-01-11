/* @author Joe Bofani
 * @since 2/28/2020
 * CS 324
 * Program Project 1
 * Application for CS324ListADT
 */

import java.util.*;

public class BofaniCS324ListADTApp extends CS324ListADT
{
  public static void main(String[] args) 
  { 
    ArrayList<Integer> l0 = new ArrayList<Integer>();
    
    //hard-coded list
    l0.add(5270);
    l0.add(50);
    l0.add(700);
    l0.add(1);
    l0.add(9000);
    l0.add(2);
    l0.add(621);
    //l0.add(1);
    //l0.add(1);
    //l0.add(1);
    //l0.add(1);
    //l0.add(1);
    //l0.add(1);
    //l0.add(1);
    //l0.add(1);
    
    System.out.println("Original list: " + l0); //prints original, un-sorted list
    System.out.println(partSums(l0));
  }
}