package com.example.demo.dto;



import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class SongDto implements Validator {
    private Long id;
    private String nameSong;
    private String artist;
    private String album;

    public SongDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return SongDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if (songDto.getNameSong() == null || songDto.getNameSong().trim().isEmpty()) {
            errors.rejectValue("nameSong", null,"songDto.nameSong.empty");

        } else if (!songDto.getNameSong().matches("^(?!\\s*$)[A-Za-zÀ-ỹ0-9\\s]{1,800}$")) {
            errors.rejectValue("nameSong", null,"Không chứa ký tự đặc biệt, tối đa 800 ký tự");
        }
        if (songDto.getArtist() == null || songDto.getArtist().trim().isEmpty()) {
            errors.rejectValue("artist", null,"Tên nghệ sĩ không được trống");
        } else if (!songDto.getArtist().matches("^(?!\\s*$)[A-Za-zÀ-ỹ0-9\\s]{1,300}$")) {
            errors.rejectValue("artist", null,"Không chứa ký tự đặc biệt, tối đa 300 ký tự");
        }
        if (songDto.getAlbum() == null || songDto.getAlbum().trim().isEmpty()) {
            errors.rejectValue("album", null,"Tên album không được trống");

        } else if (!songDto.getAlbum().matches("^(?!\\s*$)[A-Za-zÀ-ỹ0-9\\s]{1,1000}$")) {
            errors.rejectValue("album", null,"Không chứa ký tự đặc biệt, tối đa 1000 ký tự");
        }
    }
}
