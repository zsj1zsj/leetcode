package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

public class CrunchifyNIOClient {

	public static void main(String[] args) throws IOException, InterruptedException {

		SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 1111));

		log("Connecting to Server on port 1111...");

		ArrayList<String> companyDetails = new ArrayList<String>();

		// create a ArrayList with companyName list
		companyDetails.add("Facebook");
		companyDetails.add("Twitter");
		companyDetails.add("IBM");
		companyDetails.add("Google");
		companyDetails.add("Crunchify");

		for (String companyName : companyDetails) {

			byte[] message = new String(companyName).getBytes();
			ByteBuffer buffer = ByteBuffer.wrap(message);
			socketChannel.write(buffer);

			log("sending: " + companyName);
			buffer.clear();

			// wait for 2 seconds before sending next message
			Thread.sleep(2000);
		}
		socketChannel.close();
	}

	private static void log(String str) {
		System.out.println(str);
	}
}
