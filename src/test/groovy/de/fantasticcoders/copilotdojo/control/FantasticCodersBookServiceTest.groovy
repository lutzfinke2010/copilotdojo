package de.fantasticcoders.copilotdojo.control

import de.fantasticcoders.copilotdojo.entity.FantasticCodersBook
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class FantasticCodersBookServiceTest extends Specification {

    // erzeuge ein Objekt von FantasticCodersBookService
    def fantasticCodersBookService = new FantasticCodersBookService()

    // schreibe einen Test für die Methode convertToDto
    def "convertToDto should convert a FantasticCodersBook to a FantasticCodersBookDto"() {
        given:
        // erzeuge ein FantasticCodersBook
        def fantasticCodersBook = FantasticCodersBook.builder().title("title").tnummer("tnummer").koe("koe").build()

        when:
        // rufe die convertToDto Methode von fantasticCodersBookService auf
        def fantasticCodersBookDto = fantasticCodersBookService.convertToDto(fantasticCodersBook)

        then:
        // prüfe ob das FantasticCodersBookDto korrekt erzeugt wurde
        fantasticCodersBookDto.title == "title"
        fantasticCodersBookDto.tnummer == "tnummer"
        fantasticCodersBookDto.koe == "koe"
    }

    // schreibe einen Test für die Methode convertToDto wenn das übergebene FantasticCodersBook null ist
    def "convertToDto should throw an IllegalArgumentException if the FantasticCodersBook is null"() {
        given:
        // erzeuge ein FantasticCodersBook
        def fantasticCodersBook = null

        when:
        // rufe die convertToDto Methode von fantasticCodersBookService auf
        fantasticCodersBookService.convertToDto(fantasticCodersBook)

        then:
        // prüfe ob das FantasticCodersBookDto korrekt erzeugt wurde
        thrown(IllegalArgumentException)
    }
}
