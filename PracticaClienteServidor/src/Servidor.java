import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	/**
	 * Indica el puerto libre en el cual se va realizar el servicio.
	 */
	public static final int PORT = 8000;
	/**
	 * Indica el socket del server
	 */
	private static  ServerSocket serverSocket;
	/**
	 * indica el socket 
	 */
	private static Socket socket;
	/**
	 *Indica el metodo main  
	 */
	public static void main(String[] args) {
		
		DataInputStream in;
		DataOutputStream out;
		
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("::Servidor escuchando a los posibles clientes::");
			while(true) {
				socket = serverSocket.accept();
				System.out.println("El cliente se ha conectado!");
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
				String mensajeObtenidoCliente = in.readUTF();
				System.out.println("El mensaje enviado por el cliente fue : " + mensajeObtenidoCliente);
				String respuestaServer = metodoEncriptar(mensajeObtenidoCliente);
				out.writeUTF(respuestaServer);
				socket.close();
				System.out.println("::El cliente fue desconectado del server::");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Indica el metodoEncriptar el cual funciona con un metodo encriptamiento de cesar.
	 * @param mensajeObtenidoCliente la palabra que desea encriptar.
	 * @return la palabra encriptada sumandole dos unidades al indicador ascii.
	 */
	private static String metodoEncriptar(String mensajeObtenidoCliente) {
		String mensaje= "";
		
		for (int i = 0; i < mensajeObtenidoCliente.length(); i++) {
			int codigo= mensajeObtenidoCliente.codePointAt(i);
			mensaje+= (char) (codigo+2);
		}
		return mensaje;
	}
}
