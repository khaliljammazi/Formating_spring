package com.esprit.jammazimedkhalil.services.interfaces;

import com.esprit.jammazimedkhalil.entites.Formateur;

import java.util.Date;

public interface IFormateur {
    void ajouterFormateur(Formateur formateur);
    Integer getFormateurRemunerationByDate(Integer idFormateur, Date datedebut, Date datefin);
}
