package com.github.tonibuc.tbmusicbot.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;

public class DisconnectCommand extends JoinCommand{
    public static void Disconnect(MessageCreateEvent event) {
        if (connection != null && event.getMessage().getContent().equalsIgnoreCase("!disconnect") || event.getMessage().getContent().equalsIgnoreCase("!dc") ){
            connection.disconnect().block();
        }
    }
}
