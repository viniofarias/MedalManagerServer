package medalManagerMain.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import medalManagerMain.DTOs.EsporteDTO;

@Getter
@Setter
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="esportes")
public class Esporte {
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nome;
    
    
    @OneToMany(mappedBy = "esporte", fetch = FetchType.LAZY)
    private List<Medalha> medalhas;
    
    public Esporte(EsporteDTO esporteDto) {
        this.id=esporteDto.getId();
    	this.nome = esporteDto.getNome();
    }
}
