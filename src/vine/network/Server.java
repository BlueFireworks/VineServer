package vine.network;

import java.util.Set;

import vine.packet.PacketService;

public interface Server {

	int getPort();

	Set<Client> getClients();

	boolean start();

	boolean stop();

	PacketService getPacketService();

	Server configurePacketService(PacketService packetService);

}