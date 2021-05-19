package com.github.tonibuc.tbmusicbot.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;

public class SkipCommand extends CmdHandler{
    public static void Skip(MessageCreateEvent event) {
        if (event.getMessage().getContent().equalsIgnoreCase("!skip"))
        {
            player.stopTrack();
        }
    }
}
