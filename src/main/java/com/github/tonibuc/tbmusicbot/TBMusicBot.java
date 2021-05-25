package com.github.tonibuc.tbmusicbot;

import com.github.tonibuc.tbmusicbot.commands.*;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;

import java.util.*;

public class TBMusicBot {
    private static final Map<String, Command> commands = new HashMap<>();
    public static void main(String[] args) {
        final GatewayDiscordClient client = DiscordClientBuilder.create(args[0])
                .build()
                .login()
                .block();

        client.getEventDispatcher().on(MessageCreateEvent.class)
                .subscribe(event -> {
                    final String content = event.getMessage().getContent();

                    for(final Map.Entry<String, Command> entry : commands.entrySet()) {
                        if (content.startsWith("!" + entry.getKey())) {
                            entry.getValue().execute(event);
                            break;
                        }
                    }
                });

        client.getEventDispatcher().on(ReadyEvent.class).subscribe(ready -> CmdHandler.main(""));
        client.getEventDispatcher().on(MessageCreateEvent.class).subscribe(JoinCommand::Join);
        client.getEventDispatcher().on(MessageCreateEvent.class).subscribe(DisconnectCommand::Disconnect);
        client.getEventDispatcher().on(MessageCreateEvent.class).subscribe(PlayCommand::Play);
        client.getEventDispatcher().on(MessageCreateEvent.class).subscribe(PauseCommand::Pause);
        client.getEventDispatcher().on(MessageCreateEvent.class).subscribe(ContinueCommand::Continue);
        client.getEventDispatcher().on(MessageCreateEvent.class).subscribe(SkipCommand::Skip);
        client.getEventDispatcher().on(MessageCreateEvent.class).subscribe(CurrentCommand::Current);
        client.getEventDispatcher().on(MessageCreateEvent.class).subscribe(ShowQueueCommand::ShowQueue);
        client.getEventDispatcher().on(MessageCreateEvent.class).subscribe(KislevCommand::Kislev);

        client.onDisconnect().block();
//
    }
}
