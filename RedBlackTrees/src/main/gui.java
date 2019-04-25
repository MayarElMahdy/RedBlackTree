package main;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import RedBlackTree.Node;
import RedBlackTree.RedBlackTrees;
import RedBlackTree.file;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class gui {

	private JFrame frame;
	RedBlackTrees tree;
	JButton btnSearch;
	JButton btnInsert;
	JButton btnDelete;
	JButton btnSize;
	JLabel lblDictionary;
	private JPanel panel1 ;
	JPanel panel3;
	file f;
	private JPanel panel2;
	private JTextField textField;
	private JLabel label;
	private JTextField search;
	JLabel FoundLabel;
	JLabel Colo;
	JLabel lblEnterTheWord_1;
	private JTextField DeleteText;
	JPanel panel4;
	 JPanel panel5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	public gui()  {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize() {
		
		f = new file();
		f.Read();
		frame = new JFrame();
		frame.setBackground(Color.BLACK);
		frame.setBounds(0,0,484,558);
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		 
		  panel5 = new JPanel();
		 panel5.setBackground(SystemColor.activeCaption);
		 panel5.setBounds(0, 0, 469, 511);
		 frame.getContentPane().add(panel5);
		 panel5.setLayout(null);
		 panel5.setVisible(false);
		 
		 DeleteText = new JTextField();
		 DeleteText.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 16));
		 DeleteText.setBounds(115, 210, 242, 48);
		 panel5.add(DeleteText);
		 DeleteText.setColumns(10);
		 
		 JLabel lblEnterTheWord_2 = new JLabel("Enter The Word You'd Like to Delete :");
		 lblEnterTheWord_2.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		 lblEnterTheWord_2.setHorizontalAlignment(SwingConstants.CENTER);
		 lblEnterTheWord_2.setBounds(87, 79, 311, 56);
		 panel5.add(lblEnterTheWord_2);
		 JLabel Sucess = new JLabel("");
		 Sucess.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		 Sucess.setHorizontalAlignment(SwingConstants.CENTER);
		 Sucess.setBounds(115, 322, 242, 71);
		 panel5.add(Sucess);
		 
		 JButton btnDelete_1 = new JButton("Delete");
		 btnDelete_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		String key = DeleteText.getText();
		 		Node node = new Node(key);
		 		boolean Del = f.RBT.delete(node);
		 		if(Del == true) {
		 			Sucess.setText("SUCESSFULLY DELETED");
		 			f.RBT.DictSize--;
		 		}
		 		else
		 			Sucess.setText("PLEASE TRY AGAIN");
		 		DeleteText.setText("");
		 	}
		 });
		 btnDelete_1.setBackground(SystemColor.inactiveCaption);
		 btnDelete_1.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 18));
		 btnDelete_1.setBounds(294, 462, 163, 36);
		 panel5.add(btnDelete_1);
		 
		 JButton btnBackToMain = new JButton("Back To Main Menu");
		 btnBackToMain.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		DeleteText.setText("");
		 		Sucess.setText("");
		 		panel1.setVisible(true);
		 		panel2.setVisible(false);
		 		panel3.setVisible(false);
		 		panel4.setVisible(false);
		 		panel5.setVisible(false);

		 	}
		 });
		 btnBackToMain.setBackground(SystemColor.inactiveCaption);
		 btnBackToMain.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 18));
		 btnBackToMain.setBounds(12, 462, 200, 36);
		 panel5.add(btnBackToMain);
		 
		 
		 
		 panel4 = new JPanel();
		 panel4.setBackground(SystemColor.activeCaption);
		 panel4.setBounds(0, 0, 469, 511);
		 frame.getContentPane().add(panel4);
		 panel4.setLayout(null);
		 
		 search = new JTextField();
		 search.setBounds(117, 197, 205, 33);
		 panel4.add(search);
		 search.setColumns(10);
		 panel4.setVisible(false);
		 
		 JButton btnNewButton = new JButton("Search");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		String in = search.getText();
		 		Node n = f.RBT.root;
		 		n = f.RBT.Search(n,in);
		 		search.setVisible(false);
		 		lblEnterTheWord_1.setVisible(false);
		 		if(n!=f.RBT.nill) {
		 		FoundLabel.setText("FOUND!!"+n.key);
		 		if(n.color==1)
		 		{
		 			Colo.setText("Color is BLACK");
		 		}
		 		else
		 			Colo.setText("COLOR IS RED");
		 		
		 		
		 	}else
		 	{
		 		FoundLabel.setText("NOT FOUND!");
		 	}
		 	btnNewButton.setVisible(false);	
		 	}
		 });
		 btnNewButton.setBackground(SystemColor.inactiveCaption);
		 btnNewButton.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 18));
		 btnNewButton.setBounds(323, 465, 134, 33);
		 panel4.add(btnNewButton);
		 
		 JButton btnNewButton_1 = new JButton("Main Menu");
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		panel1.setVisible(true);
		 		panel2.setVisible(false);
		 		panel3.setVisible(false);
		 		panel4.setVisible(false);
		 	}
		 });
		 btnNewButton_1.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 18));
		 btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		 btnNewButton_1.setBounds(12, 465, 134, 33);
		 panel4.add(btnNewButton_1);
		 
		 lblEnterTheWord_1 = new JLabel("Enter The Word You'd Like To Search");
		 lblEnterTheWord_1.setHorizontalAlignment(SwingConstants.CENTER);
		 lblEnterTheWord_1.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 18));
		 lblEnterTheWord_1.setBounds(25, 97, 380, 33);
		 panel4.add(lblEnterTheWord_1);
		 
		 FoundLabel = new JLabel("");
		 FoundLabel.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		 FoundLabel.setBounds(36, 256, 205, 33);
		 panel4.add(FoundLabel);
		 
		 Colo = new JLabel("");
		 Colo.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 18));
		 Colo.setBounds(25, 319, 216, 33);
		 panel4.add(Colo);
		
		 panel3 = new JPanel();
		panel3.setBackground(SystemColor.activeCaption);
		panel3.setBounds(0, 0, 469, 511);
		frame.getContentPane().add(panel3);
		panel3.setLayout(null);
		panel3.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Dictonary Size is =");
		lblNewLabel.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
		lblNewLabel.setBounds(33, 117, 211, 50);
		panel3.add(lblNewLabel);
		
		JLabel DictSize = new JLabel("");
		DictSize.setFont(new Font("Sitka Text", Font.BOLD, 18));
		DictSize.setBounds(256, 117, 117, 33);
		panel3.add(DictSize);
		
		JLabel lblRedBlackTree = new JLabel("Red Black Tree Height=");
		lblRedBlackTree.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
		lblRedBlackTree.setBounds(33, 282, 211, 50);
		panel3.add(lblRedBlackTree);
		
		JLabel height = new JLabel("");
		height.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
		height.setBounds(256, 282, 138, 33);
		panel3.add(height);
		
		JButton ReturnToMain = new JButton("MainMenu");
		ReturnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel1.setVisible(true);
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
			}
		});
		ReturnToMain.setBackground(SystemColor.inactiveCaption);
		ReturnToMain.setForeground(SystemColor.menuText);
		ReturnToMain.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
		ReturnToMain.setBounds(12, 454, 148, 44);
		panel3.add(ReturnToMain);
		
		panel2 = new JPanel();
		panel2.setBackground(SystemColor.activeCaption);
		panel2.setBounds(0, 0, 469, 517);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		panel2.setVisible(false);
		
		JButton btnMenu = new JButton("Return");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel1.setVisible(true);
				panel2.setVisible(false);
			}
		});
		btnMenu.setBackground(SystemColor.inactiveCaption);
		btnMenu.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 16));
		btnMenu.setBounds(12, 472, 157, 32);
		panel2.add(btnMenu);
		
		JLabel lblEnterTheWord = new JLabel("Enter the word you'd like to insert:");
		lblEnterTheWord.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lblEnterTheWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTheWord.setBounds(76, 25, 294, 44);
		panel2.add(lblEnterTheWord);
		
		textField = new JTextField();
		textField.setBounds(114, 150, 208, 44);
		panel2.add(textField);
		textField.setColumns(10);
		
		JButton btnInsert_1 = new JButton("Insert");
		btnInsert_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String line = textField.getText();
				if(line.equals(""))
				{
					textField.setText("");
					label.setText("PLEASE TRY AGAIN");
				}
				else
				{
					textField.setText("");
					Node node = new Node(line);
					f.RBT.insert(node);
					f.RBT.DictSize++;
					label.setText("SUCCESSFULLY INSERTED");
				}
			}
		});
		btnInsert_1.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		btnInsert_1.setBounds(300, 472, 157, 32);
		panel2.add(btnInsert_1);
		
		label = new JLabel("");
		label.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 18));
		label.setBounds(105, 268, 246, 62);
		panel2.add(label);
		 
		  panel1 = new JPanel();
		  panel1.setBounds(0, 0, 573, 558);
		  frame.getContentPane().add(panel1);
		  panel1.setBackground(SystemColor.inactiveCaption);
		  panel1.setLayout(null);
		  btnSearch = new JButton("Search For A Word");
		  btnSearch.setBounds(70, 85, 252, 55);
		  panel1.add(btnSearch);
		  btnSearch.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  	panel1.setVisible(false);
		  	panel4.setVisible(true);
		  	panel3.setVisible(false);
		  	panel2.setVisible(false);
		  	FoundLabel.setText("");
		  	Colo.setText("");
		  	search.setVisible(true);
		  	search.setText("");
		  	lblEnterTheWord_1.setVisible(true);		  	
		  	btnNewButton.setVisible(true);
		  	}
		  });
		  btnSearch.setBackground(SystemColor.activeCaption);
		  btnSearch.setFont(new Font("Swis721 Ex BT", Font.BOLD, 16));
		  
		  btnInsert = new JButton("Insert A Word");
		  btnInsert.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		panel1.setVisible(false);
		  		panel2.setVisible(true);
		  	}
		  });
		  btnInsert.setBounds(70, 202, 252, 55);
		  panel1.add(btnInsert);
		  btnInsert.setBackground(SystemColor.activeCaption);
		  btnInsert.setFont(new Font("Swis721 Ex BT", Font.BOLD, 16));
		  
		  btnDelete = new JButton("Delete A Word");
		  btnDelete.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		panel5.setVisible(true);
		  		panel1.setVisible(false);
		  		panel2.setVisible(false);
		  		panel3.setVisible(false);
		  		panel4.setVisible(false);
		  	}
		  });
		  btnDelete.setBounds(70, 315, 252, 55);
		  panel1.add(btnDelete);
		  btnDelete.setBackground(SystemColor.activeCaption);
		  btnDelete.setFont(new Font("Swis721 Ex BT", Font.BOLD, 16));
		  
		  btnSize = new JButton("Check Dictionary Size");
		  btnSize.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		panel1.setVisible(false);
		  		panel2.setVisible(false);
		  		panel3.setVisible(true);
		  		DictSize.setText(Integer.toString(f.RBT.DictSize));
		  		height.setText(Integer.toString(f.RBT.TreeHeight(f.RBT.root)));
		  	}
		  });
		  btnSize.setBounds(70, 409, 252, 55);
		  panel1.add(btnSize);
		  btnSize.setBackground(SystemColor.activeCaption);
		  btnSize.setFont(new Font("Swis721 Ex BT", Font.BOLD, 16));
		  
		  lblDictionary = new JLabel("DICTIONARY");
		  lblDictionary.setBounds(121, 13, 167, 36);
		  panel1.add(lblDictionary);
		  lblDictionary.setHorizontalAlignment(SwingConstants.CENTER);
		  lblDictionary.setFont(new Font("Source Sans Pro Black", Font.BOLD, 21));
		
		
	}
}
