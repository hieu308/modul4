package com.example.demo.service;

import com.example.demo.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findById(Long id);
    void save(Song student);
    void delete(Long id);
}
