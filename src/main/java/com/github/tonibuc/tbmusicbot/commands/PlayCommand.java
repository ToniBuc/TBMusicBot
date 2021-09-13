package com.github.tonibuc.tbmusicbot.commands;

import com.github.tonibuc.tbmusicbot.TrackLoadHandler;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.VoiceState;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.VoiceChannel;
import discord4j.discordjson.json.gateway.MessageCreate;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class PlayCommand extends CmdHandler {
    public static final TrackLoadHandler loader = new TrackLoadHandler(player);
    public static void Play(MessageCreateEvent event) {
        if (event.getMessage().getContent().toLowerCase(Locale.ROOT).startsWith("!play") || event.getMessage().getContent().toLowerCase(Locale.ROOT).startsWith("!p"))
        {
            if (connection == null){
                final Member member = event.getMember().orElse(null);
                final VoiceState voiceState = member.getVoiceState().block();
                if (voiceState != null) {
                    final VoiceChannel channel = voiceState.getChannel().block();
                    if (channel != null) {
                        connection = channel.join(spec -> spec.setProvider(provider)).block();
                    }
                }
            }
            final String content = event.getMessage().getContent();
            final List<String> command = Arrays.asList(content.split(" "));
            playerManager.loadItem(command.get(1), loader);
        }
    }
}
