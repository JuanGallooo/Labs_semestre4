package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelBotones extends JPanel implements ActionListener{
	public final static String AGREGAR = "Agregar";
	public final static String BUSCAR = "Buscar";

	private JButton btnAgregar;
	private JButton btnBuscar;
	private InterfazPrincipal p;
	public PanelBotones(InterfazPrincipal pri){
		setLayout(new BorderLayout());		
		p=pri;
		btnAgregar = new JButton("Agregar Carros");
		btnAgregar.addActionListener(this);
		btnAgregar.setActionCommand(AGREGAR);
		btnBuscar = new JButton("Buscar Carro");
		btnBuscar.addActionListener(this);
		btnBuscar.setActionCommand(BUSCAR);
		JPanel aux = new JPanel();
		aux.setLayout(new GridLayout(1,3));
		aux.add(btnAgregar);
		aux.add(btnBuscar);
		
		add(aux,BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		
		if(accion.equals(AGREGAR)){
			p.agregarCarros();
		}
		else if(accion.equals(BUSCAR)){
		String n =	JOptionPane.showInputDialog(this, "Ingrese la placa del carro a buscar");
		System.out.println(n);
		}
		
	}
	
}
