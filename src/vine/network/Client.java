package vine.network;

import java.util.UUID;

import vine.packet.Packet;
import vine.packet.PacketRepresentation;

public interface Client {

	static final int SUGGESTED_CLIENT_MAXIMUM = 100;

	Server getServer();

	UUID getUUID();

	void write(Packet packet);

	void write(PacketRepresentation packetRep);

	boolean disconnect();

}