package net.omniblock.core.protocol.manager.network.reader.packet;

import net.omniblock.core.protocol.manager.network.handler.cord.ProxyServer;
import net.omniblock.core.protocol.manager.network.handler.modifier.PacketModifier;
import net.omniblock.core.protocol.manager.network.object.packet.MessagePacket;
import net.omniblock.core.protocol.manager.network.reader.type.MessageType;
import net.omniblock.core.protocol.manager.network.reader.type.ReaderStatus;
import net.omniblock.lib.json.JSONObject;

public class ServerReloadInfoPacket extends MessagePacket {

	public ServerReloadInfoPacket(MessageType type) {
		super(type);
	}
	
	public ReaderStatus read(JSONObject object) throws NullPointerException, ClassCastException {
		
		JSONObject obj = object.getJSONObject(MessageType.SERVER_RELOAD_INFO.getKey());
		
		PacketModifier modifier = new PacketModifier()
				.addString(MessageType.SERVER_RELOAD_INFO.getKey())
				.addString(obj.getString("servername"))
				.addInteger(obj.getInt("serversocket"));
		
		ProxyServer.getSocketAdapter().sendData(ProxyServer.getPort(), modifier);
		return ReaderStatus.SUCESS;
		
	}

}
