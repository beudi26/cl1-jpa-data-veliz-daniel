package pe.edu.i202217363.cl1_jpa_data_veliz_daniel.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguagePk {
    private String Language;
    private String CountryCode;
}
