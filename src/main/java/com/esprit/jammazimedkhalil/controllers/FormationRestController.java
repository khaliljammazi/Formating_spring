package com.esprit.jammazimedkhalil.controllers;

import com.esprit.jammazimedkhalil.entites.Formation;
import com.esprit.jammazimedkhalil.services.interfaces.IFormation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/formation")
public class FormationRestController {
    IFormation iFormation;

    @PostMapping("/ajouterEtAffecterFormationAFormateur/{idFormateur}")
    public void ajouterEtAffecterFormationAFormateur(@RequestBody Formation formation, @PathVariable Integer idFormateur){
        iFormation.ajouterEtAffecterFormationAFormateur(formation, idFormateur);
    }
@GetMapping("/getRevenuByFormation/{idFormation}")
    public Integer getRevenuByFormation(@PathVariable("idFormation") Integer idFormation){
        return iFormation.getRevenuByFormation(idFormation);
    }


}
