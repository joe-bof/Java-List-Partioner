@author Joe Bofani
@since 2/28/2020
CS 324
Professor Kazarinov

Description: A program that will solve the problem: For a given ListADT that contains Items with numerical key value (integer), it will be reordered it into two partitions of equal size such as the difference between the sum of those integers in the first partition and the second partition is minimal. 

Files Included:  

BofaniCS324ListADTApp.java --> application class.
CS324ListADT.java --> sorting and partioning program.
BofaniReadMe.txt --> text descriptions of files.


To run call: Enter the desired ArrayList into the sumParts() method.

Logical Steps of my Algorithm:
1) Determine if the list fits into one of the 5 unique cases; list size <= 4.  If so, skip steps ...
	-List size of 0 = print an error message
	-List size of 1 = put single data member into 0th partition
	-List size of 2 = split data members into seperate partions
	-List size of 3 = put highest value data member in p0, and the other two data members in p1
	-List size of 4 = put highest and lowest value data members in p0, and the middle two data members in p1

2) Split the 2 highest value data members into seperate partions

3) Assign the first half of the list's values to thier respective partition (except for the 2 highest valued data memebers; they were assigned in step 2).
	-Data members added to the smaller summed partition (p1 by default on start) until the list's halfway mark is reached, or the sum of p1 > sum of p0.
	-If the latter is true: up until step#3 is done, every new data member will be compared by adding its value to the sum of both p0 and p1.  Whichever 
	 partition it is added to where the sum of differences produces the minimal answer, is the partition where the data member will be assigned to. 

4) Assign the last half of the list's values to thier respective partition.
	-Data memebers go to 1 of 2 for loops depending on if the list's size is even or odd
	-Every new data member will be compared by adding its value to the sum of both p0 and p1.  Whichever partition it is added to where the sum of differences 	 	 produces the minimal answer, is the partition where the data member will be assigned to, ONLY IF adding to that given partion will not increase its size                beyond the size of the other partition.  If so, the data member will be added to the other partition to maintain equality in size b/w the partition.

Example:  List=1,2,3,4,5,6,7,8,9,10
1) N/A
2) p0=[10]          p1=[9]
3) p0=[10]          p1=[9,8]
   p0=[10,7]        p1=[9,8]
4) p0=[10,7]        p1=[9,8,6]
   p0=[10,7,5]      p1=[9,8,6]
   p0=[10,7,5,4]    p1=[9,8,6]
   p0=[10,7,5,4]    p1=[9,8,6,3]
   p0=[10,7,5,4]    p1=[9,8,6,3,2]
   p0=[10,7,5,4,1]  p1=[9,8,6,3,2]