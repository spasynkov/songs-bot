package com.example.songsbot;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.example.songsbot.entities.SongsBot;
import com.example.telegrambotspring.entities.Chat;
import com.example.telegrambotspring.utils.Pair;

@SpringBootApplication
@SpringBootConfiguration
@ComponentScan(basePackages = {"com.example.telegrambotspring", "com.example.songsbot"},
		excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
				@ComponentScan.Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class)})
public class SongsBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongsBotApplication.class, args);
	}

	@Bean
	public Map<Chat, Pair<Long, String>> answersForChats() {
		return new ConcurrentHashMap<>();
	}

	@Bean
	public SongsBot songsBot(@Value("${telegram.bot.token}") String token, Map<Chat, Pair<Long, String>> answersForChats) {
		return new SongsBot(token, answersForChats, SongsBot.UpdatesStrategy.WEBHOOKS);
	}

}
