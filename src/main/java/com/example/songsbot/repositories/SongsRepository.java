package com.example.songsbot.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.songsbot.entities.SongCouplet;


@Repository
public interface SongsRepository extends MongoRepository<SongCouplet, String>, SongsRepositoryCustom<SongCouplet> {
	List<SongCouplet> findAllByArtist(String artist);

	List<SongCouplet> findAllByArtistAndSong(String artist, String song);
}
