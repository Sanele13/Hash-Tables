/**
 * Code description : This class contains the main method, it acts as the driver class
 *                    the class that is only needed to be runned for the user to see the expected outcomes
 *                    needed for this entire program. It is required for the user to interact with the program.
 *
 * Programmer(s)    : N.C Nkonyana and Sanele Mpangalala
 * Date             : 30 March 2014
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class AssignmentThreeDriverClass
{
   public static void main(String[] args)
   {
      MyHashTable table = new MyHashTable(40);               //creating the hash table here with table size equal to 17.
      String lines = "";
      String desiredKey = "";
      String result = "";
      Scanner inpOutpObject   = new Scanner(System.in);
      /**
       * In the following try block, the file stream containing the images is created. It is then read and all the red info is added to the table subsequently.
       * The approach used to insert all this data in the table is the seperate chaining approach.
       */
      try
      {
         BufferedReader bfObjctimages  = new BufferedReader(new FileReader("picture.txt"));
         lines = bfObjctimages.readLine();                  //reading the first line of the file. This is the one with headings.
         lines = bfObjctimages.readLine();                  //Here the program get rid of the first line of the text file that has headings, so it starts reading the images from here.
         while(lines!=null)
         {
            table.addToTable(lines);
            lines = bfObjctimages.readLine();               //At the end of text, lines will be assigned null hence subsequently termination of the loop.
         }
      }
      catch(IOException iox)
      {
         iox.printStackTrace();
      }
      /**
       * In the following the table out put is given to the console. Then the key's reference for the successful serach is given and result for the one that is not in the table.
       * Finally the total number of collisions are given.
       */
      
      String option = "N";
      while(option.equalsIgnoreCase("N"))
      {
			System.out.println("Would you like to see hash table contents? [Y/N]");  //At this stage the table is filled with images.
			result = inpOutpObject.nextLine();
			if((result.substring(0,1)).equalsIgnoreCase("Y"))
			{  
				System.out.println("\nThe following is the hash table output.");
				table.printTable();
			}
			else if((result.substring(0,1)).equalsIgnoreCase("N"))
			{
				System.out.println("Is there an image you would like to look for in the table? [Y/N]");
				result = inpOutpObject.nextLine();
				if((result.substring(0,1)).equalsIgnoreCase("Y"))
				{
					System.out.println("Enter the name of the image.");
					desiredKey = inpOutpObject.nextLine();            		 //Reading the image to be searched.
					table.findKey(desiredKey.trim());                        //The find part of the assignment.
				}
			}
			System.out.println("Press enter to terminate the program or N to continue testing other operations.");
			option = inpOutpObject.nextLine();
		}
	}
}
