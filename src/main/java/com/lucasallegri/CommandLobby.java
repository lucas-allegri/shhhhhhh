package com.lucasallegri;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandLobby {
	
	public static void handle(Shhhhhhh bot, MessageReceivedEvent evt) {
		for(Member member : bot.crew) {
			member.mute(false);
			member.deafen(false);
			bot.dead.clear();
		}
	}
}
