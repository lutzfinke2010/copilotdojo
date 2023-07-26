package de.fantasticcoders.copilotdojo.entity;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class FantasticCodersBookDto {
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String tnummer;
    @NonNull
    private String koe;
}
