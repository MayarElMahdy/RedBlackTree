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
	JPanel panel1 ;
	file f;
	private JPanel panel2;
	private JTextField textField;
	private JLabel label;

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
		  		panel1.setVisible(false);
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
