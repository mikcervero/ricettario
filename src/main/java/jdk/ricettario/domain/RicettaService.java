package jdk.ricettario.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jdk.ricettario.repository.RicettaRepository;

@Service
public class RicettaService {

	@Autowired
	private RicettaRepository ricettaRepository;

	public boolean existRicettaByName(String nomeRicetta) {

		return this.ricettaRepository.existsByNomeRicetta(nomeRicetta);
	}
	
	public boolean existRicettaById(Long id) {

		return this.ricettaRepository.existsById(id);
	}

	public void creaRicetta(Ricetta nuovaRicetta) {

		this.ricettaRepository.save(nuovaRicetta);

	}
	
	

	public Ricetta getRicetta(Long id) {
         
		
		return this.ricettaRepository.findById(id).get();

	}

	public List<Ricetta> getRicette(String autore) {
		
		
		if (!autore.isEmpty()) {
			
			return (List<Ricetta>) this.ricettaRepository.findAllByAutore(autore);

		}
		
		else

		return this.ricettaRepository.findAll();

	}

	public List<Ricetta> getAllRicette() {
		return (List<Ricetta>) this.ricettaRepository.findAll();
	}

}
