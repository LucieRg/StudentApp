package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private int numeroClasse;
    private LocalDate dateDiplome;
}
