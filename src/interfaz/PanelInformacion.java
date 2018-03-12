package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ScrollPane;

import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelInformacion extends JPanel{
	private JTextArea area;
	
	public PanelInformacion(InterfazPrincipal p){
		setPreferredSize(new Dimension(200,400));
		setLayout(new BorderLayout());
		setBorder(new TitledBorder("Informacion"));
		area = new JTextArea();
		ScrollPane scroll = new ScrollPane();
		scroll.add(area);
		add(scroll,BorderLayout.CENTER);
	}
	
	public void refrescarArea(String n){
		area.setText(n);
	}
	
	public String darTexto(){
		return area.getText();
	}
	public void areaVacia(){
		refrescarArea("");
	}

}
