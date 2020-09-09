package com.lucasallegri;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandDead {
	
	public static void handle(Shhhhhhh bot, MessageReceivedEvent evt) {
		
		/* 	
		* There's no real argument handling here, we'll simply take the mentions found on
		* the message and add them members to the dead ArrayList.
		*/
		for(Member member : evt.getMessage().getMentionedMembers()) {
			bot.dead.add(member);
		}
	}

}
