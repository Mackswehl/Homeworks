// Maxwell Vale
// APCS2 pd2
// HW43 -- BSTs is the Perfect Place for Shade
// 2018-05-02W

/*****************************************************
* class BST - v1:partial
* Implementation of the BINARY SEARCH TREE abstract data type (ADT)
*
* A BST maintains the invariant that, for any node N with value V,
* L<V && V<R, where L and R are node values in N's left and right
* subtrees, respectively.
* (Any value in a node's left subtree must be less than its value,
*  and any value in its right subtree must be greater.)
* This BST only holds ints (its nodes have int cargo)
*****************************************************/

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /*****************************************************
  * default constructor
  *****************************************************/
  BST( )
  {
    _root = null;
  }


  /*****************************************************
  * void insert( int )
  * Adds a new data element to tree.
  *****************************************************/
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );

    if ( _root == null ) {
      _root = newNode;
      return;
    }
    insert( _root, newNode );
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if ( newNode.getValue() < stRoot.getValue() ) {
      //if no left child, make newNode the left child
      if ( stRoot.getLeft() == null )
      stRoot.setLeft( newNode );
      else //recurse down left subtree
      insert( stRoot.getLeft(), newNode );
      return;
    }
    else { // new val >= curr, so look down right subtree
      //if no right child, make newNode the right child
      if ( stRoot.getRight() == null )
      stRoot.setRight( newNode );
      else //recurse down right subtree
      insert( stRoot.getRight(), newNode );
      return;
    }
  }//end insert()




  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
    return;
    System.out.print( currNode.getValue() + " " );
    preOrderTrav( currNode.getLeft() );
    preOrderTrav( currNode.getRight() );
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav( _root );
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
    return;
    inOrderTrav( currNode.getLeft() );
    System.out.print( currNode.getValue() + " " );
    inOrderTrav( currNode.getRight() );
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
    return;
    postOrderTrav( currNode.getLeft() );
    postOrderTrav( currNode.getRight() );
    System.out.print( currNode.getValue() + " "  );
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  /*****************************************************
  * TreeNode search(int)
  * returns pointer to node containing target,
  * or null if target not found
  *****************************************************/
  TreeNode search( int target )
  {
    if (_root == null) {
      return null;
    }
    return search(_root, target);
  }

  TreeNode search( TreeNode root, int target) {
    if (target == root.getValue()) {
      return root;
    }
    else if (target < root.getValue()) {
      // If the target is smaller, then it should be contained in the left subtree of the node
      if (root.getLeft() == null) {
        return null;
      }

      return search(root.getLeft(), target);
    }
    else {
      // Must mean that the target is greater, so it must be in the right subtree
      if (root.getRight() == null) {
        return null;
      }
      return search(root.getRight(), target);
    }
  }


  /*****************************************************
  * int height()
  * returns height of this tree (length of longest leaf-to-root path)
  * eg: a 1-node tree has height 0
  *****************************************************/
  public int height()
  {
    return height(_root);
  }

  private int height(TreeNode node) {
    if (node == null) {
      return 0;
    }
    else if (node.getLeft() == null && node.getRight() == null) {
      return 0;
    }
    else {
      return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
    }
  }


  /*****************************************************
  * int numLeaves()
  * returns number of leaves in tree
  *****************************************************/
  public int numLeaves()
  {
    return numLeaves(_root);
  }

  private int numLeaves(TreeNode node) {
    if (node == null) {
      return 0;
    }
    else if (node.getLeft() == null && node.getRight() == null) {
      return 1;
    }
    else {
      return numLeaves(node.getLeft()) + numLeaves(node.getRight());
    }
  }

  /*****************************************************
  * int remove(TreeNode node)
  * returns the value of the removed node
  *****************************************************/
  public int remove (int target) {
    return remove (_root, target);
  }

  public int remove (TreeNode currNode, int target) {
    TreeNode leader, follower = currNode;
    if (target < currNode.getValue()) {
      leader = leader.getLeft();
    }
    else {
      leader = leader.getRight();
    }
    if (!(leader.getValue() == target)) {
      return remove(leader, target);
    }
    else {
      if (leader.getLeft() == null && leader.getRight == null) {
        if (target < follower.getValue()) {
          follower.setLeft(null);
        }
        else {
          follower.setRight(null);
        }
      }
      else if (leader.getLeft)
    }
  }



  //main method for testing
  public static void main( String[] args )
  {
    BST arbol = new BST();

    //PROTIP: sketch state of tree after each insertion
    //        ...BEFORE executing these.
    arbol.insert( 4 );
    arbol.insert( 2 );
    arbol.insert( 5 );
    arbol.insert( 6 );
    arbol.insert( 1 );
    arbol.insert( 3 );

    System.out.println( "\nArbol BST");
    System.out.println( "\n-----------------------------");
    System.out.println( "pre-order traversal:" );
    arbol.preOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "in-order traversal:" );
    arbol.inOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "post-order traversal:" );
    arbol.postOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "Number of Leaves:");
    System.out.println(arbol.numLeaves());

    System.out.println( "\n-----------------------------");
    System.out.println( "Height");
    System.out.println(arbol.height());

    System.out.println( "\n-----------------------------");

    /*********************************************************/

    BST boom = new BST();

    boom.insert(15);
    boom.insert(12);
    boom.insert(7);
    boom.insert(23);
    boom.insert(3);
    boom.insert(16);
    boom.insert(21);
    boom.insert(20);
    boom.insert(10);
    boom.insert(14);
    boom.insert(28);
    boom.insert(1);
    boom.insert(30);

    System.out.println( "\nBoom BST");
    System.out.println( "\n-----------------------------");
    System.out.println( "pre-order traversal:" );
    boom.preOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "in-order traversal:" );
    boom.inOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "post-order traversal:" );
    boom.postOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "Number of Leaves:");
    System.out.println(boom.numLeaves());

    System.out.println( "\n-----------------------------");
    System.out.println( "Height:");
    System.out.println(boom.height());

    System.out.println( "\n-----------------------------");
    System.out.println( "Search Tests:");
    System.out.println( boom.search(21).getValue() ); // Should give back 21
    System.out.println( boom.search(1).getValue() ); // 1
    System.out.println( boom.search(12).getValue() ); // 12
    System.out.println( boom.search(13) ); // 13 not in the tree, so null

    /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class
