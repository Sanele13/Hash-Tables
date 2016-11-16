/**
 * Code description : This is the implementation of the HasHTable.java. It creates an instance of the  
 *                    HashFunction.java. This mirrors the name of this class since it uses the HashFunction
 *                    method that computes an index for the keys.
 *
 * Programmer(s)    : N.C Nkonyana and Sanele Mpangalala
 * Date             : 30 March 2014
 */
 
public class MyHashTable
{
   /**
    * The following are the declarations of this class.
    *
    */
   private MyLinkedList list;
   private MyHashFunction hashObject = new MyHashFunction();
   private int tableSize;
   private int collisions;
   private MyLinkedList[] table;
   //The constructor initialising instance variables values
   public MyHashTable(int tSize)
   {
      this.tableSize = tSize;
      this.table = new MyLinkedList[tableSize];
      this.list = null;
      this.collisions = 0;
   }
   /**
    * The following is the method, addToTable. This hashtable uses to insert keys in the table
    * It follows the approach of seperate chaining.
    */   
   public void addToTable(String data)
   {
      String key = data.substring(0, data.indexOf('.'));
      int index =  hashObject.computeHashIndex(key, this.tableSize);
      
      for(int i = 0; i < this.table.length-1; i++)
      {
         if(this.table[index]==null)            //Inside this if block, a new list is created given that the current indexed position of the table is null.
         {
            list = new MyLinkedList();
            list.addToList(data.substring(0, data.indexOf('.') + 4), data.substring(data.indexOf('.')+4));//This builds the linked data structure.
            this.table[index] = list;           //Adding the list to the table here.
            collisions = 0;
            break;
         }
         else if(this.table[index]!=null)       //The slot to which the key is hashed is occupied, then add to the linked list at that slot the data.
         {
            (this.table[index]).addToList(data.substring(0, data.indexOf('.') + 4), data.substring(data.indexOf('.') + 4));
            collisions++;                       //The number of collision computed here.
            break;
         }
      }
   }
   
   /**
    * The following method, findKey looks for the key desired if its in the table. If its in the table it prints the location of the image.
    * else it give an output that gives a signal to the user that the image is not in the table.
      */
   public void findKey(String image)
   {
	  collisions = 0;
      String tempStr = "";
      if(image.contains(".jpg"))
      {
         tempStr = image.substring(0, image.indexOf('.'));
         int position = hashObject.computeHashIndex(tempStr, this.tableSize);       //Program will use this index to check if the sought image is in the hash table.
         if((table[position]!=null)&&table[position].findImage(image) == true)
         {
			 collisions++;
			 System.out.println("The image location is at: \\cscprojects\\pracThree\\CapeTown\\" + image + " and it took " + collisions + " collisions to find the image.");
		 }
         else
             System.out.println("The image can not be located in the table.");     //Image not found
      }
      else
         System.out.println("Please make sure that the name of the image entered has the extention .jpg. And try again to look for it."); //This handles the case that the name of the image sought does not contain the .jpg extention.
   }
 
   public MyLinkedList[] getTable()
   {
      return table;
   }
   //The following is for printing the table contents.
   public void printTable()
   {
      for(int i=0; i<tableSize;i++)
      {
         if(table[i]!=null)
         {
            table[i].printList();
         }
      }
   }
   public int getCollisions()
   {
      return this.collisions;       //number of collisions.
   }
}
