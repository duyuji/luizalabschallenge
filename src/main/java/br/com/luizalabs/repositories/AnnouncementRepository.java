package br.com.luizalabs.repositories;

import br.com.luizalabs.repositories.entities.AnnouncementEntity;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository
public interface AnnouncementRepository extends CrudRepository<AnnouncementEntity, Long> {
}
