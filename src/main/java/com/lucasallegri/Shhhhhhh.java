package com.lucasallegri;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Shhhhhhh extends ListenerAdapter {

	public JDA session;
	public String token;
	public VoiceChannel voiceChannel;
	public List<Member> dead = new ArrayList<Member>();
	public List<Member> crew = new ArrayList<Member>();

	public Shhhhhhh(String token) {

		this.token = token;
		initSession();
	}

	private void initSession() {

		try {
			this.session = JDABuilder.createDefault(this.token).enableCache(CacheFlag.VOICE_STATE)
					.addEventListeners(this).setActivity(Activity.playing("Among Us")).build();
		} catch (LoginException e) {
			e.printStackTrace();
		}
	}

	public JDA getSession() {
		return this.session;
	}

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {

		Message message = event.getMessage();
		String rawMessage = message.getContentRaw();

		// Drop the message event when it's author is our bot or it doesn't start with the proper prefix.
		if (event.getAuthor().getId().equals(this.session.getSelfUser().getId()) || !rawMessage.startsWith("a.")) {
			return;
		}

		if (rawMessage.startsWith("a.update")) {
			CommandUpdate.handle(this, event);
		} else if (rawMessage.startsWith("a.dead")) {
			CommandDead.handle(this, event);
		} else if (rawMessage.startsWith("a.call")) {
			CommandCall.handle(this, event);
		} else if (rawMessage.startsWith("a.lobby")) {
			CommandLobby.handle(this, event);
		} else if (rawMessage.startsWith("a.playing")) {
			CommandPlaying.handle(this, event);
		} else if (rawMessage.startsWith("a.debug")) {
			CommandDebug.handle(this, event);
		} else {
			event.getChannel().sendMessage("Valid commands: ```a. + lobby,playing,call,dead,update,debug```").queue();
		}
	}

	@Override
	public String toString() {
		return "[Shhhhhhh voiceChannel=" + this.voiceChannel + ",crew=" + this.crew + ",dead=" + this.dead + "]";
	}
}
