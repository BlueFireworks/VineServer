package vine.packet.represent;

import vine.packet.PacketRepresentation;

public final class HandshakePacket implements PacketRepresentation {

	private final int magic;

	public HandshakePacket(int magic) {
		this.magic = magic;
	}

	public int getMagic() {
		return magic;
	}

}