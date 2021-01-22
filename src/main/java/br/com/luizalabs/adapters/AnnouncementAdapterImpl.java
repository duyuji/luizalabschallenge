package br.com.luizalabs.adapters;

import br.com.luizalabs.controllers.entities.AnnouncementDTO;
import br.com.luizalabs.controllers.entities.AnnouncementTypeDTO;
import br.com.luizalabs.entities.Announcement;
import br.com.luizalabs.entities.AnnouncementType;
import br.com.luizalabs.repositories.AnnouncementRepository;
import br.com.luizalabs.repositories.entities.AnnouncementEntity;
import br.com.luizalabs.repositories.entities.AnnouncementTypeEntity;
import br.com.luizalabs.usecases.exceptions.AnnouncementNotFoundException;

import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class AnnouncementAdapterImpl implements AnnouncementAdapter {
    private AnnouncementRepository repository;

    public AnnouncementAdapterImpl(AnnouncementRepository announcementRepository) {
        this.repository = announcementRepository;
    }

    @Override
    public Announcement convertFromInput(AnnouncementDTO announcementDTO) {
        return Announcement.builder()
                .id(announcementDTO.getId())
                .destinatary(announcementDTO.getDestinatary())
                .message(announcementDTO.getMessage())
                .type(AnnouncementType.valueOf(announcementDTO.getType().name()))
                .build()
                .get();
    }

    @Override
    public Announcement convertFromInput(AnnouncementEntity announcementEntity) {
        return Announcement.builder()
                .id(announcementEntity.getId())
                .destinatary(announcementEntity.getDestinatary())
                .message(announcementEntity.getMessage())
                .type(AnnouncementType.valueOf(announcementEntity.getType().name()))
                .build()
                .get();
    }

    @Override
    public AnnouncementDTO convertToOutput(AnnouncementEntity announcementEntity) {
        return AnnouncementDTO.builder()
                .id(announcementEntity.getId())
                .destinatary(announcementEntity.getDestinatary())
                .message(announcementEntity.getMessage())
                .type(AnnouncementTypeDTO.valueOf(announcementEntity.getType().name()))
                .build();
    }

    @Override
    public AnnouncementEntity convertToOutput(Announcement announcement) {
        return AnnouncementEntity.builder()
                .id(announcement.getId())
                .destinatary(announcement.getDestinatary())
                .message(announcement.getMessage())
                .type(AnnouncementTypeEntity.valueOf(announcement.getType().name()))
                .build();
    }

    @Override
    public AnnouncementDTO save(Announcement announcement) {
        AnnouncementEntity announcementEntity = convertToOutput(announcement);
        AnnouncementEntity announcementEntitySave = repository.save(announcementEntity);
        return convertToOutput(announcementEntitySave);
    }

    @Override
    public Optional<AnnouncementDTO> findById(long id) {
        Optional<AnnouncementEntity> announcementEntityOptional = repository.findById(id);
        if (announcementEntityOptional.isPresent()) {
            return Optional.of(convertToOutput(announcementEntityOptional.get()));
        }
        return Optional.empty();
    }

    @Override
    public void delete(long id) {
        Optional<AnnouncementEntity> announcementEntityOptional = repository.findById(id);

        if (!announcementEntityOptional.isPresent()) {
            throw new AnnouncementNotFoundException();
        }

        repository.delete(announcementEntityOptional.get());
    }
}
