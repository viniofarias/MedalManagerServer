package medalManagerMain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import medalManagerMain.models.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>{
	Pais findByNome(String nome);
}
