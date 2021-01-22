package br.com.luizalabs.controllers;


import br.com.luizalabs.adapters.AnnouncementAdapter;
import br.com.luizalabs.controllers.entities.AnnouncementDTO;
import br.com.luizalabs.controllers.entities.ProcessingStatusTypeDTO;
import br.com.luizalabs.entities.Announcement;
import br.com.luizalabs.usecases.AnnouncementUseCase;
import br.com.luizalabs.usecases.exceptions.AnnouncementNotFoundException;
import br.com.luizalabs.usecases.exceptions.AnnouncementProcessedException;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller("/announcements")
public class AnnouncementController {
    private AnnouncementAdapter announcementAdapter;
    private AnnouncementUseCase announcementUseCase;

    public AnnouncementController(AnnouncementAdapter announcementAdapter, AnnouncementUseCase announcementUseCase) {
        this.announcementAdapter = announcementAdapter;
        this.announcementUseCase = announcementUseCase;
    }

    @Post
    public HttpResponse save(@Body @Valid AnnouncementDTO input) {
        AnnouncementDTO announcementDTO = input.toBuilder()
                .dateTimeOfSending(null)
                .status(ProcessingStatusTypeDTO.TO_PROCESS)
                .build();
        Announcement announcement = announcementAdapter.convertFromInput(announcementDTO);
        AnnouncementDTO output = announcementUseCase.save(announcement);
        return HttpResponse.created(output);
    }

    @Get(value = "/{id}")
    public HttpResponse findById(Long id) {
        Optional<AnnouncementDTO> optional = announcementUseCase.find(id);
        if (optional.isPresent()) {
            return HttpResponse.ok(optional.get());
        }
        return HttpResponse.notFound();
    }

    @Delete(value = "/{id}")
    public HttpResponse delete(long id) {
        try {
            announcementUseCase.delete(id);
        } catch (AnnouncementNotFoundException e) {
            return HttpResponse.notFound();
        } catch (AnnouncementProcessedException e) {
            return HttpResponse
                    .status(HttpStatus.CONFLICT)
                    .body("Can't delete, the announcement was processed");
        }
        return HttpResponse.ok();
    }
}
