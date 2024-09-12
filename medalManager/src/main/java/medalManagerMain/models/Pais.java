package medalManagerMain.models;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "paises")
public class Pais {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String nome;
	
	@OneToMany(mappedBy = "pais", fetch = FetchType.EAGER)
	private List<Medalha> medalhas;
	
	@ManyToMany(mappedBy = "paises", fetch = FetchType.LAZY )
	private List<Usuario> usuarios;
	

}
