package mundo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static Principal principal;
	
	public static void main(String[] args) throws IOException {
		principal= new Principal();
		BufferedReader lector= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter escritor= new BufferedWriter(new OutputStreamWriter(System.out));
		String mensaje= lector.readLine();
		String datos="";
		while (!mensaje.equals("")|| !mensaje.isEmpty()) {
			datos+= mensaje+"\n";
			mensaje= lector.readLine();
		}
		try {
			principal.datosLector(datos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		escritor.write(principal.getMensaje());
		escritor.close();
		lector.close();
	}

}
