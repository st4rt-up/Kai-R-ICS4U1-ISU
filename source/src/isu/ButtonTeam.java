package isu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class ButtonTeam extends JButton implements Button{
	int team;
	
	public ButtonTeam(int team) {
		this.team = team;
		this.setText("Team " + team);
		this.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){  
	        	buttonPressed();
	         }  
	     });
	}

	public void buttonPressed() {
		SwingUtilities.getWindowAncestor(this).dispose();
		BattleSim.pickTeam(team, BattleSim.playerMons);
		
		int cpuTeam = (int) Math.floor(Math.random()*(2-1+1)+1);
		cpuTeam = cpuTeam + team;
		if (cpuTeam == 5) {
			cpuTeam = 2;
		} else if (cpuTeam == 4){
			cpuTeam = 1;
		}
		System.out.println("cpu team: " + cpuTeam);
		BattleSim.pickTeam(cpuTeam, BattleSim.cpuMons);
		Collections.shuffle(BattleSim.cpuMons);
		BattleSim.initWindow();
	}
	

}
