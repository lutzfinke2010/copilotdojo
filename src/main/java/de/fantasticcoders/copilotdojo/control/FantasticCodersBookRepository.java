package de.fantasticcoders.copilotdojo.control;


import de.fantasticcoders.copilotdojo.entity.FantasticCodersBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FantasticCodersBookRepository extends CrudRepository<FantasticCodersBook, Long> {
}
