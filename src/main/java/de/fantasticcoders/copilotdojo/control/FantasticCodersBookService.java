package de.fantasticcoders.copilotdojo.control;


import de.fantasticcoders.copilotdojo.entity.FantasticCodersBook;
import de.fantasticcoders.copilotdojo.entity.FantasticCodersBookDto;
import org.springframework.stereotype.Component;

@Component
public class FantasticCodersBookService {

    // schreibe eine Methode die ein FantasticCodersBook in ein FantasticCodersBookDto umwandelt und dabei den Builder verwendet
    public FantasticCodersBookDto convertToDto(FantasticCodersBook fantasticCodersBook) {
        // wenn fantasticCodersBook null ist, dann gib null zurück
        if (fantasticCodersBook == null) {
            throw new IllegalArgumentException("fantasticCodersBook must not be null");
        }

        return FantasticCodersBookDto.builder()
                .id(fantasticCodersBook.getId())
                .title(fantasticCodersBook.getTitle())
                .tnummer(fantasticCodersBook.getTnummer())
                .koe(fantasticCodersBook.getKoe())
                .build();
    }


}
