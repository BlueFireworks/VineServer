package vine.packet.represent;

import vine.Address;
import vine.packet.PacketRepresentation;

public final class AuthenticationPacket implements PacketRepresentation {

	private final Address address;
	private final String key;

	public AuthenticationPacket(Address address, String key) {
		this.address = address;
		this.key = key;
	}

	public Address getAddress() {
		return address;
	}

	public String getKey() {
		return key;
	}

}