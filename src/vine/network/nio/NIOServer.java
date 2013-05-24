package vine.network.nio;

import static vine.network.Client.SUGGESTED_CLIENT_MAXIMUM;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import vine.network.CycledServer;

public final class NIOServer extends CycledServer {

	private final int cycleAccepts;
	private final Map<SelectionKey, NIOClient> clientMap;

	private Selector selector;
	private ServerSocketChannel channel;

	public NIOServer(int port, int cycleLength, int cycleAccepts,
			Map<SelectionKey, NIOClient> clientMap) {
		super(port, cycleLength);

		this.cycleAccepts = cycleAccepts;
		this.clientMap = clientMap;
	}

	public NIOServer(int port, int cycleLength, int cycleAccepts) {
		this(port, cycleLength, cycleAccepts,
				new HashMap<SelectionKey, NIOClient>(SUGGESTED_CLIENT_MAXIMUM));
	}

	public NIOServer(int port, int cycleLength) {
		this(port, cycleLength, SUGGESTED_CLIENT_MAXIMUM);
	}

	private synchronized Map<SelectionKey, NIOClient> getClientMap() {
		return clientMap;
	}

	@Override
	public boolean start() {
		if (isRunning()) {
			throw new IllegalArgumentException("The server is already running!");
		}

		try {
			selector = Selector.open();
			channel = ServerSocketChannel.open();

			channel.configureBlocking(false);
			channel.socket().bind(new InetSocketAddress(getPort()));
			channel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return super.start();
	}

	@Override
	public boolean stop() {
		if (!isRunning()) {
			throw new IllegalArgumentException(
					"The server has already been stopped!");
		}

		try {
			channel.close();
			selector.close();
		} catch (IOException e) {
			return false;
		}

		return super.stop();
	}

	@Override
	public boolean isRunning() {
		return channel != null && selector != null && channel.isOpen()
				&& selector.isOpen();
	}

	@Override
	protected void cycle() throws Throwable {
		selector.selectNow();

		Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
		while (keys.hasNext()) {
			SelectionKey key = keys.next();
			if (key.isAcceptable())
				accept(key);
			if (key.isReadable())
				read(key);
			keys.remove();
		}
	}

	private void accept(SelectionKey key) throws IOException {
		for (int i = 0; i < cycleAccepts; i++) {
			SocketChannel socket = channel.accept();
			if (socket == null)
				break;

			socket.configureBlocking(false);
			SelectionKey clientKey = socket.register(selector,
					SelectionKey.OP_READ);
			getClientMap().put(clientKey, new NIOClient(this, clientKey));
		}
	}

	private void read(SelectionKey key) throws IOException {
		@SuppressWarnings("unused")
		NIOClient client = getClientMap().get(key);
	}

}