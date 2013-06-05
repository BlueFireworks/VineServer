package vine.packet.represent;

import vine.packet.PacketRepresentation;

public final class HandshakeResponsePacket implements PacketRepresentation {

	public static enum HandshakeResponse {
		SUCCESS, FAILURE;
	}

	private final int magic;
	private final HandshakeResponse handshakeResponse;

	public HandshakeResponsePacket(int magic,
			HandshakeResponse handshakeResponse) {
		this.magic = magic;
		this.handshakeResponse = handshakeResponse;
	}

	public int getMagic() {
		return magic;
	}

	public HandshakeResponse getHandshakeResponse() {
		return handshakeResponse;
	}

}