package com.lucasallegri;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandCall {
	
	public static void handle(Shhhhhhh bot, MessageReceivedEvent evt) {
		for(Member member : bot.crew) {
			if(bot.dead.contains(member)) {
				member.mute(true);
				member.deafen(false);
				continue;
			}
			member.mute(false);
			member.deafen(false);
		}
	}
}
