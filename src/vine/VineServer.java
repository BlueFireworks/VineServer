package vine;

import vine.network.Server;
import vine.network.nio.NIOServer;
import vine.packet.PacketService;
import vine.packet.build.HandshakeResponsePacketBuilder;
import vine.packet.parse.AuthenticationPacketParser;
import vine.packet.parse.HandshakePacketParser;
import vine.packet.reflective.ReflectivePacketService;

public final class VineServer {

	private static final int DEFAULT_PORT = 29833;
	private static final int DEFAULT_CYCLE_RATE = 1000;

	public static void main(String[] args) {
		System.out.println("__      ___            ");
		System.out.println("\\ \\    / (_)           ");
		System.out.println(" \\ \\  / / _ _ __   ___ ");
		System.out.println("  \\ \\/ / | | '_ \\ / _ \\");
		System.out.println("   \\  /  | | | | |  __/");
		System.out.println("    \\/   |_|_| |_|\\___|");

		int port = DEFAULT_PORT, cycleRate = DEFAULT_CYCLE_RATE;
		if (args.length >= 1)
			port = Integer.parseInt(args[0]);
		if (args.length == 2)
			cycleRate = Integer.parseInt(args[1]);

		PacketService packetService = new ReflectivePacketService();
		packetService.registerBuilder(new HandshakeResponsePacketBuilder());
		packetService.registerParser(new HandshakePacketParser());
		packetService.registerParser(new AuthenticationPacketParser());

		Server server = new NIOServer(port, cycleRate);
		if (server.configurePacketService(packetService).start())
			System.out.println("Server has started on port: " + port);
	}

}