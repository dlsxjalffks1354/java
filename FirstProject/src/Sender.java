import java.io.*;
import java.net.*;

public class Sender extends Thread {

	Socket socket;
	PrintWriter out = null;
	String request;

	public Sender(Socket socket, String request) {
		this.socket = socket;
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			this.request = request;
		} catch (IOException e) {
			System.out.println("예외S3:" + e);
		}

	}

	@Override
	public void run() {
		try {
			out.println(request);
		} catch (Exception e) {
			System.out.println("예외S2:" + e);
		}

	}

}
