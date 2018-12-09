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

public class Main {
	public static void main(String[] args) throws IOException {

		ServerSocketChannel ssc = ServerSocketChannel.open();
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		ssc.bind(new InetSocketAddress("127.0.0.1", 54321));

		Selector selector = Selector.open();

		ssc.configureBlocking(false);

		while (true) {

			int readyChannels = selector.select();

			if (readyChannels == 0)
				continue;

			Set<SelectionKey> selectedKeys = selector.selectedKeys();

			Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

			while (keyIterator.hasNext()) {

				SelectionKey key = keyIterator.next();

				if (key.isAcceptable()) {
					// a connection was accepted by a ServerSocketChannel.

				} else if (key.isConnectable()) {
					// a connection was established with a remote server.
					System.out.println("connectable");

				} else if (key.isReadable()) {
					// a channel is ready for reading
					System.out.println("readable");
					SocketChannel sc = (SocketChannel)key.channel();
					ByteBuffer buffer2 = ByteBuffer.allocate(1024);
					buffer2.flip();
					System.out.println(sc.read(buffer2));

				} else if (key.isWritable()) {
					// a channel is ready for writing
				}

				keyIterator.remove();
			}
		}
	}
}
