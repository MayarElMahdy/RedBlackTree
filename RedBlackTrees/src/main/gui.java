package main;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import RedBlackTree.RedBlackTrees;
import RedBlackTree.file;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

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
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		
		 panel1 = new JPanel();
		panel1.setBackground(SystemColor.inactiveCaption);
		panel1.setBounds(0, 0, 432, 497);
		frame.getContentPane().add(panel1);
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
		frame.setBounds(100, 100, 450, 544);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
