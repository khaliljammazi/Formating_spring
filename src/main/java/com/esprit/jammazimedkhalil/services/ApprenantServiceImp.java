package com.esprit.jammazimedkhalil.services;

import com.esprit.jammazimedkhalil.entites.Apprenant;
import com.esprit.jammazimedkhalil.entites.Formation;
import com.esprit.jammazimedkhalil.repositories.ApprenantRepository;
import com.esprit.jammazimedkhalil.repositories.FormationRepository;
import com.esprit.jammazimedkhalil.services.interfaces.IApprenant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class ApprenantServiceImp implements IApprenant {
    ApprenantRepository apprenantRepository;
    FormationRepository formationRepository;

    @Override
    public void ajouterApprenant(Apprenant apprenant) {
        apprenantRepository.save(apprenant);
    }

    @Override
    public void affecterApprenantFormation(Integer idApprenant, Integer idFormation) {
    Formation f =formationRepository.findById(idFormation).get();
    Apprenant a =apprenantRepository.findById(idApprenant).get();

        if (f.getApprenants().size() < f.getNbrMaxParticipants()) {
           f.getApprenants().add(a);
            formationRepository.save(f);
        } else {
            log.info("Nombre max de participants atteint");
        }


    }
@Scheduled(fixedDelay = 30000)
    @Override
    public void getNbrApprenantByFormation() {
    log.info("Nombre d'apprenants par formation+++++++++++++++++++++++++++++++");
    formationRepository.findAll().forEach(f->log.info(f.getTitle()+" : "+f.getApprenants().size()));


}

}

