package jdk.ricettario.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jdk.ricettario.domain.Ricetta;
import jdk.ricettario.domain.RicettaService;

@RestController
@RequestMapping(value = "/ricetta")
public class RicettaController {

	private static final Logger log = Logger.getLogger(RicettaController.class);

	@Autowired
	private RicettaService ricetteService;

	@CrossOrigin(origins="*")
	@PostMapping(value = "/addRicetta", consumes = "application/json")
	public ResponseEntity<String> addRicetta(@RequestBody Map<String, String> o) {

		String autore = o.get("Autore");
		String nomeRicetta = o.get("Nome");
		String durataPreparazione = o.get("Durata");
		String descrizioneRicetta = o.get("Descrizione");
		ResponseEntity<String> response;
		
		if (!this.ricetteService.existRicettaByName(nomeRicetta)) {

			Ricetta nuovaRicetta = new Ricetta(autore, nomeRicetta, durataPreparazione, descrizioneRicetta);
			log.info("Sto creando la ricetta");

			this.ricetteService.creaRicetta(nuovaRicetta);

			response = new ResponseEntity<String>("La Ricetta " + nomeRicetta + " è stata aggiunta con successo",
					HttpStatus.OK);

		}

		else {
			log.info("La ricetta già esiste");
			response = new ResponseEntity<String>("La Ricetta " + nomeRicetta + " già esiste ",
					HttpStatus.BAD_REQUEST);
		}

		return response;
	}
	
	@CrossOrigin
	@GetMapping(value = "/find/{id}", produces = "application/json")
	public ResponseEntity<Ricetta> getRicetta( @PathVariable Long id  ) {
		
		System.out.println("Sono nel id!!!!!!!!");

		Ricetta ricetta = this.ricetteService.getRicetta(id);
		
	    if(ricetta!=null) {

		ResponseEntity<Ricetta> response = new ResponseEntity<Ricetta>(ricetta, HttpStatus.OK);
		
		return response;
	    }
	    
	    else {
	    	
	    	 log.info("Ricetta non trovata ");
	    	 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ricetta non trovata");
	    	 }

	}
	
	@CrossOrigin
	@GetMapping(value = "/find", produces = "application/json")
	public ResponseEntity<List<Ricetta>> getRicette( @RequestParam(value = "autore", defaultValue = "", required=false) String autore) {

		System.out.println("Sono nel find!!!!!!!!");
		
		List<Ricetta> ricette = this.ricetteService.getRicette(autore);

		ResponseEntity<List<Ricetta>> response = new ResponseEntity<List<Ricetta>>(ricette, HttpStatus.OK);

		return response;

	}

	@CrossOrigin
	@PutMapping(value = "/update/{id}", consumes = "application/json", produces="application/json")
	public ResponseEntity<Ricetta> updateRicetta(@RequestBody Map<String, String> o, @PathVariable Long id  ) {

		ResponseEntity<Ricetta> response;
		String nuovaDescrizione = o.get("Descrizione");

		if (this.ricetteService.existRicettaById(id)) {

			Ricetta ricetta = this.ricetteService.getRicetta(id);
			
			ricetta.setDescrizione(nuovaDescrizione);
			
			this.ricetteService.creaRicetta(ricetta);
			
			Ricetta ricettaNuovade= this.ricetteService.getRicetta(id);

			response = new ResponseEntity<Ricetta>(ricettaNuovade, HttpStatus.OK);

		}

		else {
			log.info("Ricetta non trovata ");
	    	 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ricetta non trovata");
		}

		return response;

	}

	// @GetMapping(value = "/ricetta", produces = "application/json")
	// public ResponseEntity<Ricetta> getRicetta(@RequestParam(value="nome") String
	// nomeRicetta) {
	//
	//
	//
	// if (this.ricetteService.existRicetta(nomeRicetta)) {
	//
	// log.info("Sto recuperando la ricetta");
	//
	// Ricetta ricetta = this.ricetteService.getRicetta(nomeRicetta);
	// ResponseEntity<Ricetta> response = new ResponseEntity<Ricetta>(ricetta,
	// HttpStatus.OK);
	//
	//
	// return response;
	// }
	//
	// else {
	//
	// log.info("Ricetta non trovata ");
	// throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ricetta not found");
	// }
	//
	// }

	// @GetMapping(value = "/ricetta/autore", produces = "application/json")
	// public ResponseEntity<List<Ricetta>> getRicette(@RequestParam(value="autore")
	// String autore) {
	//
	// log.info("Sono entrata");
	//
	// if (!this.ricetteService.getRicette(autore).isEmpty()) {
	//
	// log.info("Recupero delle ricette");
	//
	// List<Ricetta> ricette = this.ricetteService.getRicette(autore);
	// ResponseEntity<List<Ricetta>> response = new
	// ResponseEntity<List<Ricetta>>(ricette, HttpStatus.OK);
	//
	//
	// return response;
	// }
	//
	// else {
	//
	// log.info("Autore non trovato");
	//
	// throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Autore non
	// trovato");
	// }
	//
	// }

}
