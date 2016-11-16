/**
 * Code description : This is the implementation of the node class that will be used in the
 *                    LinkedList class.
 * 
 * Programmer(s)    : N.C Nkonyana and Sanele Mpangalala
 * Date             : 30 March 2014
 */
 
public class ListNode
{
   /**
    * The following are the declarations of this class instance variables.
    */
   private String image, imageInfo;
   private ListNode linkNext;            //This is the link pointing to the next node
    
   public ListNode()
   {
      this.image = null;
      this.imageInfo = null;
      this.linkNext = null;
   }
   public ListNode(String imge, String details, ListNode lstNde)
   {
      this.image = imge;
      this.imageInfo = details;
      this.linkNext = lstNde;
   }
   public ListNode getNextLink()
   {
      return linkNext;
   }
   public String getImage()
   {
      return image;
   }
   public void printDataNode()
   {
      System.out.println("Image name : " + image + " and description : " + imageInfo.trim());
   }
}
