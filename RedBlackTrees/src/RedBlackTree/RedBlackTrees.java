package RedBlackTree;

public class RedBlackTrees {
	public static Node nill ;
	public Node root;
	public int DictSize;
	RedBlackTrees()
	{
		nill = new Node("nul");
		nill.right=nill;
		nill.left=nill;
		nill.parent=nill;
		DictSize=0;
	    root = nill;
	}
	public void insert(Node inew)
	{
		Node node = root;
	
		if(root == nill) //if the tree is empty
		{	
			root=inew;
			inew.color=node.BLACK;
			inew.parent = nill;
		}
		else
		{
			//We start the red black tree by coloring the node RED 
			inew.color = node.RED;
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
		
		//The problem begins when the parent's color is RED , if it is BLACK then nothing is changed
		while (inew.parent.color==inew.RED)
		{
			//System.out.println(inew.parent.key);
			Node uncle = nill;
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
		
	     if (node.parent != nill) {
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
	        } else {//Need to rotate root
	            Node right = root.right;
	            root.right = right.left;
	            right.left.parent = root;
	            root.parent = right;
	            right.left = root;
	            right.parent = nill;
	            root = right;
	        }
	}
	private void rotateRight(Node inew) {
	    if (inew.parent != nill) {
            if (inew == inew.parent.left) {
                inew.parent.left = inew.left;
            } else {
                inew.parent.right = inew.left;
            }

            inew.left.parent = inew.parent;
            inew.parent = inew.left;
            if (inew.left.right != nill) {
                inew.left.right.parent = inew;
            }
            inew.left = inew.left.right;
            inew.parent.right = inew;
        } else {//Need to rotate root
            Node left = root.left;
            root.left = root.left.right;
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = nill;
            root = left;
        }
	}
	public int TreeHeight(Node rt)
	{
		//Go from the root to the farthest child
		 if (rt == nill)  
		        return 0;  
		    else
		    {  
		        // compute the depth of each subtree 
		        int lDepth =TreeHeight(rt.left); 
		        int rDepth = TreeHeight(rt.right);
		        //use the larger one 
		        if (lDepth > rDepth)  
		            return(lDepth + 1);  
		        else return(rDepth + 1);  
		    } 
	}

public Node Search(Node r,String input)
{
	if (root == nill) {
        return nill;
    }
	if(r==nill)
	{
		return nill;
	}
	int compare = input.compareTo(r.key);
	if(compare == 0)
		return r;
	if(compare > 0)
		return Search(r.right,input);
	if(compare<0)
		return Search(r.left,input);
return nill;
}

//The delete method // BARE IN MIND THAT THERE ARE THREE MAIN CASES FOR THE DELETE 
// WE SWAP THE NODE WE WANT TO DELETE WITH (THE LEFTMOST OF THE RIGHT CHILD)
void transport(Node nodeDel, Node child){ 
    if(nodeDel.parent == nill){   //if the node is the root
        root = child; //copy the child to the root (child depending on the CALL)
    }else if(nodeDel == nodeDel.parent.left){  //Find the node place from the parent then overwrite the value of CHILD to it 
        nodeDel.parent.left = child;
    }else
        nodeDel.parent.right = child;
    child.parent = nodeDel.parent;  //delete the node by making the child's grandparent it's parent
}
public boolean delete(Node nodeDel){
	Node temp = root;
  if((nodeDel = Search(temp, nodeDel.key)) == nill)return false;
  Node x;
  Node y = nodeDel; // temporary reference y
  int orgColor = y.color;
  
  if(nodeDel.left == nill){
      x = nodeDel.right;  
      transport(nodeDel, nodeDel.right); 
  }else if(nodeDel.right == nill){
      x = nodeDel.left;
      transport(nodeDel, nodeDel.left);
      
  }else{
      y = leftMost(nodeDel.right);  //Get the MINIMUM VALUE FOUND which is the RIGHT leftmost of the node
      orgColor = y.color;
      x = y.right;
      if(y.parent == nodeDel)
          x.parent = y;
      else{
    	  transport(y, y.right);
          y.right = nodeDel.right;
          y.right.parent = y;
      }
      
      transport(nodeDel, y);
      y.left = nodeDel.left;
      y.left.parent = y;
      y.color = nodeDel.color; 
  }
  if(orgColor==x.BLACK)  //IF RED THEN FIRST CASE --REPLACE WITH CHILD --
      deleteFixup(x);  //If the node that is deleted was BLACK then we need to fix the color of tree CASE TWO AND THREE
  return true;
}
void deleteFixup(Node x){ //In delete we focus on the SIBLING 
  while(x!=root && x.color == x.BLACK){  //We fix up till we find a red NODE or we reach the root
      if(x == x.parent.left){ //FIND THE SIBLING 
          Node sibling = x.parent.right;  
          if(sibling.color == x.RED){
              sibling.color = x.BLACK;
              x.parent.color = x.RED;
              rotateLeft(x.parent);
              sibling = x.parent.right;
          }
          if(sibling.left.color == x.BLACK && sibling.right.color == x.BLACK){ 
              sibling.color = x.RED;
              x = x.parent;
              continue;
          }
          else if(sibling.right.color == x.BLACK){
              sibling.left.color = x.BLACK;
              sibling.color = x.RED;
              rotateRight(sibling);
              sibling = x.parent.right;
          }
          if(sibling.right.color == x.RED){  
              sibling.color = x.parent.color;
              x.parent.color = x.BLACK;
              sibling.right.color = x.BLACK;
              rotateLeft(x.parent);
              x = root;
          }
      }else{ //THE PLACE OF THE SIBLING EFFECTS ON THE ROTATE 
          Node sibling = x.parent.left;
          if(sibling.color == x.RED){
              sibling.color = x.BLACK;
              x.parent.color = x.RED;
              rotateRight(x.parent);
              sibling= x.parent.left;
          }
          if(sibling.right.color == x.BLACK && sibling.left.color == x.BLACK){
              sibling.color = x.RED;
              x = x.parent;
              continue;
          }
          else if(sibling.left.color == x.BLACK){
              sibling.right.color = x.BLACK;
              sibling.color = x.RED;
              rotateLeft(sibling);
              sibling = x.parent.left;
          }
          if(sibling.left.color == x.RED){
              sibling.color = x.parent.color;
              x.parent.color = x.BLACK;
              sibling.left.color = x.BLACK;
              rotateRight(x.parent);
              x = root;
          }
      }
  }
  x.color = x.BLACK; //At the end the node is black 
} 

Node leftMost(Node nodeDel){ //Bare in mind that you are searching for the minimum value --LEFTMOST NODE--
  while(nodeDel.left!=nill){    //Takes the leftmost node from the delete Node we want so we copy it with it  
      nodeDel = nodeDel.left;
  }   
  return nodeDel;
}
}