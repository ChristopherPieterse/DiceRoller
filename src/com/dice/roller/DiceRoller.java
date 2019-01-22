package com.dice.roller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class DiceRoller {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiceRoller window = new DiceRoller();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DiceRoller() {
		initialize();
	}
	
	public String rollDice(int times, int face) {
		String full = "";
		int total = 0;
		int roll;
		for(int i = 0; i < times; i++) {
			roll = (int)(Math.random()*face) + 1;
			total+=roll;
			full += "Roll " + (i+1) + ": " + roll + "  ";
		}
		full+= "Total: " + total;
		return full;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextPane inputDice = new JTextPane();
		inputDice.setBounds(202, 11, 172, 100);
		panel.add(inputDice);
		
		JLabel lblInputDiceRolls = new JLabel("Input Any # of Rolls ->");
		lblInputDiceRolls.setBounds(26, 11, 124, 28);
		panel.add(lblInputDiceRolls);
		
		JTextPane outputDice = new JTextPane();
		JScrollPane outputDice2 = new JScrollPane(outputDice);
		outputDice.setEditable(false);
		outputDice2.setBounds(10, 125, 364, 125);
		panel.add(outputDice2);
		
		JButton btnRoll = new JButton("Roll");
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String listDice = inputDice.getText();
				Scanner scList =  new Scanner(listDice);
				Scanner scLine;
				String line;
				String output = "";
				while(scList.hasNext()) {
					line = scList.nextLine();
					scLine = new Scanner(line).useDelimiter("d");
					int numRolls = scLine.nextInt();
					int dice = scLine.nextInt();
					output += rollDice(numRolls, dice) + "\n\n";
				}
				outputDice.setText(output);
			}
		});
		btnRoll.setBounds(49, 57, 89, 23);
		panel.add(btnRoll);
		
		
		
	}
}
