/**
 * Code description : This is the implemantation of the HashFunction. This class has the 
 *                    method hash, which returns an integer that represents the key. This value
 *                    can be viewed as the initial index to which the key is to be stored. Viewed
 *                    in this way its because the index may already be taken by some other key.
 *
 * Programmer(s)    : N.C Nkonyana and Sanele Mpangalala
 * Date             : 30 March 2014
 */
 
public class MyHashFunction
{
   private String data;           //the data field for this class
   private int index;             //this is the field for the computed value returned from the method, computeHashIndex.
   //The following is the default constructor, this creates an empty object.
   public MyHashFunction()
   {
      this.data = null;
      this.index = 0;
   }
   
   /**
    * The following method returns the interger representaion of the key to be inserted in the table.
    */
   public int computeHashIndex(String key, int tableSize)
   {
      this.data = key;
      int tempIndex = 0;
      for(int i=0; i < data.length(); i++)
      {
         tempIndex+= data.charAt(i);
      }
      index = (tempIndex%tableSize) + 1;                 //This shows the rule this hashfunction method employed in getting the final result to be returned.
      return index;
   }
}
