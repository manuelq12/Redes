package cliente_servidorThread;

import java.net.*;
import java.io.*;

public class ServidorBienvenidaThread {

  public static void main(String[] args) {
		// ------------------ Heredar de thread
		try {

			ServerSocket servidor = new ServerSocket(8030);
			while (true) {
				Socket c = servidor.accept();
				HiloServidorBienvenidaThread hilo = new HiloServidorBienvenidaThread(c);
				hilo.start();
			}
		} catch (Exception e) {

		}
}
}
