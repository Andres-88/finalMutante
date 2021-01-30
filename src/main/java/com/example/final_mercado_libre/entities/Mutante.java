package com.example.final_mercado_libre.entities;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "mutante")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
//@Builder
public class Mutante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dni")
    private int dni;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "dna")
    private String[]dna;

    //@Column(name = "mutant")
    //private boolean mutant = false;

    public Mutante(String nombre, String apellido, int dni){

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }


    //No me toma la función con Lombok en el main
        /* public boolean getMutant() {
        return mutant;
    }*/
}