package cliente_servidor_Runnable;

import java.net.*;
import java.io.*;

public class HiloServidorBienvenidaRunnable implements Runnable {

	private Socket cliente;
	private BufferedReader lectorHS;
	private PrintWriter escritorHS;
	
	
	public HiloServidorBienvenidaRunnable(Socket solicitud) {
		// TODO Auto-generated constructor stub
		cliente = solicitud;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
     
		try {
			lectorHS = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		    escritorHS = new PrintWriter(cliente.getOutputStream(),true);
		    String nombre = lectorHS.readLine();
		    String host = lectorHS.readLine();
		    
		    String mensaje = "Hola " + nombre + " en " + host + " bienvenida(a)!!";
		    escritorHS.println(mensaje);
		    
		    lectorHS.close();
		    escritorHS.close();
		    cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
