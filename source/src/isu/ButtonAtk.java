package isu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonAtk extends JButton implements Button {
	Attack atk;
	public ButtonAtk(Attack atk) {
		//init
		this.setText(atk.getAtkName());
		this.setToolTipText(atk.desc + " (Power " + atk.power + ")");
		this.atk = atk;
		this.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){  
	        	buttonPressed();
	         }  
	     });
	}

	public void buttonPressed() {	
		BattleSim.chooseAction(atk);
	}
}
