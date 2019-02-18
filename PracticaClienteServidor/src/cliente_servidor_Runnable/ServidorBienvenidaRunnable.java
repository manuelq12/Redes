package cliente_servidor_Runnable;
import java.net.*;
import java.io.*;

public class ServidorBienvenidaRunnable {

	public static void main(String[] args) {
		try {
	      ServerSocket servidor = new ServerSocket(8030);
	      while(true) {
	    	  Socket c = servidor.accept();
	    	  Thread hilo = new Thread(new HiloServidorBienvenidaRunnable(c));
	           hilo.start();
	      }
		}
		catch(IOException e) {
			
		}
	}
}
