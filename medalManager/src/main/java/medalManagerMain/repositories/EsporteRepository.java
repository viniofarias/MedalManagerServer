package medalManagerMain.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import medalManagerMain.models.Esporte;

public interface EsporteRepository extends JpaRepository<Esporte, Long> {
	Esporte findByNome(String nome);
}
