package com.example.songsbot.repositories;

import com.example.songsbot.entities.SongCouplet;

public interface SongsRepositoryCustom<T extends SongCouplet> {
	T updateOrInsert(T object);
}
