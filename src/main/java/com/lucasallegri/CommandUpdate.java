package com.lucasallegri;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandUpdate {
	
	public static void handle(Shhhhhhh bot, MessageReceivedEvent evt) {
		bot.voiceChannelSnowflake = evt.getMember().getVoiceState().getChannel().getId();
	}
}
