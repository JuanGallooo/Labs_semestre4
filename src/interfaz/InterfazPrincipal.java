package interfaz;

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.*;

import mundo.Principal;

public class InterfazPrincipal extends JFrame {

	private Principal mundo;
	private PanelBotones panelBotones;
	private PanelInformacion  panelInformacion;
	private PanelResultado panelResultado;
	
	public InterfazPrincipal (){
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(440,400));
		panelBotones = new PanelBotones(this);
		panelInformacion = new PanelInformacion(this);
		panelResultado = new PanelResultado();
		mundo = new Principal();
		
		
		add(panelBotones,BorderLayout.SOUTH);
		add(panelInformacion,BorderLayout.CENTER);
		add(panelResultado,BorderLayout.EAST);
		pack();
	}
	
	public void agregarCarros(){
		String n = panelInformacion.darTexto();
		try {
			mundo.datosLector(n);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Existe un error al cargar los datos", "Error de Carga", JOptionPane.ERROR_MESSAGE, null);
		}
		panelResultado.refrescarPanel(mundo.getMensaje());
	}
	
	
	
	public static void main(String[] args) {
		InterfazPrincipal nueva = new InterfazPrincipal();
		nueva.setVisible(true);
	}
	
	
}
