package com.github.tonibuc.tbmusicbot.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class PlayCommand extends CmdHandler {
    public static void Play(MessageCreateEvent event) {
        if (event.getMessage().getContent().toLowerCase(Locale.ROOT).startsWith("!play"))
        {
            final String content = event.getMessage().getContent();
            final List<String> command = Arrays.asList(content.split(" "));
            playerManager.loadItem(command.get(1), scheduler);
        }
    }
}