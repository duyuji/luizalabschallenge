package br.com.luizalabs.controllers.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnnouncementDTO {

    private Long id;

    private String destinatary;

    private String message;

    private AnnouncementTypeDTO type;
}
