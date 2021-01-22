package br.com.luizalabs.usecases;

import br.com.luizalabs.adapters.AnnouncementAdapter;
import br.com.luizalabs.controllers.entities.AnnouncementDTO;
import br.com.luizalabs.entities.Announcement;
import br.com.luizalabs.usecases.exceptions.AnnouncementNotFoundException;

import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class AnnouncementUseCase {
    private AnnouncementAdapter adapter;

    public AnnouncementUseCase(AnnouncementAdapter announcementAdapter) {
        this.adapter = announcementAdapter;
    }

    public AnnouncementDTO save(Announcement announcement) {
        return adapter.save(announcement);
    }

    public Optional<AnnouncementDTO> find(long id) {
        return adapter.findById(id);
    }

    public void delete(long id) {
        adapter.delete(id);
    }
}
