package com.github.tonibuc.tbmusicbot.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;

public class EmptyQueueCommand extends CmdHandler {
    public static void Empty(MessageCreateEvent event) {
        if (event.getMessage().getContent().equalsIgnoreCase("!empty") || event.getMessage().getContent().equalsIgnoreCase("!e"))
        {
            int x = scheduler.queueList.size();
            for(int i = 0; i <= x; i++){
                player.stopTrack();
                scheduler.nextTrack();
            }
        }
    }
}
