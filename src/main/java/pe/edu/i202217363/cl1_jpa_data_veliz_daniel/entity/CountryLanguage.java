package pe.edu.i202217363.cl1_jpa_data_veliz_daniel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {
    @EmbeddedId
    private LanguagePk LanguagePk;
    private String IsOfficial;
    private Double Percentage;

    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false, insertable = false, updatable = false)
    @MapsId("CountryCode")
    private Country country;
}
