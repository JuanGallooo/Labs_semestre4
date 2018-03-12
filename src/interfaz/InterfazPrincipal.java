package interfaz;

import java.awt.BorderLayout;

import javax.swing.*;

import mundo.Carro;
import mundo.Principal;

@SuppressWarnings("serial")
public class InterfazPrincipal extends JFrame {

	private Principal mundo;
	private PanelBotones panelBotones;
	private PanelInformacion  panelInformacion;
	private PanelResultado panelResultado;
	private PanelBanner panelBanner;
	
	public InterfazPrincipal (){
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panelBanner = new PanelBanner("./docs/banner/parqueadero.jpg");
		panelBotones = new PanelBotones(this);
		panelInformacion = new PanelInformacion(this);
		panelResultado = new PanelResultado();
		
		add(panelBanner,BorderLayout.NORTH);
		add(panelBotones,BorderLayout.SOUTH);
		add(panelInformacion,BorderLayout.WEST);
		add(panelResultado,BorderLayout.CENTER);
		
		
		pack();
	}
	
	public void agregarCarros(){
		mundo = new Principal();
		String n = panelInformacion.darTexto();
		try {
			mundo.datosLector(n);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Existe un error al cargar los datos", "Error de Carga", JOptionPane.ERROR_MESSAGE, null);
		}
		panelResultado.refrescarPanel(mundo.getMensaje());
	}
	
	public void buscarCarros(String placa, String indice){
		limpiarAreas();
		if(mundo.getCasos() == null || mundo == null){
			JOptionPane.showMessageDialog(this, "Debe cargar un caso primero para realizar la busqueda", "Error", JOptionPane.ERROR_MESSAGE, null);
		}
		else{
			try {
			Carro buscado = mundo.buscarCarro(placa, indice);
			if(buscado == null){
				panelResultado.refrescarPanel("El carro no se encuentra en el parqueadero de este caso");
			}
			else{
				panelResultado.refrescarPanel(buscado.toString());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error al buscar el carro", JOptionPane.ERROR_MESSAGE,null);
		}			
	 }
		
	}
	public void limpiarAreas(){
		panelResultado.areaVacia();
		panelInformacion.areaVacia();
	}
	
	
	public static void main(String[] args) {
		InterfazPrincipal nueva = new InterfazPrincipal();
		nueva.setVisible(true);
	}
	
	
}
