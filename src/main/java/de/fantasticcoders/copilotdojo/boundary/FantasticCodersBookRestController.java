package de.fantasticcoders.copilotdojo.boundary;

import de.fantasticcoders.copilotdojo.control.FantasticCodersBookRepository;
import de.fantasticcoders.copilotdojo.entity.FantasticCodersBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

@RestController
public class FantasticCodersBookRestController {

    // autowire the FantasticCodersBookRepository
    private final FantasticCodersBookRepository fantasticCodersBookRepository;
    @Autowired
    public FantasticCodersBookRestController(FantasticCodersBookRepository fantasticCodersBookRepository) {
        this.fantasticCodersBookRepository = fantasticCodersBookRepository;
    }


    // add a new get endpoint to get a FantasticCodersBook by id from the FantasticCodersBookRepository
    public FantasticCodersBook getFantasticCodersBookById(Long id) throws HttpServerErrorException {
        // ask repository to get the FantasticCodersBook with the given id
        FantasticCodersBook book = fantasticCodersBookRepository.findById(id).orElse(null);
        if (book != null) {
            return book;
        } else {
            // erzeuge einen String mit der Fehlermeldung
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND, "FantasticCodersBook with id " + id + " not found");
        }
    }

    // add a new get endpoint to get all FantasticCodersBook from the FantasticCodersBookRepository
    public Iterable<FantasticCodersBook> getAllFantasticCodersBooks() {
        // ask repository to get all FantasticCodersBooks
        return fantasticCodersBookRepository.findAll();
    }

    // add a new post endpoint to save a FantasticCodersBook in the FantasticCodersBookRepository
    public FantasticCodersBook saveFantasticCodersBook(FantasticCodersBook fantasticCodersBook) {
        // ask repository to save the FantasticCodersBook
        return fantasticCodersBookRepository.save(fantasticCodersBook);
    }
    // add a new delete endpoint to delete a FantasticCodersBook by id from the FantasticCodersBookRepository
    public void deleteFantasticCodersBookById(Long id) {
        // ask repository to delete the FantasticCodersBook with the given id
        fantasticCodersBookRepository.deleteById(id);
    }

    // create the updateFantasticCodersBook method
    public FantasticCodersBook updateFantasticCodersBook(FantasticCodersBook fantasticCodersBook) {
        // ask repository to save the FantasticCodersBook
        return fantasticCodersBookRepository.save(fantasticCodersBook);
    }
}
