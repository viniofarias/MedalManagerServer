package medalManagerMain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import medalManagerMain.models.Medalha;

public interface MedalhaRepository extends JpaRepository<Medalha, Long>{

}
