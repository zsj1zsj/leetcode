package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class CrunchifyNIOServer {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {

		// Selector: multiplexor of SelectableChannel objects
		Selector selector = Selector.open(); // selector is open here

		// ServerSocketChannel: selectable channel for stream-oriented listening
		// sockets
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

		// Binds the channel's socket to a local address and configures the
		// socket to listen for connections
		serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 1111));

		// Adjusts this channel's blocking mode.
		serverSocketChannel.configureBlocking(false);

		// register selector rwith serrverSocketChannel
		int ops = serverSocketChannel.validOps();
		serverSocketChannel.register(selector, ops);

		// Infinite loop..
		// Keep server running
		while (true) {

			log("i'm a server and i'm waiting for new connection and buffer select...");
			// Selects a set of keys whose corresponding channels are ready for
			// I/O operations
			selector.select();

			// token representing the registration of a SelectableChannel with a
			// Selector
			Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();

			while (selectionKeyIterator.hasNext()) {
				SelectionKey myKey = selectionKeyIterator.next();

				// Tests whether this key's channel is ready to accept a new
				// socket connection
				if (myKey.isAcceptable()) {
					SocketChannel socketChannel = serverSocketChannel.accept();

					// Adjusts this channel's blocking mode to false
					socketChannel.configureBlocking(false);

					// Operation-set bit for read operations
					socketChannel.register(selector, SelectionKey.OP_READ);
					log("Connection Accepted: " + socketChannel.getLocalAddress() + "\n");

					// Tests whether this key's channel is ready for reading
				} else if (myKey.isReadable()) {

					SocketChannel crunchifyClient = (SocketChannel) myKey.channel();
					ByteBuffer crunchifyBuffer = ByteBuffer.allocate(256);
					crunchifyClient.read(crunchifyBuffer);
					String result = new String(crunchifyBuffer.array()).trim();

					log("Message received: " + result);

					if (result.equals("Crunchify")) {
						crunchifyClient.close();
						log("\nIt's time to close connection as we got last company name 'Crunchify'");
						log("\nServer will keep running. Try running client again to establish new connection");
					}
				}
				selectionKeyIterator.remove();
			}
		}
	}

	private static void log(String str) {
		System.out.println(str);
	}
}
