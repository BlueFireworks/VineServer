package vine.packet.build;

import java.nio.ByteBuffer;

import vine.packet.Packet;
import vine.packet.PacketBuilder;
import vine.packet.PacketRepresentation;
import vine.packet.reflective.BuildsPacket;
import vine.packet.represent.HandshakeResponsePacket;

@BuildsPacket(HandshakeResponsePacket.class)
public final class HandshakeResponsePacketBuilder implements PacketBuilder {

	@Override
	public Packet build(PacketRepresentation packetRep) {
		HandshakeResponsePacket packet = (HandshakeResponsePacket) packetRep;

		ByteBuffer buffer = ByteBuffer.allocate(2);
		buffer.put((byte) packet.getHandshakeResponse().ordinal());
		buffer.put((byte) packet.getMagic());

		return new Packet(0, buffer.array());
	}

}