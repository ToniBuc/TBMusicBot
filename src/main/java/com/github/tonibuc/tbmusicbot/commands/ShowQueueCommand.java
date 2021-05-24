package com.github.tonibuc.tbmusicbot.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.rest.util.Color;

public class ShowQueueCommand extends CmdHandler{
    public static void ShowQueue(MessageCreateEvent event) {
        if (scheduler.queueList.size() != 0)
        {
            if (event.getMessage().getContent().equalsIgnoreCase("!q"))
            {
                String msg = new String();
                int i = 0;
                do {
                    msg += i+1 + ". " + scheduler.queueList.get(i).getInfo().title + "\n";
                    i++;
                } while (i < scheduler.queueList.size());

                event.getMessage().getChannel().block()
                        .createMessage("``` Currently in queue:\n" + msg + "```").block();
            }
        }
        else {
            if (event.getMessage().getContent().equalsIgnoreCase("!q"))
            {
                event.getMessage()
                        .getChannel().block()
                        .createEmbed(spec ->
                                spec.setColor(Color.RED)
                                        .setAuthor("The queue is currently empty.", "","")).block();
            }
        }
    }
}
