package com.esprit.jammazimedkhalil.services;

import com.esprit.jammazimedkhalil.entites.Formateur;
import com.esprit.jammazimedkhalil.repositories.FormateurRepository;
import com.esprit.jammazimedkhalil.services.interfaces.IFormateur;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Service
@Slf4j
public class FormateurServiceImp implements IFormateur {
FormateurRepository formateurRepository;


    @Override
    public void ajouterFormateur(Formateur formateur) {
        formateurRepository.save(formateur);
    }

    @Override
    public Integer getFormateurRemunerationByDate(Integer idFormateur, Date datedebut, Date datefin) {
        AtomicInteger revenu = new AtomicInteger();
        formateurRepository.findById(idFormateur).ifPresent(formateur -> {
            log.info("Le formateur {} a été trouvé", formateur.getNom());
            // Nbr Heures de la formation * taux horaire
            formateur.getFormations().forEach(formation -> {
                log.info("La formation {} a été trouvée", formation.getTitle());
                int remuneration = formation.getNbHeures() * formateur.getTarifHoraire();
                log.info("Le formateur {} a été rémunéré", remuneration);
                revenu.addAndGet(remuneration);
            });
        });

        return revenu.get();
    }

}