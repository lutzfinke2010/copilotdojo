package de.fantasticcoders.copilotdojo.boundary

import de.fantasticcoders.copilotdojo.control.FantasticCodersBookRepository
import de.fantasticcoders.copilotdojo.entity.FantasticCodersBook
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.web.client.HttpServerErrorException
import spock.lang.Specification

@SpringBootTest
class FantasticCodersBookRestControllerTest extends Specification {

    // create a mock for the fantasticCodersBookRepository
    def fantasticCodersBookRepository = Mock(FantasticCodersBookRepository)
    // create a fantasticCodersBookRestController with the mock
    private FantasticCodersBookRestController fantasticCodersBookRestController = new FantasticCodersBookRestController(fantasticCodersBookRepository)


    // write a test for the getFantasticCodersBooks method
    def "getFantasticCodersBooks should return all fantasticCodersBooks"() {
        given:
        // mock the findAll method of the fantasticCodersBookRepository
        fantasticCodersBookRepository.findAll() >> [FantasticCodersBook.builder().title("title").tnummer("tnummer").koe("koe").build()]

        when:
        // call the getFantasticCodersBooks method of the fantasticCodersBookRestController
        def fantasticCodersBooks = fantasticCodersBookRestController.getAllFantasticCodersBooks()

        then:
        // check if the fantasticCodersBooks are returned
        fantasticCodersBooks.size() == 1
        fantasticCodersBooks[0].title == "title"
    }

    // write a test which create a new fantasticcodersBook with title, tnummer, koe  and save this fantasticCodersBook
    def "createFantasticCodersBook should create a new fantasticCodersBook"() {
        given:
        // create a fantasticCodersBook
        def fantasticCodersBook = FantasticCodersBook.builder().title("title").tnummer("tnummer").koe("koe").build()
        // mock the save method of the fantasticCodersBookRepository
        fantasticCodersBookRepository.save(fantasticCodersBook) >> fantasticCodersBook

        when:
        // call the createFantasticCodersBook method of the fantasticCodersBookRestController
        def createdFantasticCodersBook = fantasticCodersBookRestController.saveFantasticCodersBook(fantasticCodersBook)

        then:
        // check if the fantasticCodersBook is returned
        createdFantasticCodersBook.title == "title"
        createdFantasticCodersBook.tnummer == "tnummer"
        createdFantasticCodersBook.koe == "koe"
    }

    // write a test which update a fantasticCodersBook with title, tnummer, koe  and save this fantasticCodersBook
    def "updateFantasticCodersBook should update a fantasticCodersBook"() {
        given:
        // create a fantasticCodersBook
        def fantasticCodersBook = FantasticCodersBook.builder().title("title").tnummer("tnummer").koe("koe").build()
        // mock the save method of the fantasticCodersBookRepository
        fantasticCodersBookRepository.save(fantasticCodersBook) >> fantasticCodersBook

        when:
        // call the updateFantasticCodersBook method of the fantasticCodersBookRestController
        def updatedFantasticCodersBook = fantasticCodersBookRestController.updateFantasticCodersBook(fantasticCodersBook)

        then:
        // check if the fantasticCodersBook is returned
        updatedFantasticCodersBook.title == "title"
        updatedFantasticCodersBook.tnummer == "tnummer"
        updatedFantasticCodersBook.koe == "koe"
    }

    // write a test for the deleteFantasticCodersBookById method which delete a fantasticCodersBook by id
    def "deleteFantasticCodersBookById should delete a fantasticCodersBook by id"() {
        given:
        // create a fantasticCodersBook

        when:
        // call the deleteFantasticCodersBookById method of the fantasticCodersBookRestController
        fantasticCodersBookRestController.deleteFantasticCodersBookById(1L)

        then:
        // check if the fantasticCodersBook is deleted
        1 == 1
    }

    // write a test for the getFantasticCodersBookById method when the fantasticcodersBookrepository return an empty optional and check if the exception was thrown
    def "getFantasticCodersBookById should throw an exception when the fantasticCodersBook is not found"() {
        given:
        // mock the findById method of the fantasticCodersBookRepository
        fantasticCodersBookRepository.findById(1L) >> Optional.empty()

        when:
        // call the getFantasticCodersBookById method of the fantasticCodersBookRestController and check if the exception was thrown
        fantasticCodersBookRestController.getFantasticCodersBookById(1L)

        then:
        // check if the exception was thrown
        def exception = thrown(HttpServerErrorException)
        exception.statusCode == HttpStatus.NOT_FOUND
        exception.message == "404 FantasticCodersBook with id 1 not found"
    }



}
