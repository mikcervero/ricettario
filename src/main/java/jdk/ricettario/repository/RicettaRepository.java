package jdk.ricettario.repository;

import jdk.ricettario.domain.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RicettaRepository extends JpaRepository<Ricetta,Long> {
	
	public List<Ricetta> findByNomeRicettaAndAutore(String nomeRicetta,String autore);
	public Ricetta findByNomeRicetta(String nomeRicetta);
	public List<Ricetta> findAllByAutore(String autore);
	public boolean existsByNomeRicetta(String nomeRicetta);
	
}

