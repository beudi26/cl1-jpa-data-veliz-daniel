package pe.edu.i202217363.cl1_jpa_data_veliz_daniel.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "city")
public class City {
    @Id
    private Integer ID;
    private String Name;
    private String District;
    private Integer Population;

    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country pais;

}
