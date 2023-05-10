package com.esprit.jammazimedkhalil.services;

import com.esprit.jammazimedkhalil.entites.Formation;
import com.esprit.jammazimedkhalil.repositories.FormateurRepository;
import com.esprit.jammazimedkhalil.repositories.FormationRepository;
import com.esprit.jammazimedkhalil.services.interfaces.IFormation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class FormationServiceImp implements IFormation {
    FormationRepository formationRepository;
    FormateurRepository formateurRepository;
    @Override
    public void ajouterEtAffecterFormationAFormateur(Formation formation, Integer idFormateur) {
        formateurRepository.findById(idFormateur).ifPresent(formateur -> {
            formation.setFormateur(formateur);
            formationRepository.save(formation);
        });

    }

    @Override
    public Integer getRevenuByFormation(Integer idFormation) {
        Formation formation = formationRepository.findById(idFormation).get();
        return formation.getApprenants().size() * formation.getFrais();
    }
}