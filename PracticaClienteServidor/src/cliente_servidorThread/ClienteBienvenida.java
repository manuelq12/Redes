package cliente_servidorThread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClienteBienvenida {

	public static void main(String[] args) {
		// ------------------ Cliente Bienvenida
		Socket Cliente;
		BufferedReader lectorC;
		PrintWriter escritorC;
		String nombre, respuesta, host;
		int puerto;

		try {
			Cliente = new Socket("127.0.0.1", 8030);
			lectorC = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));
			escritorC = new PrintWriter(Cliente.getOutputStream(), true);

			host = Cliente.getLocalAddress().getHostName();
			puerto = Cliente.getLocalPort();
			// nombre= Lecturas.leeCadena("Digite su nombre");
			System.out.println("Digite su nombre");
			nombre = lectorC.readLine();
			System.out.println(puerto);

			// se envian los datos al servidor
			escritorC.println(nombre);
			escritorC.println(host + "(Puerto : " + puerto + ")");
			// se escribe la respuesta del servidor y se muestra por consola
			respuesta = lectorC.readLine();
			System.out.println(respuesta);

			// se cierran los flujos y finalmente el socket
			lectorC.close();
			escritorC.close();
			Cliente.close();
		} catch (Exception e) {

		}

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
