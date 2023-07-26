package de.fantasticcoders.copilotdojo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class FantasticCodersBook {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String tnummer;
    @NonNull
    private String koe;
}
