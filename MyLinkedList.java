/**
 * Code description : This is the implementation of the class, LinkedList.java used in the hash table.
 *                    Because of this, this program shows the method followed in resolving the collision issues and
 *                    and drawbacks of quadratic probing. It shows that the seperate chaining approach has been followed.
 * 
 * Programmer(s)    : N.C Nkonyana and Sanele Mpangalala
 * Date             : 30 March 2014
 */
 
public class MyLinkedList
{
   /**
    * The data field declarations follows
    */
    
   private ListNode dataNode;              //called this way its due to the fact that linkedlist store information as nodes which are actually the ones storing the information.
   public MyLinkedList()
   {
      this.dataNode = null;     
   }
   //The following adds data nodes at the begining of the linked list
   public void addToList(String imge, String dtails)
   {
       ListNode listLink = new ListNode(imge, dtails, dataNode);
       ListNode link;
       link = listLink.getNextLink();
       link = dataNode;
       dataNode = listLink;
   }
   //In the below method the linked list's contents are printed out after the method call to printList().
   public void printList()
   {
      ListNode currentNode;
      currentNode = dataNode; 
      while(currentNode!=null)
      {
         currentNode.printDataNode();
         currentNode = currentNode.getNextLink();
      }
   }
   //The following sequentially searches the list for the image sought after. It returns a boolean value representing the search success.
   public boolean findImage(String imge)
   {
      ListNode currentNode = dataNode;
      while(currentNode!=null)
      {
         if(currentNode.getImage().equals(imge))
            return true;
         currentNode = currentNode.getNextLink();
      }
      return false;                             //Image not in the linked list
   }
}
