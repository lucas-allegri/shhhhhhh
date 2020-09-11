package com.lucasallegri;

import java.util.List;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandDead {
	
	public static void handle(Shhhhhhh bot, MessageReceivedEvent evt) {
		
		List<Member> mentioned = evt.getMessage().getMentionedMembers();
		
		if(mentioned.size() < 0) {
			evt.getChannel().sendMessage("No members mentioned.").queue();
		}
		
		/* 	
		* There's no real argument handling here, we'll simply take the mentions found on
		* the message and add them members to the dead ArrayList.
		*/
		for(Member member : mentioned) {
			bot.dead.add(member);
			
			/*
			 *  We know they're dead now, so it's safe to issue a server mute right away
			 *  instead of waiting till the next call.
			 */
			member.mute(true);
		}
	}

}
