/* DListNode.java */

package list;


/**
 *  A DListNode is a node in a DList (doubly-linked list).
 */

public class DListNode {

  /**
   *  item references the item stored in the current node.
   *  prev references the previous node in the DList.
   *  next references the next node in the DList.
   *
   *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
   */

  public Object item;
  protected DListNode prev;
  protected DListNode next;
 
  protected DList nodeList; 
    


  


  /**
   *  DListNode() constructor.
   *  @param i the item to store in the node.
   *  @param l the list this node is in.
   *  @param p the node previous to this node.
   *  @param n the node following this node.
   */
  DListNode(Object i, DList zNodeList, DListNode p, DListNode n) {
	    item = i;
      prev = p;
      next = n;
      nodeList = zNodeList;
  }









 /**
   *  isValidNode returns true if this node is valid; false otherwise.
   *  An invalid node is represented by a `nodeList' field with the value null.
   *  Sentinel nodes are invalid, and nodes that don't belong to a list are
   *  also invalid.
   *
   *  @return true if this node is valid; false otherwise.
   *
   *  Performance:  runs in O(1) time.
   */
  public boolean isValidNode() {
    return nodeList != null;
  }









  /**
   *  next() returns the node following this node.   
   *
   *  @return the node following this node. 
   *
   *  Performance:  runs in O(1) time.
   */
  public DListNode next() {

    if (isValidNode()) { 
        return next;
    }
    return null;
  }







  /**
   *  prev() returns the node preceding this node.  
   * 
   *  @return the node preceding this node.
   *  Performance:  runs in O(1) time.
   */
  public DListNode prev()  {

    if (isValidNode()) { 
        return prev;
    }
    return null;
  }









  /**
   *  insertAfter() inserts an item immediately following this node.  
   *
   *  @param item the item to be inserted. 
   *  Performance:  runs in O(1) time.
   */
  public void insertAfter(Object item) {
    
    // Your solution here. this node's "nodeList" field entails
    // what DList it's in. use nodeList.newNode() to create the
    // new node.
    if (isValidNode()) { 
        this.next = ((DList)nodeList).newNode(item,(DList)nodeList,this,this.next);
        this.next.next.prev = this.next;
        nodeList.size++;
    }
  }







  /**
   *  insertBefore() inserts an item immediately preceding this node.  
   *
   *  @param item the item to be inserted.
   *  @exception InvalidNodeException if this node is not valid.
   *
   *  Performance:  runs in O(1) time.
   */
  public void insertBefore(Object item)  {
    
    // Your solution here. no need to check if "this" is null.
    // this node's "nodeList" field entails what DList it's in.
    // use nodeList.newNode() to create the new node. 
    if (isValidNode()) { 
        this.prev = ((DList)nodeList).newNode(item,(DList)nodeList,this.prev,this);
        this.prev.prev.next = this.prev;
        nodeList.size++;
    }
  }










  /**
   *  remove() removes this node from its DList.  
   *
   *  Performance:  runs in O(1) time.
   */
  public void remove()  {
   
    // Your solution here.  need check "this" isn null or not 
    // if it is null, nothing to remove
      if (isValidNode()) { 
          this.prev.next = this.next;
          this.next.prev = this.prev;
          
          nodeList.size--;

          // set nodeList to null, so it can NOT be used.
          nodeList = null;
          // Set next and prev to null to for garbage collection.
          next = null;
          prev = null;
      }
  }

  






  /**
   *  item() returns this node's item.   
   *  @return the item stored in this node.
   *
   *  Performance:  runs in O(1) time.
   */
  public Object item()  {
     
    return item;
  }








  /**
   *  setItem() sets this node's item to "item".   
   *
   *  Performance:  runs in O(1) time.
   */
  public void setItem(Object item)   {
     
    this.item = item;
  }

   
}