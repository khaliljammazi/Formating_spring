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
public class Apprenant  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idApprenant",  nullable = false)
    private Integer idApprenant;
    private String nom;
    private String prenom;
    private Integer telephone;
    private String email;

    @ManyToMany(mappedBy = "apprenants",cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Formation> formations;
}
