package visao;
import java.awt.Label;

import javax.swing.JDialog;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class TelaSobre extends JDialog {
	
	public TelaSobre(){
		this.setTitle("Sobre!");
		this.setSize(415, 160);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		getContentPane().add(new Label("   Programa desenvolvido por:"));
		
		Label label = new Label("   Rodrigo de Paulo Sampaio Barros e Gleydson Hudson.");
		getContentPane().add(label);
		getContentPane().add(new Label("   Vers\u00E3o 1.0"));
		getContentPane().add(new Label("   Telefone: (88) 9660-0304 / (85) 8679-2353 / (85) 8519-5711 (Hudson)"));
		
	}

}
