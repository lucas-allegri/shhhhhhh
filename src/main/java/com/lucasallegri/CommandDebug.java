package com.lucasallegri;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandDebug {

	public static void handle(Shhhhhhh bot, MessageReceivedEvent evt) {
		evt.getChannel().sendMessage("```" + bot.toString() + "```");
	}
}
