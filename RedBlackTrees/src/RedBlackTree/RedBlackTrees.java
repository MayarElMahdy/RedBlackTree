package RedBlackTree;

public class RedBlackTrees {
	final static Node nill = new Node("nul");
	Node root;
	RedBlackTrees()
	{
	     root = nill;
	}
	public void insert(Node inew)
	{
		Node node = root;
		
		if(root == nill) //if the tree is empty
		{	
			
			inew.color = node.BLACK;
			inew.left = nill;
			inew.right=nill;
			inew.parent = nill;
			root=inew;
		}
		
		else
		{
			//We start the red black tree by coloring the node RED 
			node.color = node.RED;
			node.left=nill;
			node.right=nill;
			while(true) //Breaks when there is a break argument
			{
				
				int compare = inew.key.compareTo(node.key);
				
				if(compare<0)
				{
				if(node.left==nill) {
					node.left = inew;
                    inew.parent = node;
                    break;
					}    
				else
				{
					node = node.left;
				}
				}
				else if (compare >= 0)
				{
					if (node.right == nill) {
                        node.right = inew;
                        inew.parent = node;
                        break;
                    } else {
                        node = node.right;
                    }
				}
				
			}
			colorFix(inew); //After inserting the new node we fix the colors of the tree
			
		}
	}
	public void colorFix(Node inew)
	{
		Node uncle = nill;
		//The problem begins when the parent's color is RED , if it is BLACK then nothing is changed
		while (inew.parent.color==inew.RED)
		{
			//First we need to find the UNCLE to check it's color
			if(inew.parent.parent.left == inew.parent)
			{
				uncle = inew.parent.parent.right;
				//Check if both of them have the color RED then we turn them both black and turn the grandparent RED and now we point to the Grandparent
				  if (uncle != nill && uncle.color == inew.RED) {
	                    inew.parent.color = inew.BLACK;
	                    uncle.color = inew.BLACK;
	                    inew.parent.parent.color = inew.RED;
	                    inew = inew.parent.parent;
	                    continue;
			}
				  //ROTATIONS
				  if (inew == inew.parent.right) {
	                    //Double rotation needed
	                    inew = inew.parent;
	                    rotateLeft(inew);
	                } 
	                inew.parent.color = inew.BLACK;
	                inew.parent.parent.color = inew.RED;
	               //single rotation If the node is LEFT
	                rotateRight(inew.parent.parent);
			}
			else{
				if (inew.parent.parent==nill)
					uncle = nill;
				//The uncle is in the left of the grandparent
				else
                uncle = inew.parent.parent.left;
               // System.out.println(uncle.color);
                	
                //IF THE UNCLE IS RED AND PARENT IS RED THEN WE CHANGE THEIR COLORS TO BLACK AND GRANDPARENT TO RED
                 if (uncle != nill && uncle.color == inew.RED) {
                    inew.parent.color = inew.BLACK;
                    uncle.color = inew.BLACK;
                    inew.parent.parent.color = inew.RED;
                    inew = inew.parent.parent;
                    continue;
                }
                if (inew == inew.parent.left) {
                    inew = inew.parent;
                    rotateRight(inew);
                }
                inew.parent.color = inew.BLACK;
                inew.parent.parent.color = inew.RED;
                rotateLeft(inew.parent.parent);
            }
        }
        root.color = inew.BLACK;
        
    }
	private void rotateLeft(Node node) {
		if(node.key.equals("nul")) {
			
		}
		else {
	       if (node.parent != nill) {
	    	   System.out.println(node.key);
	            if (node == node.parent.left) {
	                node.parent.left = node.right;
	            } else {
	                node.parent.right = node.right;
	            }
	            node.right.parent = node.parent;
	            node.parent = node.right;
	            if (node.right.left != nill) {
	                node.right.left.parent = node;
	            }
	            node.right = node.right.left;
	            node.parent.left = node;
	        } else {
	            Node right = root.right;
	            root.right = right.left;
	            right.left.parent = root;
	            root.parent = right;
	            right.left = root;
	            right.parent = nill;
	            root = right;
	        }
		}
	}
	private void rotateRight(Node inew) {
		if(inew.equals("nul"))
		{
			
		}
		else {
	      if (inew.parent.key.equals("nul")) {
	            Node left = root.left;
	            root.left = root.left.right;
	            left.right.parent = root;
	            root.parent = left;
	            left.right = root;
	            left.parent = nill;
	            root = left;
	      }
	      else {
	            if (inew == inew.parent.left) {
	                inew.parent.left = inew.left;
	            } else {
	                inew.parent.right = inew.left;
	            }

	            inew.left.parent = inew.parent;
	            inew.parent = inew.left;
	            if (inew.left.right.key.equals("nul")) {
	            	
	            }
	            else {
	                inew.left.right.parent = inew;
	            }
	            inew.left = inew.left.right;
	            inew.parent.right = inew;
	        } 
	    }
	}

	}
