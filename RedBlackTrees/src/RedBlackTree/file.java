package RedBlackTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class file {
	public RedBlackTrees RBT = new RedBlackTrees();
	//public int DictSize;
	public void Read() 
	{
		File f = new File("d.txt");
		Scanner s;
		try {
			s = new Scanner(f);
			while(s.hasNextLine())
			{
				RBT.DictSize++;
				String line = s.nextLine();
				Node node = new Node(line);
				RBT.insert(node);
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot be found");
			
		}
		
	}
	

}
