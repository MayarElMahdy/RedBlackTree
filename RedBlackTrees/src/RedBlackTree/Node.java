package RedBlackTree;

public class Node {
	  
	// RED = 0 ,,,, BLACK =1  
	final int RED = 0; 
    final int BLACK = 1;
	String key;
	int color;
	Node right ;
	Node parent;
	Node left ;
	public Node (String key)
	{
		this.key = key;
		color = BLACK;
		left= RedBlackTrees.nill;
		right = RedBlackTrees.nill;
		parent = RedBlackTrees.nill;
	}

}
