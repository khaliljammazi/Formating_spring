package com.esprit.jammazimedkhalil.controllers;

import com.esprit.jammazimedkhalil.entites.Apprenant;
import com.esprit.jammazimedkhalil.services.interfaces.IApprenant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/apprenant")
public class ApprenantRestController {
    IApprenant apprenantService;


    @PostMapping("/add")
    public void ajouterApprenant(@RequestBody Apprenant apprenant) {
        apprenantService.ajouterApprenant(apprenant);
    }

    @PostMapping("/affecter/{idApprenant}/{idFormation}")
    public void affecterApprenantFormation(@PathVariable ("idApprenant") Integer idApprenant,
                                           @PathVariable ("idFormation") Integer idFormation)
    {
        apprenantService.affecterApprenantFormation(idApprenant, idFormation);
    }
}