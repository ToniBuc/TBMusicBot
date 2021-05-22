package com.github.tonibuc.tbmusicbot.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.rest.util.Color;

import java.util.concurrent.TimeUnit;

//this command is an inside joke between friends
public class KislevCommand extends CmdHandler{
    public static void Kislev(MessageCreateEvent event) {
        if (event.getMessage().getContent().equalsIgnoreCase("Kislev"))
        {
            event.getMessage()
                    .getChannel().block()
                    .createMessage("Kislev.").block();
        }
    }
}
