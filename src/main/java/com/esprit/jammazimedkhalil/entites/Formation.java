package com.esprit.jammazimedkhalil.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Formation  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFormation", nullable = false)
    private Integer idFormation;
    private String title;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    private Date dateDebut;
    private Date dateFin;
    private Integer nbHeures;
    private Integer nbrMaxParticipants;
    private Integer frais;
    @ManyToOne
    private Formateur formateur;

    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Apprenant> apprenants;




}
