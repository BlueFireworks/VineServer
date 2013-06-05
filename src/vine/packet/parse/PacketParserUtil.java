package vine.packet.parse;

import java.nio.ByteBuffer;

public final class PacketParserUtil {

	public static String getString(ByteBuffer buffer) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < buffer.get(); i++)
			builder.append(buffer.get());
		return builder.toString();
	}

}