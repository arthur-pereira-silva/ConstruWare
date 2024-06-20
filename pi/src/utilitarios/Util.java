package utilitarios;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class Util.
 */
public class Util {
	
	/**
	 * Limpa tela.
	 *
	 * @param container the container
	 */
	public void LimpaTela(JPanel container) {
		Component conponents[] = container.getComponents();
		for(Component component : conponents) {
			if(component instanceof JTextField) {
				((JTextField)component).setText(null);
			}
		}
	}				
}
