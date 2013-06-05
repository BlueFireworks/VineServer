package vine.packet.parse;

import vine.packet.Packet;
import vine.packet.PacketParser;
import vine.packet.PacketRepresentation;
import vine.packet.reflective.ParsesPacket;
import vine.packet.represent.HandshakePacket;

@ParsesPacket(0)
public final class HandshakePacketParser implements PacketParser {

	@Override
	public PacketRepresentation parse(Packet packet) {
		return new HandshakePacket(packet.toBuffer().get());
	}

}