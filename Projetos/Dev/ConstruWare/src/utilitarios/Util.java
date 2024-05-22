package utilitarios;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Util {
	public void LimpaTela(JPanel container) {
		Component conponents[] = container.getComponents();
		for(Component component : conponents) {
			if(component instanceof JTextField) {
				((JTextField)component).setText(null);
			}
		}
	}				
}
