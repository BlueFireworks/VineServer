package vine.packet.parse;

import static vine.packet.parse.PacketParserUtil.getString;

import java.nio.ByteBuffer;

import vine.packet.Packet;
import vine.packet.PacketParser;
import vine.packet.PacketRepresentation;
import vine.packet.reflective.ParsesPacket;
import vine.packet.represent.AuthenticationPacket;

@ParsesPacket(1)
public final class AuthenticationPacketParser implements PacketParser {

	@Override
	public PacketRepresentation parse(Packet packet) {
		ByteBuffer buffer = packet.toBuffer();

		String username = getString(buffer);
		String password = getString(buffer);

		return new AuthenticationPacket(username, password);
	}

}