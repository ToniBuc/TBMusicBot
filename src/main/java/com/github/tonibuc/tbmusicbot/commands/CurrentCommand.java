package com.github.tonibuc.tbmusicbot.commands;

import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.rest.util.Color;

import java.util.concurrent.TimeUnit;

public class CurrentCommand extends CmdHandler{
    public static void Current(MessageCreateEvent event) {
        if (player.getPlayingTrack() != null)
        {
            if (event.getMessage().getContent().equalsIgnoreCase("!current"))
            {
                event.getMessage()
                        .getChannel().block()
                        .createEmbed(spec ->
                                spec.setColor(Color.RED)
                                        .setAuthor("Current track:", "","")
                                        .setTitle(player.getPlayingTrack().getInfo().title)
                                        .setUrl(player.getPlayingTrack().getInfo().uri)
                                        .addField("Duration:", String.format("%02d:%02d",
                                                TimeUnit.MILLISECONDS.toMinutes(player.getPlayingTrack().getInfo().length),
                                                TimeUnit.MILLISECONDS.toSeconds(player.getPlayingTrack().getInfo().length) -
                                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(player.getPlayingTrack().getInfo().length))), true)
                                        .addField("Elapsed:", String.format("%02d:%02d",
                                                TimeUnit.MILLISECONDS.toMinutes(player.getPlayingTrack().getPosition()),
                                                TimeUnit.MILLISECONDS.toSeconds(player.getPlayingTrack().getPosition()) -
                                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(player.getPlayingTrack().getPosition()))), true)
                                        .addField("Uploaded by:", player.getPlayingTrack().getInfo().author, true)).block();
            }
        }
        else{
            if (event.getMessage().getContent().equalsIgnoreCase("!current"))
            {
                event.getMessage()
                        .getChannel().block()
                        .createEmbed(spec ->
                                spec.setColor(Color.RED)
                                        .setAuthor("There is currently no track playing.", "","")).block();
            }
        }
    }
}
