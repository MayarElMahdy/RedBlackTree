package RedBlackTree;

public class Node {
	  
	// RED = 0 ,,,, BLACK =1  
	final int RED = 0; 
    final int BLACK = 1;
	String key;
	int color;
	Node right , parent;
	Node left = right= parent ;
	Node (String key)
	{
		this.key = key;
		left=parent=right= RedBlackTrees.nill;
		
	}

}
