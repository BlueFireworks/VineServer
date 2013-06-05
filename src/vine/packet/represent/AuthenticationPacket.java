package vine.packet.represent;

import vine.packet.PacketRepresentation;

public final class AuthenticationPacket implements PacketRepresentation {

	private final String address;
	private final String key;

	public AuthenticationPacket(String address, String key) {
		this.address = address;
		this.key = key;
	}

	public String getAddress() {
		return address;
	}

	public String getKey() {
		return key;
	}

}