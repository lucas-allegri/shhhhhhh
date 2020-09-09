package com.lucasallegri;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandCall {
	
	public static void handle(Shhhhhhh bot, MessageReceivedEvent evt) {
		for(Member member : bot.crew) {
			if(bot.dead.contains(member)) {
				member.mute(true).queue();
				member.deafen(false).queue();
				continue;
			}
			member.mute(false).queue();
			member.deafen(false).queue();
		}
	}
}
