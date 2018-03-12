package interfaz;

import java.awt.BorderLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class PanelBanner extends JPanel{

	private JLabel banner;
	
	public PanelBanner(String n){
		setLayout(new BorderLayout());
		ImageIcon imagen = new ImageIcon(n);
		banner = new JLabel();
		banner.setIcon(imagen);
		
		add(banner, BorderLayout.CENTER);
	}
}
