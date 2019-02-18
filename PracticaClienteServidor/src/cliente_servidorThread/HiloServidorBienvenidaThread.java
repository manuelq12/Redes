package cliente_servidorThread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidorBienvenidaThread extends Thread{
	Socket Cliente;
	BufferedReader lectorHS;
	PrintWriter escritorHS;
	
	public HiloServidorBienvenidaThread(Socket solicitud) {
		super();
		Cliente= solicitud;
	}
	public void run() {
		try {
			// se crean los flujos asociados 
			lectorHS= new BufferedReader(new InputStreamReader(Cliente.getInputStream()));
			escritorHS= new PrintWriter(Cliente.getOutputStream(),true);
			
			// Se recibe el nombre y host del usuario
			String nombre= lectorHS.readLine();
			String host= lectorHS.readLine();
			
			// Se crea el mensaje de respuesta y se envia al cliente
			String mensaje= "Hola" + nombre + "en"+ host + ",bienvenida(a)!!";
			escritorHS.println(mensaje);
			
			// Se Cierran los flujos
			lectorHS.close();
			escritorHS.close();
			Cliente.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
