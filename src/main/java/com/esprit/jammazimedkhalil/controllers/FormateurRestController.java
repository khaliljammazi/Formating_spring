package com.esprit.jammazimedkhalil.controllers;

import com.esprit.jammazimedkhalil.entites.Formateur;
import com.esprit.jammazimedkhalil.services.interfaces.IFormateur;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping("/formateur")
public class FormateurRestController {
    IFormateur formateurService;

    //add formateur
    @PostMapping("/add")
    public void ajouterFormateur(@RequestBody Formateur formateur) {
        formateurService.ajouterFormateur(formateur);
    }

    @GetMapping("/getFormateurRemunerationByDate/{idFormateur}/{datedebut}/{datefin}")
    public Integer getFormateurRemunerationByDate(@PathVariable("idFormateur") Integer idFormateur,
                                                  @PathVariable("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
                                                  @PathVariable("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        return formateurService.getFormateurRemunerationByDate(idFormateur, dateDebut, dateFin);
    }


}
