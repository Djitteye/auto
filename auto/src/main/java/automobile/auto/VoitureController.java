package automobile.auto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")



public class VoitureController {
	
	@Autowired
	private VoitureRepository voitureRepository;
	
	@PostMapping("/voiture")
	Voiture newVoiture(@RequestBody Voiture newVoiture){
		return voitureRepository.save(newVoiture);
		
		
		
	}
	
	@GetMapping("/voitures")
	List<Voiture> getAllVoiture(){
		return voitureRepository.findAll();
	}
	 
	

    @PutMapping("/voituress/{id}")
    public ResponseEntity<Voiture> updateVoiture(@PathVariable long id,@RequestBody Voiture voiture) {
        Voiture updateVoiture = voitureRepository.findById(id).orElseThrow();
        
/*
   
        updateVoiture.setMarque(voiture.getMarque());
        updateVoiture.setModele(voiture.getModele());
        updateVoiture.setAnnee(voiture.getAnnee());
        updateVoiture.setEtat(voiture.getEtat());
        updateVoiture.setPhoto(voiture.getPhoto());
        updateVoiture.setPrix(voiture.getPrix());
*/
        voitureRepository.save(updateVoiture);

        return ResponseEntity.ok(updateVoiture);
    }
    
    @DeleteMapping("/employe/{id}")
	public void deleteVoiture(@PathVariable Long id) {
	    voitureRepository.deleteById(id);
	}

}