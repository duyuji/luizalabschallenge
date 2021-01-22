package br.com.luizalabs.adapters;

import br.com.luizalabs.controllers.entities.AnnouncementDTO;
import br.com.luizalabs.controllers.entities.AnnouncementTypeDTO;
import br.com.luizalabs.controllers.entities.ProcessingStatusTypeDTO;
import br.com.luizalabs.entities.Announcement;
import br.com.luizalabs.entities.AnnouncementType;
import br.com.luizalabs.entities.ProcessingStatusType;
import br.com.luizalabs.repositories.AnnouncementRepository;
import br.com.luizalabs.repositories.entities.AnnouncementEntity;
import br.com.luizalabs.repositories.entities.AnnouncementTypeEntity;
import br.com.luizalabs.repositories.entities.ProcessingStatusTypeEntity;
import br.com.luizalabs.usecases.exceptions.AnnouncementNotFoundException;
import br.com.luizalabs.usecases.exceptions.AnnouncementProcessedException;

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
                .dateTimeOfSending(announcementDTO.getDateTimeOfSending())
                .dateTimeToSend(announcementDTO.getDateTimeToSend())
                .status(ProcessingStatusType.valueOf(announcementDTO.getStatus().name()))
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
                .dateTimeOfSending(announcementEntity.getDateTimeOfSending())
                .dateTimeToSend(announcementEntity.getDateTimeToSend())
                .status(ProcessingStatusType.valueOf(announcementEntity.getStatus().name()))
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
                .dateTimeOfSending(announcementEntity.getDateTimeOfSending())
                .dateTimeToSend(announcementEntity.getDateTimeToSend())
                .status(ProcessingStatusTypeDTO.valueOf(announcementEntity.getStatus().name()))
                .build();
    }

    @Override
    public AnnouncementEntity convertToOutput(Announcement announcement) {
        return AnnouncementEntity.builder()
                .id(announcement.getId())
                .destinatary(announcement.getDestinatary())
                .message(announcement.getMessage())
                .type(AnnouncementTypeEntity.valueOf(announcement.getType().name()))
                .dateTimeOfSending(announcement.getDateTimeOfSending())
                .dateTimeToSend(announcement.getDateTimeToSend())
                .status(ProcessingStatusTypeEntity.valueOf(announcement.getStatus().name()))
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

        AnnouncementEntity entity = announcementEntityOptional.get();
        if (entity.getStatus().equals(ProcessingStatusTypeEntity.PROCESSED)) {
            throw new AnnouncementProcessedException();
        }
        repository.delete(entity);
    }
}
