package isu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ButtonSwitch extends JButton implements Button {
	Monster mon;
	int slot;
	boolean forced;
	public ButtonSwitch(Monster mon, int slot, boolean forced) {
		this.mon = mon;
		this.slot = slot;
		this.forced = forced;
		this.setText(mon.getMonName());
		this.setToolTipText("Switch to " + mon.name + "!");
		
		if (mon.health > 0 && (BattleSim.getActiveMon() != mon)) {
			this.addActionListener(new ActionListener(){  
		        public void actionPerformed(ActionEvent e){  
		        	buttonPressed();
		         }  
		     });
		} else if (mon.health <= 0 && (BattleSim.getActiveMon() != mon)) {
			this.setText(mon.getMonName() + " (FAINTED)");
			this.setEnabled(false);
		} else if (BattleSim.getActiveMon() == mon){
			this.setText(mon.getMonName() + " (ACTIVE)");
			this.setEnabled(false);
		}
		
		
	}
	
	public void buttonPressed() {
		BattleSim.chooseAction(slot, forced);
	}

}
