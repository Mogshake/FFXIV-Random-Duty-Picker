package com.magicsheep.randomduty;

import java.awt.Color;
import javax.swing.JFrame;

//Coded by Brandon Black (MagicSheep)
//Date: 12/23/20 (dd/mm/yy)
//This actual trashcan picks a random duty to run for Final Fantasy XIV. The user will have the option to select if they want Dungeons, Trials, and/or Raids and from what expansion they want.

/*
* Description of all used variables:
* 
* 
* 
*/


public class RandomDuty {
	
	//Global Declarations
	private JFrame frame;
	
	
	RandomDuty() {
		
		//Declarations
		frame = new JFrame();

		
		
		//Fancy frame stuff
		frame.setSize(500, 350); //width, height
		frame.setLayout(null); 
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Duty Roulette");
		frame.setVisible(true);
	}//End of DowntimeTracker constructor

	public static void main(String[] args) {
		
		//Declarations
		
		new RandomDuty();

	}//End of Main Method

}//End of class RandomDuty
