package vine.network;

import static vine.network.Client.SUGGESTED_CLIENT_MAXIMUM;

import java.util.HashSet;
import java.util.Set;

import vine.packet.PacketService;

public abstract class AbstractServer implements Server, Runnable {

	private final int port;
	private PacketService packetService;
	private final Set<Client> clients;

	protected AbstractServer(int port, Set<Client> clients) {
		this.port = port;
		this.clients = clients;
	}

	protected AbstractServer(int port) {
		this(port, new HashSet<Client>(SUGGESTED_CLIENT_MAXIMUM));
	}

	@Override
	public boolean start() {
		new Thread(this).start();
		return true;
	}

	@Override
	public boolean stop() {
		return true;
	}

	@Override
	public final int getPort() {
		return port;
	}

	@Override
	public final synchronized Set<Client> getClients() {
		return clients;
	}

	@Override
	public final synchronized PacketService getPacketService() {
		return packetService;
	}

	@Override
	public final synchronized Server configurePacketService(
			PacketService packetService) {
		this.packetService = packetService;
		return this;
	}

}