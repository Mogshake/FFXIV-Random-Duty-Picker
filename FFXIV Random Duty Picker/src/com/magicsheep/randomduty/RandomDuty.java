package com.magicsheep.randomduty;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Coded by Brandon Black (MagicSheep)
//Date: 12/23/20 (dd/mm/yy)
//This actual trashcan picks a random duty to run for Final Fantasy XIV. The user will have the option to select if they want Dungeons, Trials, and/or Raids and from what expansion they want.

/*
* Description of all used variables:
* JLabel chosenDuty
* int buttonUsed
* JButton dungeonButton 
* JButton trialButton
* JButton raidButton
* JLabel options
* JCheckBox ARR
* JCheckBox HW
* JCheckBox SB
* JCheckBox SHB
* JCheckBox includeHard;
* JCheckBox includeExtreme;
* JCheckBox includeSavage;
* 
* 
*/


public class RandomDuty {
	
	//Global Declarations
	private JFrame frame;
	private JLabel chosenDuty;
	int buttonUsed = 0;
	private JButton dungeonButton;
	private JButton trialButton;
	private JButton raidButton;
	private JLabel options;
	private JCheckBox ARR;
	private JCheckBox HW;
	private JCheckBox SB;
	private JCheckBox SHB;
	private JCheckBox includeHard;
	private JCheckBox includeExtreme;
	private JCheckBox includeSavage;
	
	
	RandomDuty() {
		
		//Declarations
		frame = new JFrame();
		chosenDuty = new JLabel("<Duty Name Here>");
		dungeonButton = new JButton("Dungeon");
		trialButton = new JButton("Trial");
		raidButton = new JButton("Raid");
		
		options = new JLabel("----- Options -----");
		ARR = new JCheckBox("A Realm Reborn");
		HW = new JCheckBox("Heavensward");
		SB = new JCheckBox("Stormblood");
		SHB = new JCheckBox("Shadowbringers");
		includeHard = new JCheckBox("Include Hard Variants");
		includeExtreme = new JCheckBox("Include Extreme Trials");
		includeSavage = new JCheckBox("Include Savage Raids");
		
		//Set a few default values
		ARR.setSelected(true);
		HW.setSelected(true);
		SB.setSelected(true);
		SHB.setSelected(true);
		
		//Listeners
		dungeonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonUsed = 1;
				randomize();
			}
		});//end dungeonButton action listener
		
		trialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonUsed = 2;
				randomize();
			}
		});//end trialButton action listener
		
		raidButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonUsed = 3;
				randomize();
			}
		});//end raidButton action listener

		//Set the size of stuff (x, y, width, height)
		chosenDuty.setBounds(200, 20, 200, 50);
		dungeonButton.setBounds(100, 65, 100, 25);
		trialButton.setBounds(200, 65, 100, 25);
		raidButton.setBounds(300, 65, 100, 25);
		options.setBounds(200, 30, 200, 200);
		ARR.setBounds(100, 150, 150, 15);
		HW.setBounds(100, 180, 150, 15);
		SB.setBounds(100, 210, 150, 15);
		SHB.setBounds(100, 240, 150, 15);
		includeHard.setBounds(300, 150, 150, 15);
		includeExtreme.setBounds(300, 180, 160, 15);
		includeSavage.setBounds(300, 210, 150, 15);
		
		//Adjust colors
		chosenDuty.setForeground(Color.WHITE);
		options.setForeground(Color.WHITE);
		ARR.setForeground(Color.WHITE);
		ARR.setBackground(Color.BLACK);
		HW.setForeground(Color.WHITE);
		HW.setBackground(Color.BLACK);
		SB.setForeground(Color.WHITE);
		SB.setBackground(Color.BLACK);
		SHB.setForeground(Color.WHITE);
		SHB.setBackground(Color.BLACK);
		includeHard.setForeground(Color.WHITE);
		includeHard.setBackground(Color.BLACK);
		includeExtreme.setForeground(Color.WHITE);
		includeExtreme.setBackground(Color.BLACK);
		includeSavage.setForeground(Color.WHITE);
		includeSavage.setBackground(Color.BLACK);
		
		//Add stuff to the frame
		frame.add(chosenDuty);
		frame.add(dungeonButton);
		frame.add(trialButton);
		frame.add(raidButton);
		frame.add(options);
		frame.add(ARR);
		frame.add(HW);
		frame.add(SB);
		frame.add(SHB);
		frame.add(includeHard);
		frame.add(includeExtreme);
		frame.add(includeSavage);
		
		//Fancy frame stuff
		frame.setSize(525, 350); //width, height
		frame.setLayout(null); 
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Duty Roulette");
		frame.setVisible(true);
	}//End of DowntimeTracker constructor

	public static void main(String[] args) {
		
		new RandomDuty();

	}//End of Main Method
	
//-----------------------------------------------------------------------
	
	public void randomize() {
		
		switch (buttonUsed) {
		
		case 1:  chosenDuty.setText("dungeonName");
				 break;
			
		case 2:  chosenDuty.setText("trialName");
				 break;
			
		case 3:  chosenDuty.setText("raidName");
				 break;
			
		default: break;
		
		}//end switch for buttonUsed
	
	}//end randomize

//-----------------------------------------------------------------------
	
}//End of class RandomDuty
