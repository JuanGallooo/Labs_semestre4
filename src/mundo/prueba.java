package mundo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class prueba {
	public static void main(String[] args) throws IOException {
		BufferedReader lector= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter escritor= new BufferedWriter(new OutputStreamWriter(System.out));
		String linea= lector.readLine();
		Stack<String> pila= new Stack<String>();
		for (int i = 0; i < linea.length(); i++) {
			pila.push(linea.charAt(i)+ "");
		}
		for (int i = 0; i < linea.length(); i++) {
			String sacado= pila.pop();
			escritor.write(sacado);
		}
		lector.close();
		escritor.close();
	}
	
	public static int darKey(String elemento) {
		return 0;
	}
}
