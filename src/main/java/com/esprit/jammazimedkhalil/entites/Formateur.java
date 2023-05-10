package com.esprit.jammazimedkhalil.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Formateur  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFormateur", nullable = false)
    private Integer idFormateur;
    private String nom;
    private String prenom;
    private Integer tarifHoraire;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "formateur",cascade = CascadeType.ALL)
    private List<Formation> formations;



}
