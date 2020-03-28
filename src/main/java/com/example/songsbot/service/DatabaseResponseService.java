package com.example.songsbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.songsbot.repositories.SongsRepository;
import com.example.telegrambotspring.services.ResponseService;

@Service
@Primary
public class DatabaseResponseService extends AbstractResponseService implements ResponseService {
	private SongsRepository repository;

	@Autowired
	public DatabaseResponseService(SongsRepository repository) {
		this.repository = repository;
	}

	@Override
	public void updateSongCouplets(String artist) throws Exception {
		sets = artist == null
				? repository.findAll()
				: repository.findAllByArtist(artist);
	}
}
