package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ScrollPane;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelResultado extends JPanel{
	
	private JTextArea area;
	
	
	public PanelResultado(){
		setLayout(new BorderLayout());
		setBorder(new TitledBorder("Resultado"));
		setPreferredSize(new Dimension(220,150));
		area = new JTextArea();
		ScrollPane scroll = new ScrollPane();
		scroll.add(area);
		
		add(scroll,BorderLayout.CENTER);
		
	}
	
	
	public void refrescarPanel(String n){
		area.setText(n);
		repaint();
	}
	
	public void areaVacia(){
		refrescarPanel("");
	}

}
