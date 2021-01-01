package com.magicsheep.randomduty;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;

//Coded by Brandon Black (MagicSheep)
//Date: 12/23/20 (dd/mm/yy)
//This actual trashcan picks a random duty to run for Final Fantasy XIV. The user will have three buttons to click, one for each type of Duty, and four checkboxes which dictate what expansion the duties should be
//picked from. Eventually, there will be three additional checkboxes to allow for the inclusion of Hard dungeon variants, Extreme trials, and Savage raids.

/*
* Description of all used variables:
* JLabel chosenDuty: Displays the duty picked by the program.
* int buttonUsed: Can be either 1, 2, or 3. Tells Randomize() which case to use.
* JButton dungeonButton: Used to pick a dungeon. Has an action listener which sets buttonUsed to 1 and calls Randomize(). 
* JButton trialButton: Used to pick a trial. Has an action listener which sets buttonUsed to 2 and calls Randomize(). 
* JButton raidButton: Used to pick a raid. Has an action listener which sets buttonUsed to 3 and calls Randomize(). 
* JLabel options: Displays the text "--- Options ---" under the buttons.
* JCheckBox ARR: Is used to add the "A Realm Reborn" content to the randomizer pools.
* JCheckBox HW: Is used to add the "Heavensward" content to the randomizer pools.
* JCheckBox SB: Is used to add the "Stormblood" content to the randomizer pools.
* JCheckBox SHB: Is used to add the "Shadowbringers" content to the randomizer pools.
* JCheckBox includeHard: Includes (Hard) versions of dungeons in the randomizer pool. Currently unused.
* JCheckBox includeExtreme: Includes (Extreme) trials in the randomizer pool. Currently unused.
* JCheckBox includeSavage: Includes (Savage) raids in the randomizer pool. Currently Unused.
* String chosenDungeon: Holds the chosen dungeon text and sets the chosenDuty label.
* String chosenTrial: Holds the chosen trial text and sets the chosenDuty label.
* String chosenRaid: Holds the chosen raid text and sets the chosenDuty label.
* The Whole mess of String arrays: These hold onto the respective content their lavbel suggests. All info was gathered from in-game and the Lodestone.
* double randomNumber: Holds the value of Math.random.
* int mathRandom: Holds the value of Math.random, is also used to point to a randomly picked spot in an array.
* String arrRandom: Holds the value of the randomly picked "A Realm Reborn" content.
* String hwRandom: Holds the value of the randomly picked "Heavensward" content.
* String sbRandon: Holds the value of the randomly picked "Stormblood" content.
* String shbRandom: Holds the value of the randomly picked "Shadowbringers" content.
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
	
	//Arrays
	String arrDungeons[] = {"Sastasha", "The Tam-Tara Deepcroft", "Copperbell Mines", "Halatali", "The Thousand Maws of Toto-Rak", "Haukke Manor", "Brayflox's Longstop", "The Sunken Temple of Qarn",
							"Cutter's Cry", "The Stone Vigil", "Dzemael Darkhold", "The Aurum Vale", "The Wanderer's Palace", "Castrum Meridianum", "The Praetorium", "Amdapor Keep",
							"Pharos Sirius", "The Lost City of Amdapor", "Hullbreaker Isle", "Snowcloak", "The Keeper of the Lake",};
	
	String hwDungeons[] = {"The Dusk Vigil", "Sohm Al", "The Aery", "The Vault", "The Great Gubal Library", "The Aetherochemical Research Facility", "Neverreap", "The Fractal Continuum",
						   "Saint Mocianne's Arboretum", "The Antitower", "Sohr Khai", "Xelphatol", "Baelsar's Wall"};
	
	String sbDungeons[] = {"The Sirensong Sea", "Shisui of the Violet Tides", "Bardam's Mettle", "Doma Castle", "Castrum Abania", "Ala Mhigo", "Kugane Castle", "The Temple of the Fist",
						   "The Drowned City of Skalla", "Hell's Lid", "The Swallow's Compass", "The Burn", "The Ghimlyt Dark"};
	
	String shbDungeons[] = {"Holminster Switch", "Dohn Mheg", "The Qitana Ravel", "Malikah's Well", "Mt. Gulg", "Amaurot", "The Twinning", "Akadaemia Anyder",
						   "The Grand Cosmos", "Anamnesis Anyder", "The Heroes' Gauntlet", "Matoya's Relict"};
	
	String arrTrials[] = {"The Bowl of Embers", "The Navel", "The Howling Eye", "Cape Westwind", "The Chrysalis", "The Steps of Faith", "A Relic Reborn: Chimera", "A Relic Reborn: Hydra",
						  "Battle on the Big Bridge", "The Dragon's Neck", "Battle in the Big Keep", "Thornmarch", "The Whorleater", "The Striking Tree", "The Akh Afah Amphitheatre", "Urth's Fount",};
	
	String hwTrials[] = {"Thok ast Thok", "The Limitless Blue", "The Singularity Reactor", "The Final Steps of Faith", "Containment Bay S1T7", "Containment Bay P1T6", "Containment Bay Z1T9"};
	
	String sbTrials[] = {"The Pool of Tribute", "Emanation", "The Royal Mengerie", "Castrum Fluminis", "Kugane Ohashi", "The Great Hunt", "The Jade Stoa", "Hells' Kier",
						 "The Wreath of Snakes"};
	
	String shbTrials[] = {"The Dancing Plague", "The Crown of the Immaculate", "The Dying Gasp", "Cinder Drift", "The Seat of Sacrifice", "Castrum Marinum"};
	
	String arrRaids[] = {"Labyrinth of the Ancients", "Syrcus Tower", "World of Darkness", "Bahamut: Coil 1 Turn 1", "Bahamut: Coil 1 Turn 2", "Bahamut: Coil 1 Turn 3", "Bahamut: Coil 1 Turn 4", "Bahamut: Coil 2 Turn 1",
						 "Bahamut: Coil 2  Turn 2", "Bahamut: Coil 2 Turn 3", "Bahamut: Coil 2 Turn 4", "Bahamut: Coil 3 Turn 1", "Bahamut: Coil 3 Turn 2", "Bahamut: Coil 3 Turn 3", "Bahamut: Coil 3 Turn 4"};
	
	String hwRaids[] = {"The Void Ark", "Weeping City of Mhach", "Dun Scaith", "Alex: Fist of the Father", "Alex: Cuff of the Father", "Alex: Arm of the Father", "Alex: Burden of the Father", "Alex: Fist of the Son",
						"Alex: Cuff of the Son", "Alex: Arm of the Son", "Alex: Burden of the Son", "Alex: Eyes of the Creator", "Alex: Breath of the Creator", "Alex: Heat of the Creator", "Alex: Soul of the Creator"};
	
	String sbRaids[] = {"Royal City of Rabanastre", "Ridorana Lighthouse", "Orbonne Monastery", "Deltascape V1", "Deltascape V2", "Deltascape V3", "Deltascape V4", "Sigmascape V1",
						"Sigmascape V2", "Sigmascape V3", "Sigmascape V4", "Alphascape V1", "Alphascape V2", "Alphascape V3", "Alphascape V4"};
	
	String shbRaids[] = {"Copied Factory", "Puppets' Bunker", "Eden: Resurrection", "Eden: Descent", "Eden: Inundation", "Eden: Sepulture", "Eden: Furor", "Eden: Iconoclasm",
						 "Eden: Refulgence", "Eden: Umbra", "Eden: Litany", "Eden: Anamorphosis", "Eden: Eternity",};

	
	
	RandomDuty() {
		
		//Declarations
		frame = new JFrame();
		chosenDuty = new JLabel("<Duty Name Here>");
		dungeonButton = new JButton("Dungeon");
		trialButton = new JButton("Trial");
		raidButton = new JButton("Raid");
		JLabel greeting = new JLabel("o/ from Dylan Dedekita @ Faerie!");
		
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
		
		//Turning off the other three since they aren't implemented yet
		includeHard.setEnabled(false);
		includeExtreme.setEnabled(false);
		includeSavage.setEnabled(false);
		
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
		chosenDuty.setBounds(200, 20, 250, 50);
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
		greeting.setBounds(320, 295, 400, 15);
		
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
		greeting.setForeground(Color.WHITE);
		
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
		frame.add(greeting);
		
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
		
		String chosenDungeon = " ";
		String chosenTrial = " ";
		String chosenRaid = " ";
		
		switch (buttonUsed) {
		
		case 1:  chosenDungeon = pickDungeon(chosenDungeon);
				 chosenDuty.setText(chosenDungeon);
				 break;
			
		case 2:  chosenTrial = pickTrial(chosenTrial);
				 chosenDuty.setText(chosenTrial);
				 break;
			
		case 3:  chosenRaid = pickRaid(chosenRaid);
				 chosenDuty.setText(chosenRaid);
				 break;
			
		default: break;
		
		}//end switch for buttonUsed
	
	}//end randomize

//-----------------------------------------------------------------------
	
	public String pickDungeon(String chosenDungeon) {
		
		ArrayList<String> DungeonList = new ArrayList<String>();
		double randomNumber = 0.0;
		int mathRandom = 0;
		
		//Pick ARR Dungeon
		if (ARR.isSelected()) {
		randomNumber = Math.random() * arrDungeons.length;
		mathRandom = (int)(randomNumber);
		String arrRandom = arrDungeons[mathRandom];
		DungeonList.add(arrRandom);
		}
		
		//Pick HW Dungeon
		if (HW.isSelected()) {
		randomNumber = Math.random() * hwDungeons.length;
		mathRandom = (int)(randomNumber);
		String hwRandom = hwDungeons[mathRandom];
		DungeonList.add(hwRandom);
		}
		
		//Pick SB Dungeon
		if (SB.isSelected()) {
		randomNumber = Math.random() * sbDungeons.length;
		mathRandom = (int)(randomNumber);
		String sbRandom = sbDungeons[mathRandom];
		DungeonList.add(sbRandom);
		}
		
		//Pick SHB Dungeon
		if (SHB.isSelected()) {
		randomNumber = Math.random() * shbDungeons.length;
		mathRandom = (int)(randomNumber);
		String shbRandom = shbDungeons[mathRandom];
		DungeonList.add(shbRandom);
		}
		
		if (!ARR.isSelected() && !HW.isSelected() && !SB.isSelected() && !SHB.isSelected()) {
			chosenDungeon = "Please select at least one box.";
			return chosenDungeon;
		}
		else {
		//Choose from the randomly picked dungeons and return to Randomize()
		randomNumber = Math.random() * DungeonList.size();
		mathRandom = (int)(randomNumber);
		chosenDungeon = DungeonList.get(mathRandom);
		return chosenDungeon;
		}
	}//end pickDungeon
	
//-----------------------------------------------------------------------
	
	public String pickTrial(String chosenTrial) {
		
		ArrayList<String> TrialList = new ArrayList<String>();
		double randomNumber = 0.0;
		int mathRandom = 0;
		
		//Pick ARR Trial
		if (ARR.isSelected()) {
		randomNumber = Math.random() * arrTrials.length;
		mathRandom = (int)(randomNumber);
		String arrRandom = arrTrials[mathRandom];
		TrialList.add(arrRandom);
		}
		
		//Pick HW Trial
		if (HW.isSelected()) {
		randomNumber = Math.random() * hwTrials.length;
		mathRandom = (int)(randomNumber);
		String hwRandom = hwTrials[mathRandom];
		TrialList.add(hwRandom);
		}
		
		//Pick SB Trial
		if (SB.isSelected()) {
		randomNumber = Math.random() * sbTrials.length;
		mathRandom = (int)(randomNumber);
		String sbRandom = sbTrials[mathRandom];
		TrialList.add(sbRandom);
		}
		
		//Pick SHB Trial
		if (SHB.isSelected()) {
		randomNumber = Math.random() * shbTrials.length;
		mathRandom = (int)(randomNumber);
		String shbRandom = shbTrials[mathRandom];
		TrialList.add(shbRandom);
		}
		
		if (!ARR.isSelected() && !HW.isSelected() && !SB.isSelected() && !SHB.isSelected()) {
			chosenTrial = "Please select at least one box.";
			return chosenTrial;
		}
		else {
		//Choose from the randomly picked trials and return to Randomize()
		randomNumber = Math.random() * TrialList.size();
		mathRandom = (int)(randomNumber);
		chosenTrial = TrialList.get(mathRandom);
		return chosenTrial;
		}
	}//end pickTrial
	
//-----------------------------------------------------------------------
	
	public String pickRaid(String chosenRaid) {
		
		ArrayList<String> RaidList = new ArrayList<String>();
		double randomNumber = 0.0;
		int mathRandom = 0;
		
		//Pick ARR Raid
		if (ARR.isSelected()) {
		randomNumber = Math.random() * arrRaids.length;
		mathRandom = (int)(randomNumber);
		String arrRandom = arrRaids[mathRandom];
		RaidList.add(arrRandom);
		}
		
		//Pick HW Raid
		if (HW.isSelected()) {
		randomNumber = Math.random() * hwRaids.length;
		mathRandom = (int)(randomNumber);
		String hwRandom = hwRaids[mathRandom];
		RaidList.add(hwRandom);
		}
		
		//Pick SB Raid
		if (SB.isSelected()) {
		randomNumber = Math.random() * sbRaids.length;
		mathRandom = (int)(randomNumber);
		String sbRandom = sbRaids[mathRandom];
		RaidList.add(sbRandom);
		}
		
		//Pick SHB Raid
		if (SHB.isSelected()) {
		randomNumber = Math.random() * shbRaids.length;
		mathRandom = (int)(randomNumber);
		String shbRandom = shbRaids[mathRandom];
		RaidList.add(shbRandom);
		}
		
		if (!ARR.isSelected() && !HW.isSelected() && !SB.isSelected() && !SHB.isSelected()) {
			chosenRaid = "Please select at least one box.";
			return chosenRaid;
		}
		else {
		//Choose from the randomly picked raids and return to Randomize()
		randomNumber = Math.random() * RaidList.size();
		mathRandom = (int)(randomNumber);
		chosenRaid = RaidList.get(mathRandom);
		return chosenRaid;
		}
	}//end pickRaid
	
//-----------------------------------------------------------------------
	
}//End of class RandomDuty
