package vine.network.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

import vine.network.AbstractClient;
import vine.network.Server;
import vine.packet.Packet;

final class NIOClient extends AbstractClient {

	private final SelectionKey key;
	private final SocketChannel channel;

	NIOClient(Server server, SelectionKey key, SocketChannel channel) {
		super(server);
		this.key = key;
		this.channel = channel;
	}

	NIOClient(Server server, SelectionKey key) {
		this(server, key, (SocketChannel) key.channel());
	}

	synchronized SelectionKey getKey() {
		return key;
	}

	synchronized SocketChannel getChannel() {
		return channel;
	}

	@Override
	public void write(Packet packet) {
	}

	@Override
	public boolean disconnect() {
		try {
			getChannel().close();
			getKey().cancel();
		} catch (IOException e) {
			return false;
		}

		return true;
	}

}