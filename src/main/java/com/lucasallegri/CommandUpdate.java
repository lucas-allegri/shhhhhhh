package com.lucasallegri;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandUpdate {
	
	public static void handle(Shhhhhhh bot, MessageReceivedEvent evt) {
		bot.voiceChannel = evt.getMember().getVoiceState().getChannel();
		if(bot.voiceChannel != null) {
			bot.crew.clear();
			for(Member member : bot.voiceChannel.getMembers()) {
				bot.crew.add(member);
			}
		}
	}
}
