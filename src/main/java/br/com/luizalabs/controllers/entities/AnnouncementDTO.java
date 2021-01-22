package br.com.luizalabs.controllers.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.micronaut.core.annotation.Introspected;
import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Introspected
public class AnnouncementDTO {

    private Long id;

    @NotNull @NotBlank
    private String destinatary;

    @NotNull @NotBlank
    private String message;

    @NotNull @Future
    private LocalDateTime dateTimeToSend;

    private LocalDateTime dateTimeOfSending;

    @NotNull
    private AnnouncementTypeDTO type;

    private ProcessingStatusTypeDTO status;
}
