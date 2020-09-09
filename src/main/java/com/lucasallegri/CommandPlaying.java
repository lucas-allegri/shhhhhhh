package com.lucasallegri;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandPlaying {
	
	public static void handle(Shhhhhhh bot, MessageReceivedEvent evt) {
		for(Member member : bot.crew) {
			member.mute(true);
			member.deafen(true);
		}
	}
}
