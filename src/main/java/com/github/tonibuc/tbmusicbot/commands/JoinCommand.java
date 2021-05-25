package com.github.tonibuc.tbmusicbot.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.VoiceState;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.channel.VoiceChannel;
import discord4j.voice.VoiceConnection;

public class JoinCommand extends CmdHandler{
    public static VoiceConnection connection = null;
    public static void Join(MessageCreateEvent event) {
        if (event.getMessage().getContent().equalsIgnoreCase("!join"))
        {
            final Member member = event.getMember().orElse(null);
            final VoiceState voiceState = member.getVoiceState().block();
            if (voiceState != null) {
                final VoiceChannel channel = voiceState.getChannel().block();
                if (channel != null) {
                    connection = channel.join(spec -> spec.setProvider(provider)).block();
                }
            }
        }
    }
}
