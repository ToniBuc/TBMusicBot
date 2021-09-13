package com.github.tonibuc.tbmusicbot.commands;

import com.github.tonibuc.tbmusicbot.LavaPlayerAudioProvider;
import com.github.tonibuc.tbmusicbot.TrackScheduler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.track.playback.NonAllocatingAudioFrameBuffer;
import discord4j.voice.AudioProvider;
import discord4j.voice.VoiceConnection;

public class CmdHandler {
    public static final AudioPlayerManager playerManager = new DefaultAudioPlayerManager();
    public static final AudioPlayer player = playerManager.createPlayer();
    public static LavaPlayerAudioProvider provider = new LavaPlayerAudioProvider(player);
    public static final TrackScheduler scheduler = new TrackScheduler(player);
    public static VoiceConnection connection = null;
    public static void main(String args) {
        playerManager.getConfiguration().setFrameBufferFactory(NonAllocatingAudioFrameBuffer::new);
        AudioSourceManagers.registerRemoteSources(playerManager);
        AudioProvider provider = new LavaPlayerAudioProvider(player);
        player.addListener(scheduler);
    }
}
