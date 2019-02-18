import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Cliente {
	/**
	 * LOCAL_HOST Indica el numero de enrutamiento, al host al cual se tiene destinado enrutar.
	 */
	public static final String LOCAL_HOST = "172.30.183.143";
	/**
	 * PORT indica el numero de puerto libre donde se realizará el servicio.
	 */
	public static final int PORT = 8000;
	/**
	 * Indica el socket requerido para la conexion.
	 */
	private static Socket socket;
	/**
	 * Metodo main del cliente.
	 */
	public static void main(String[] args) {
		
		DataInputStream in;
		DataOutputStream out;

		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			System.out.println("::Cliente disponible para ser atendido:: \n Ingrese la palabra que desea encriptar"
					+ "");
			socket = new Socket(LOCAL_HOST, PORT);
			String mensaje = br.readLine();
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(mensaje);
			String mensajeDelServidor = in.readUTF();
			bw.write("La palabra encriptada es : " + mensajeDelServidor);
			bw.flush();
			bw.close();
			br.close();
			socket.close();
			in.close();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
