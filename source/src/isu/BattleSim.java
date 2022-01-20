package isu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BattleSim {
	static BattleData data = new BattleData();
	static JPanel botRight = new JPanel();
	static JPanel textPanel = new JPanel();
	static JPanel playerHP = new JPanel();
	static JPanel cpuHP = new JPanel();
	static JPanel playerActiveDisplay = new JPanel();
	static JPanel cpuActiveDisplay = new JPanel();

	static JButton btnBack = new JButton("BACK");
	
	static ArrayList<Monster> playerMons = new ArrayList<Monster>();
	static ArrayList<Monster> cpuMons = new ArrayList<Monster>();
	static int playerActiveMon = 1;
	static int cpuActiveMon = 1;

	static boolean flinchCheck = false;
	
	public static void main(String[] args) {
		pickTeamWindow();
	}
	
	public static void initWindow() {
		JFrame frame = new JFrame("Poke Him Mon");
		frame.setSize(600,400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new GridLayout(2,1,0,30));
		frame.setVisible(true);
		
		JLayeredPane top = new JLayeredPane();
		JPanel bottom = new JPanel();
		JPanel topLeft = new JPanel();
		JPanel topRight = new JPanel();
		JPanel botLeft = new JPanel();
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){  
	        	mainWindow();
	         }  
	     });;
		
		top.setLayout(new GridLayout(1,2));
		bottom.setLayout(new GridLayout(1,2));
		topRight.setLayout(new GridLayout(2,1));
		topLeft.setLayout(new GridLayout(2,1));
		botLeft.setLayout(new BorderLayout());
		
		playerHP.setLayout(new GridLayout(2,1));
		cpuHP.setLayout(new GridLayout(2,1));
		textPanel.setLayout(new BoxLayout(textPanel,BoxLayout.PAGE_AXIS));
		textPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 0, 0));
		playerHP.setLayout(new BoxLayout(playerHP,BoxLayout.PAGE_AXIS));
		playerHP.setBorder(BorderFactory.createEmptyBorder(40, 20, 0, 50));
		cpuHP.setLayout(new BoxLayout(cpuHP,BoxLayout.PAGE_AXIS));
		cpuHP.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 20));
		playerActiveDisplay.setLayout(new BoxLayout(playerActiveDisplay,BoxLayout.LINE_AXIS));
		playerActiveDisplay.setBorder(BorderFactory.createEmptyBorder(0, 150, 0, 0));
		cpuActiveDisplay.setLayout(new BoxLayout(cpuActiveDisplay,BoxLayout.LINE_AXIS));
		cpuActiveDisplay.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
		
		frame.add(top);
		frame.add(bottom);
		top.add(topLeft,1);
		top.add(topRight,1);
		bottom.add(botLeft);
		bottom.add(botRight);
		topLeft.add(cpuHP);
		topLeft.add(playerActiveDisplay);
		topRight.add(cpuActiveDisplay);
		topRight.add(playerHP);
		botLeft.add(textPanel, BorderLayout.CENTER);
	    botLeft.add(btnBack, BorderLayout.SOUTH);
	    
	    // https://i.imgur.com/VQZQbew.png
	    textPanel.setBackground(Color.WHITE);
		
	    firstTurn();
	}
	
	public static void pickTeam(int team, ArrayList<Monster> list) {
		Monster m1 = new Monster("MISSINGNO");
		Monster m2 = new Monster("MISSINGNO");
		Monster m3 = new Monster("MISSINGNO");
		Image frontSprite1 = null;
		Image frontSprite2 = null;
		Image frontSprite3 = null;
		Image backSprite1 = null;
		Image backSprite2 = null;
		Image backSprite3 = null;
		switch (team) {
		case 1:
			m1 = new Monster("Zhapthos");
	        try {
	            URL url = new URL("https://img.pokemondb.net/sprites/black-white/normal/zapdos.png");
	            frontSprite1 = ImageIO.read(url);
	        } 
	        catch (IOException e) {
	        }
	        try {
	            URL url = new URL("https://img.pokemondb.net/sprites/black-white/back-normal/zapdos.png");
	            backSprite1 = ImageIO.read(url);
	        } 
	        catch (IOException e) {
	        }
	        m1.setAllAtks(20,7,10,11);
	        m1.setTypes(4,8);
			m1.setStats(165,85,105,177,111,167);
			
			m2 = new Monster("Llefable");
	        try {
	            URL url = new URL("https://img.pokemondb.net/sprites/black-white/normal/clefable.png");
	            frontSprite2 = ImageIO.read(url);
	        } 
	        catch (IOException e) {
	        } 
	        try {
	            URL url = new URL("https://img.pokemondb.net/sprites/black-white/back-normal/clefable.png");
	            backSprite2 = ImageIO.read(url);
	        } 
	        catch (IOException e) {
	        }
	        m2.setAllAtks(15,20,8,13);
	        m2.setTypes(5,0);
			m2.setStats(202,67,93,161,111,80);
			
			m3 = new Monster("Bippowdon");
	        try {
	            URL url = new URL("https://img.pokemondb.net/sprites/black-white/normal/hippowdon.png");
	            frontSprite3 = ImageIO.read(url);
	        } 
	        catch (IOException e) {
	        }
	        try {
	            URL url = new URL("https://img.pokemondb.net/sprites/black-white/back-normal/hippowdon.png");
	            backSprite3 = ImageIO.read(url);
	        } 
	        catch (IOException e) {
	        }
	        m3.setAllAtks(6,3,4,5);
	        m3.setTypes(11,0);
			m3.setStats(215,180,138,79,93,67);
			
			break;
		case 2:
			m1 = new Monster("Selipper");
	        try {
	            URL url = new URL("https://img.pokemondb.net/sprites/black-white/normal/pelipper.png");
	            frontSprite1 = ImageIO.read(url);
	        } 
	        catch (IOException e) {
	        }
	        try {
	            URL url = new URL("https://img.pokemondb.net/sprites/black-white/back-normal/pelipper.png");
	            backSprite1 = ImageIO.read(url);
	        } 
	        catch (IOException e) {
	        }
	        m1.setAllAtks(1,12,2,19);
	        m1.setTypes(18,8);
			m1.setStats(167,49,120,161,91,85);
			
			m2 = new Monster("Wagnezone");
			try {
		            URL url = new URL("https://img.pokemondb.net/sprites/black-white/normal/magnezone.png");
		            frontSprite2 = ImageIO.read(url);
		        } 
		    catch (IOException e) {
		        }
		    try {
		            URL url = new URL("https://img.pokemondb.net/sprites/black-white/back-normal/magnezone.png");
		            backSprite2 = ImageIO.read(url);
		        } 
		    catch (IOException e) {
		        }
		    m2.setAllAtks(20,9,21,3);
		    m2.setTypes(4,17);
			m2.setStats(177,67,135,200,111,80);
			
			m3 = new Monster("Meavile");
			 try {
		            URL url = new URL("https://img.pokemondb.net/sprites/black-white/normal/weavile.png");
		            frontSprite3 = ImageIO.read(url);
		        } 
		     catch (IOException e) {
		        }
		     try {
		            URL url = new URL("https://img.pokemondb.net/sprites/black-white/back-normal/weavile.png");
		            backSprite3 = ImageIO.read(url);
		        } 
		     catch (IOException e) {
		        }
		    m3.setAllAtks(14,16,18,17);
		    m3.setTypes(12,2);
			m3.setStats(145,172,85,58,106,194);
			break;
		
		case 3:
			//team 3
			m1 = new Monster("Niboking");
	        try {
	            URL url = new URL("https://img.pokemondb.net/sprites/black-white/normal/nidoking.png");
	            frontSprite1 = ImageIO.read(url);
	        } 
	        catch (IOException e) {
	        }
	        try {
	            URL url = new URL("https://img.pokemondb.net/sprites/black-white/back-normal/nidoking.png");
	            backSprite1 = ImageIO.read(url);
	        } 
	        catch (IOException e) {
	        }
	        m1.setAllAtks(6,22,23,13);
	        m1.setTypes(14,11);
			m1.setStats(156,154,97,106,85,150);
			
			m2 = new Monster("Ikanroc-Dusk");
			try {
		            URL url = new URL("https://pokecharms.com/data/attachment-files/2019/03/thumb/705163_Dusk_Lycanroc.png");
					//URL url = new URL("https://img.pokemondb.net/sprites/ultra-sun-ultra-moon/normal/lycanroc-midnight.png");
		            frontSprite2 = ImageIO.read(url);
		        } 
		    catch (IOException e) {
		        }
		    try {
		            URL url = new URL("https://media.pokemoncentral.it/wiki/f/fe/Sprusulmd745C.gif");
		            backSprite2 = ImageIO.read(url);
		        } 
		    catch (IOException e) {
		        }
		    m2.setAllAtks(24,25,26,27);
		    m2.setTypes(16,0);
			m2.setStats(150,169,85,67,86,178);
			
			m3 = new Monster("Koliwrath");
			 try {
		            URL url = new URL("https://img.pokemondb.net/sprites/black-white/normal/poliwrath.png");
		            frontSprite3 = ImageIO.read(url);
		        } 
		     catch (IOException e) {
		        }
		     try {
		            URL url = new URL("https://img.pokemondb.net/sprites/black-white/back-normal/poliwrath.png");
		            backSprite3 = ImageIO.read(url);
		        } 
		     catch (IOException e) {
		        }
		    m3.setAllAtks(25,28,6,14);
		    m3.setTypes(18,6);
			m3.setStats(197,161,115,81,111,90);
			break;
		}
		m1.setSprites(frontSprite1,backSprite1);
		m2.setSprites(frontSprite2,backSprite2);
		m3.setSprites(frontSprite3,backSprite3);
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
	}
	
	public static void pickTeamWindow() {
		JFrame teamWindow = new JFrame("Pick your team");
		teamWindow.setSize(400,200);
		teamWindow.setResizable(false);
		teamWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		teamWindow.setLayout(new GridLayout(1,3,0,80));
		
		ButtonTeam b1 = new ButtonTeam(1);
		ButtonTeam b2 = new ButtonTeam(2);
		ButtonTeam b3 = new ButtonTeam(3);
		teamWindow.add(b1);
		teamWindow.add(b2);
		teamWindow.add(b3);
		
		teamWindow.setVisible(true);
	}
	
	public static void firstTurn() {
		JLabel l1 = new JLabel("You sent out " + playerMons.get(0).getMonName() + "!");
		JLabel l2 = new JLabel("The opponent sent out " + cpuMons.get(0).getMonName() + "!");
	    Component[] c = {l1,l2};
		addToPanel(c, textPanel);
	    mainWindow();
	    drawMonStats();
	}
	
	public static void mainWindow() {
		btnBack.setEnabled(false);
		clearPanel(botRight);
		
		JButton b1 = new JButton("FIGHT");
		b1.setToolTipText("Choose to attack!");
		b1.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){  
	            fightWindow();
	         }  
	     });
		
		JButton b2 = new JButton("SWITCH");
		b2.setToolTipText("Switch out your mon!");
		b2.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){  
	            switchWindow();
	         }  
	     });
		Component[] c = {b1,b2};
		setGridLayout(c.length, botRight);
		addToPanel(c, botRight);
	}
	
	public static void fightWindow() {
		btnBack.setEnabled(true);
		clearPanel(botRight);
		
		ButtonAtk b1 = new ButtonAtk(getActiveMon().getFirstAtk());
		ButtonAtk b2 = new ButtonAtk(getActiveMon().getSecondAtk());
		ButtonAtk b3 = new ButtonAtk(getActiveMon().getThirdAtk());
		ButtonAtk b4 = new ButtonAtk(getActiveMon().getFourthAtk());
		Component[] c = {b1,b2,b3,b4};
		setGridLayout(c.length, botRight);
		addToPanel(c, botRight);
	}
	
	public static void switchWindow() {
		btnBack.setEnabled(true);
		clearPanel(botRight);
		
		ButtonSwitch b1 = new ButtonSwitch(playerMons.get(0), 1, false);
		ButtonSwitch b2 = new ButtonSwitch(playerMons.get(1), 2, false);
		ButtonSwitch b3 = new ButtonSwitch(playerMons.get(2), 3, false);
		Component[] c = {b1,b2,b3};
		
		setGridLayout(c.length, botRight);
		addToPanel(c, botRight);
	}
	
	public static void switchWindowForced() {
		btnBack.setEnabled(false);
		clearPanel(botRight);
		
		if (playerMons.get(0).getHP() == 0 && playerMons.get(1).getHP() == 0 && playerMons.get(2).getHP() == 0) {
			clearPanel(textPanel);
			addToPanel(new JLabel("All of your mons fainted!"), textPanel);
			addToPanel(new JLabel("You blacked out!"),  textPanel);
		}
		
		ButtonSwitch b1 = new ButtonSwitch(playerMons.get(0), 1, true);
		ButtonSwitch b2 = new ButtonSwitch(playerMons.get(1), 2, true);
		ButtonSwitch b3 = new ButtonSwitch(playerMons.get(2), 3, true);
		Component[] c = {b1,b2,b3};
		setGridLayout(c.length, botRight);
		addToPanel(c, botRight);
	}

	public static void addToPanel(Component[] comps, JPanel panel) {
		int amt = comps.length;
		for (int i = 0; i < amt; i++) {
			// System.out.println(comps[i].toString());
			panel.add(comps[i]);	
		}
		panel.repaint();
		panel.revalidate();
	}
	
	public static void addToPanel(Component comp, JPanel panel) {
		panel.add(comp);
	}
	
	public static void clearPanel(JPanel panel) {
		Component[] c = panel.getComponents();
		int amt = c.length;
		for (int i = amt; i > 0; i--) {
			panel.remove(c[i-1]);
		}
		panel.repaint();
	}
	
	public static void setGridLayout(int amt, JPanel pane) {
		switch (amt) {
		case 1:
			pane.setLayout(new GridLayout(1,1));
			break;
		case 2:
			pane.setLayout(new GridLayout(1,2));
			break;
		case 3:
			pane.setLayout(new GridLayout(3,1));
			break;
		case 4:
			pane.setLayout(new GridLayout(2,2));
			break;
		}
	}

	public static void drawMonStats() {
		clearPanel(playerHP);
		clearPanel(cpuHP);
		clearPanel(playerActiveDisplay);
		clearPanel(cpuActiveDisplay);
		
		JLabel l1 = new JLabel(getActiveMon().getMonName() + " " + getActiveMon().getHP() + " / " + getActiveMon().getTotalHP());
		l1.setAlignmentX(0);
		JProgressBar p1 = new JProgressBar(0, getActiveMon().getTotalHP());
		p1.setValue(getActiveMon().getHP());
		Component[] a = {l1,p1};
		addToPanel(a, playerHP);
		
		JLabel l2 = new JLabel(getCPUActiveMon().getMonName() + " " + getCPUActiveMon().getHP() + " / " + getCPUActiveMon().getTotalHP());
		l2.setAlignmentX(1);
		JProgressBar p2 = new JProgressBar(0, getCPUActiveMon().getTotalHP());
		p2.setValue(getCPUActiveMon().getHP());
		Component[] b = {l2,p2};
		addToPanel(b, cpuHP);
		
		JLabel i1 = new JLabel(new ImageIcon(getCPUActiveMon().getFrontSprite()));
		Component[] c = {i1};
		addToPanel(c, cpuActiveDisplay);
		
		JLabel i2 = new JLabel(new ImageIcon(getActiveMon().getBackSprite()));
		Component[] d = {i2};
		addToPanel(d, playerActiveDisplay);
	}
	
	public static int calcDamage(Monster user, Monster target, Attack atk) {
		int userAtk = 0, targetDef = 1;
		if (atk.getMoveType() == "physical") {
			userAtk = user.getAtkStat();
			targetDef = target.getDefStat();
		} else if (atk.getMoveType() == "special") {
			userAtk = user.getspAtkStat();
			targetDef = target.getspDefStat();
		}
		double random = (Math.random() * (100 - 85 + 1) + 85);  
		double stab = getStabModifier(user, atk);
		double typeEffective = getTypeEffectiveModifier(target, atk);
		float damage = (((20*atk.getAtkPower()* (float) userAtk/ (float) targetDef) + 2) / 50);
		int intDamage = (int) (damage * (random/100) * stab * typeEffective);
		return intDamage;
	}
	
	public static void useMove(Monster user, Monster target, Attack atk) {
		int userAtk = 0, targetDef = 1;
		if (atk.getMoveType() == "physical") {
			userAtk = user.getAtkStat();
			targetDef = target.getDefStat();
		} else if (atk.getMoveType() == "special") {
			userAtk = user.getspAtkStat();
			targetDef = target.getspDefStat();
		} else {
			
		}
		
		if (atk.getAtkID() == 3) {
			userAtk = user.getDefStat();
		}
		//debug
		//System.out.println("user attack = " + userAtk);
		//System.out.println("target def = " + targetDef);
		//System.out.println("atk power = " + atk.getAtkPower());
		
		// set max roll
		// random = 100;
		// set min roll
		// random = 85;
		System.out.println(user.getMonName() + " using " + atk.getAtkName());
		float damage = (((20*atk.getAtkPower()* (float) userAtk/ (float) targetDef) + 2) / 50);
		System.out.println("true damage = " + damage);
		
		//calc modifiers
		double random = (Math.random() * (100 - 85 + 1) + 85);  
		double stab = getStabModifier(user, atk);
		double typeEffective = getTypeEffectiveModifier(target, atk);
		double crit = getCritModifier(atk);
		boolean attackHit = accuracyCheck(atk);
		if (atk.getFlinch()) {
			flinchCheck = flinchCheck();
		}
		
		if (attackHit) {
			//apply modifiers
			int intDamage = (int) (damage * (random/100) * stab * typeEffective * crit);
			System.out.println("stab modifier: " + stab);
			System.out.println("type effectiveness: " + typeEffective);
			System.out.println("crit: " + crit);
			System.out.println("random roll: " + (int) random);
			System.out.println("total multiplier: " + (stab * typeEffective * crit * (random / 100)));
			System.out.println("damage after modifiers = "+ intDamage);
			System.out.println();
			
			target.setHP(target.getHP() - intDamage);
			
			if (target.getHP() < 0) {
				target.setHP(0);
			} 
			addToPanel(new JLabel(user.getMonName() + " used " + atk.getAtkName() + "! (" + intDamage + " dmg)"), textPanel);	
			
			// announce crit
			if (crit > 1) {
				addToPanel(new JLabel("It was a critical hit!"), textPanel);
			} 
			
			//announce type effectiveness
			if (typeEffective > 1) {
				addToPanel(new JLabel("It's super effective!"), textPanel);
			} else if (typeEffective > 0 && typeEffective < 1) {
				addToPanel(new JLabel("It's not very effective..."), textPanel);
			} else if (typeEffective == 0) {
				addToPanel(new JLabel(target.getMonName() + " is immune!"), textPanel);
			}
		} else {
			//if attack missed
			flinchCheck = false;
			addToPanel(new JLabel(user.getMonName() + " used " + atk.getAtkName() + "!"), textPanel);
			addToPanel(new JLabel("The attack missed!"), textPanel);
		}
	}
	
	public static void chooseAction (Attack atk) {
		clearPanel(textPanel);
		Attack cpuAtk = new Attack();
		if (getActiveMon().getSpeedStat() > getCPUActiveMon().getSpeedStat()) {
			//player first
			useMove(getActiveMon(), getCPUActiveMon(), atk);
			if (getCPUActiveMon().getHP() == 0) {
				//cuts turn short if first attack fainted mon
				addToPanel(new JLabel("The opposing " + getCPUActiveMon().getMonName() + " fainted!"), textPanel);
				cpuActiveMon++;
			} else {
				//otherwise turn continues
				if (flinchCheck) {
					addToPanel(new JLabel("The opposing " + getCPUActiveMon().getMonName() + " flinched!"), textPanel);
				} else {
					cpuAtk = cpuMove();
					useMove(getCPUActiveMon(), getActiveMon(), cpuAtk); 
				}
			}
			
		} else if (getActiveMon().getSpeedStat() < getCPUActiveMon().getSpeedStat()) {
			//cpu first
			cpuAtk = cpuMove();
			useMove(getCPUActiveMon(), getActiveMon(), cpuAtk); 
			if (getActiveMon().getHP() == 0) {
				//cuts turn short if first attack fainted mon
				switchWindowForced();
			} else {
				//otherwise turn continues
				if (flinchCheck) {
					addToPanel(new JLabel("Your " + getActiveMon().getMonName() + " flinched!"), textPanel);
				} else {
					useMove(getActiveMon(), getCPUActiveMon(), atk);
				}
			}
			
			if (getCPUActiveMon().getHP() == 0) {
				addToPanel(new JLabel("The opposing " + getCPUActiveMon().getMonName() + " fainted!"), textPanel);
				cpuActiveMon++;
			}
		} else {
			useMove(getActiveMon(), getCPUActiveMon(), atk);
			if (getCPUActiveMon().getHP() == 0) {
				addToPanel(new JLabel("The opposing " + getCPUActiveMon().getMonName() + " fainted!"), textPanel);
				cpuActiveMon++;
			} else {
				cpuAtk = cpuMove();
				useMove(getCPUActiveMon(), getActiveMon(), cpuAtk); 
			}
		}
		
		flinchCheck = false;
		
		if (cpuActiveMon == 4) {
			clearPanel(BattleSim.textPanel);
			cpuActiveMon = 3;
			drawMonStats();	
			JLabel l1 = new JLabel("You win!");
			JLabel l2 = new JLabel("You gained $20.");
			JLabel l3 = new JLabel("");
			JLabel l4 = new JLabel("Run the game again to retry!");
			addToPanel(new Component[] {l1, l2, l3, l4}, textPanel);
			btnBack.setEnabled(false);
		} else {
			mainWindow();
			drawMonStats();	
		}
		
		if (getActiveMon().getHP() == 0 ) {
			Component[] c = {new JLabel("Your " + getActiveMon().getMonName() + " fainted!"), new JLabel("Choose another Mon.")};
			addToPanel(c, BattleSim.textPanel);
			switchWindowForced();
		} 
	}
	
	public static void chooseAction (int slot, boolean forced) {
		clearPanel(BattleSim.textPanel);
		Attack cpuAtk = cpuMove();
		setActiveMon(slot);
		Component[] c = {new JLabel("You sent out " + getActiveMon().getMonName() + "!")};
		addToPanel(c, BattleSim.textPanel);
		
		if (forced == false) {
			useMove(getCPUActiveMon(), getActiveMon(), cpuAtk); 
		}
		
		if (getActiveMon().getHP() == 0) {
			//cuts turn short if first attack fainted mon
			switchWindowForced();
		}
		
		mainWindow();
		drawMonStats();
	}
	
	public static void cpuTurn(int a) {
		int intAtk = (int) Math.floor(Math.random()*(4-1+1)+1);
		Attack atk = new Attack();
		switch (intAtk) {
		case 1:
			atk = getCPUActiveMon().getFirstAtk();
			break;
		case 2:
			atk = getCPUActiveMon().getSecondAtk();
			break;
		case 3:
			atk = getCPUActiveMon().getThirdAtk();
			break;
		case 4:
			atk = getCPUActiveMon().getFourthAtk();
			break;
		}
		useMove(getCPUActiveMon(), getActiveMon(), atk);
	}
	
	public static Attack cpuMove() {
		int dmg1 = calcDamage(getCPUActiveMon(), getActiveMon(), getCPUActiveMon().getFirstAtk());
		int dmg2 = calcDamage(getCPUActiveMon(), getActiveMon(), getCPUActiveMon().getSecondAtk());
		int dmg3 = calcDamage(getCPUActiveMon(), getActiveMon(), getCPUActiveMon().getThirdAtk());
		int dmg4 = calcDamage(getCPUActiveMon(), getActiveMon(), getCPUActiveMon().getFourthAtk());
		int highest = 0;
		int slotHighest = 1, slotSecond = 1;
		int[] dmgs = {dmg1, dmg2, dmg3, dmg4}; 
		//System.out.println(dmg1 + ", " + dmg2 + ", " + dmg3 + ", " + dmg4);
		
		for (int i = 0; i < dmgs.length; i++) {
			if (highest < dmgs[i]) {
				slotSecond = slotHighest; 
				highest = dmgs[i];
				slotHighest = i + 1; 
			}
		}
		
		int random = (int) (Math.random() * (99 - 0 + 1) + 0);
		int slot;
		if (random < 60) {
			slot = slotHighest;
		} else {
			slot = slotSecond;
		}
		
		Attack atk = new Attack();
		switch (slot) {
		case 1:
			atk = getCPUActiveMon().getFirstAtk();
			break;
		case 2:
			atk = getCPUActiveMon().getSecondAtk();
			break;
		case 3:
			atk = getCPUActiveMon().getThirdAtk();
			break;
		case 4:
			atk = getCPUActiveMon().getFourthAtk();
			break;
		}
		return atk;
	}

	public static double getTypeEffectiveModifier(Monster mon, Attack atk) {
		// check attack type against both types
		// every type will have own table of weaknesses
 		// resistances will halve modifier
		// weaknesses will double modifier
		// modifier starts at 1
		double mod = 1;
		int type1 = mon.getTypes()[0];
		int type2 = mon.getTypes()[1];
		int[] weak1 = data.getWeak(type1);
		int[] resist1 = data.getResist(type1);
		int[] immune1 = data.getImmune(type1);
		int[] weak2 = {1}, resist2 = {1}, immune2 = {1};
		boolean secondType = false;
		
		if (type2 != 0) {
			weak2 = data.getWeak(type2);
			resist2 = data.getResist(type2);
			immune2 = data.getImmune(type2);
			secondType = true;
		}
		
		if (immune1[0] != 0) {
			for (int i = 0; i < immune1.length; i++) {
				if (immune1[i] == atk.getAtkType()) {
					mod = mod*0;
				}
			}
		} else if (secondType == true && immune2[0] != 0) {
			for (int i = 0; i < immune2.length; i++) {
				if (immune2[i] == atk.getAtkType()) {
					mod = mod*0;
				}
			}
		}
		
		for (int i = 0; i < weak1.length; i++) {
			if (weak1[i] == atk.getAtkType()) {
				mod = mod*2;
			}
		}
		for (int i = 0; i < resist1.length; i++) {
			if (resist1[i] == atk.getAtkType()) {
				mod = mod/2;
			}
		}
		
		if (secondType) {
			for (int i = 0; i < weak2.length; i++) {
				if (weak2[i] == atk.getAtkType()) {
					mod = mod*2;
				}
			}
			for (int i = 0; i < resist2.length; i++) {
				if (resist2[i] == atk.getAtkType()) {
					mod = mod/2;
				}
			}
		}
		return mod;
	}
	
	public static double getStabModifier(Monster mon, Attack atk) {
		// check both types of monster to attack type
		// 0 is no type
		int atkType = atk.getAtkType();
		int[] typeArray = mon.getTypes();
		if (atkType == typeArray[0]) {
			return 1.25;
		} else if (atkType == typeArray[1]) {
			return 1.25;
		}
		return 1;
	}
	
	public static double getCritModifier(Attack atk) {
		// random number, get crit chance from attack object
		// if random number (0-99) is lower than crit chance a crit happens
		double crit = 1;
		int random = (int) Math.floor(Math.random()*(99-0+1)+0);
		if (atk.getCritChance() > random) {
			crit = 1.5;
		} else {
			crit = 1;
		}
		return crit;
	}
	
	public static boolean accuracyCheck(Attack atk) {
		int random = (int) Math.floor(Math.random()*(99-0+1)+0);
		if (atk.getAccuracy() > random) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean flinchCheck() {
		int random = (int) Math.floor(Math.random()*(99-0+1)+0);
		if (40 > random) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Monster getActiveMon() {
		return playerMons.get(playerActiveMon - 1);
	}
	
	public static void setActiveMon(int slot) {
		playerActiveMon = slot;
	}
	
	public static Monster getCPUActiveMon() {
		return cpuMons.get(cpuActiveMon - 1);	
	}
	
	public static void setCPUActiveMon(int slot) {
		playerActiveMon = slot;
	}
	
}
