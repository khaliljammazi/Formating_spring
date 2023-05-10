package com.esprit.jammazimedkhalil.services.interfaces;

import com.esprit.jammazimedkhalil.entites.Apprenant;

public interface IApprenant {
    void ajouterApprenant (Apprenant apprenant);
    void affecterApprenantFormation (Integer idApprenant, Integer idFormation);
     void getNbrApprenantByFormation ();
}
