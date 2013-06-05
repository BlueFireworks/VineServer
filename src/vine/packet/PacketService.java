package vine.packet;

public interface PacketService extends PacketParser, PacketBuilder {

	static final int SUGGESTED_MAXIMUM_PACKETS = 0x100;

	void registerParser(PacketParser parser);

	void registerBuilder(PacketBuilder builder);

}