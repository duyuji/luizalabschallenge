package br.com.luizalabs.repositories.entities;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nullable;
import java.time.LocalDateTime;

@Builder
@Data
@MappedEntity
public class AnnouncementEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String destinatary;

    private String message;

    private LocalDateTime dateTimeToSend;

    @Nullable
    private LocalDateTime dateTimeOfSending;

    private AnnouncementTypeEntity type;

    private ProcessingStatusTypeEntity status;
}
