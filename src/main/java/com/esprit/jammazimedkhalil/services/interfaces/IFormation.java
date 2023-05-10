package com.esprit.jammazimedkhalil.services.interfaces;

import com.esprit.jammazimedkhalil.entites.Formation;

public interface IFormation {
    void ajouterEtAffecterFormationAFormateur (Formation formation, Integer idFormateur);
     Integer getRevenuByFormation(Integer idFormation);
}
