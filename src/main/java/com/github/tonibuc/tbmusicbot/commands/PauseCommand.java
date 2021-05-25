package com.github.tonibuc.tbmusicbot.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;

public class PauseCommand extends CmdHandler{
    public static void Pause(MessageCreateEvent event) {
        if (event.getMessage().getContent().equalsIgnoreCase("!pause") && !player.isPaused()){
            player.setPaused(true);
        }
    }
}
