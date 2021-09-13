package com.github.tonibuc.tbmusicbot.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;

public class ContinueCommand extends CmdHandler{
    public static void Continue(MessageCreateEvent event) {
        if (event.getMessage().getContent().equalsIgnoreCase("!continue") && player.isPaused() || event.getMessage().getContent().equalsIgnoreCase("!cont") && player.isPaused()){
            player.setPaused(false);
        }
    }
}
