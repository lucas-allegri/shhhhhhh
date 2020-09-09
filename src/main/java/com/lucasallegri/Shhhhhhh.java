package com.lucasallegri;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Shhhhhhh extends ListenerAdapter {
    
    public JDA session;
    public String token;
    public String voiceChannelSnowflake;
    public int[] dead;
    public int[] crew;
    
    public Shhhhhhh(String token) {
        
        this.token = token;
        initSession();
    }
    
    private void initSession() {
    	
    	try {
			this.session = 
					JDABuilder.createLight(this.token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
		            .addEventListeners(this)
		            .setActivity(Activity.playing("Among Us"))
		            .build();
		} catch (LoginException e) {
			e.printStackTrace();
		}
    }
    
    public JDA getSession() {
    	return this.session;
    }
    
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
    	Message msg = event.getMessage();
    	switch(msg.getContentRaw()) {
    	case "a.update": 
    		CommandUpdate.handle(this, event);
    		break;
    	case "a.debug":
    		CommandDebug.handle(this, event);
    		break;
    	default:
    		event.getChannel().sendMessage("Command not found.");
    		break;
    	}
    }
    
    @Override
    public String toString() {
    	return "[Shhhhhhh voiceChannelSnowflake="+this.voiceChannelSnowflake+",crew="+this.crew+",dead="+this.dead+"]";
    }
}
