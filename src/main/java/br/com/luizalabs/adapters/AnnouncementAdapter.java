package br.com.luizalabs.adapters;

import br.com.luizalabs.controllers.entities.AnnouncementDTO;
import br.com.luizalabs.entities.Announcement;
import br.com.luizalabs.repositories.entities.AnnouncementEntity;

import java.util.Optional;

public interface AnnouncementAdapter {

    Announcement convertFromInput(AnnouncementDTO announcementDTO);
    Announcement convertFromInput(AnnouncementEntity announcementEntity);
    AnnouncementDTO convertToOutput(AnnouncementEntity announcementEntity);
    AnnouncementEntity convertToOutput(Announcement announcement);
    AnnouncementDTO save(Announcement announcement);
    Optional<AnnouncementDTO> findById(long id);
    void delete(long id);
}
