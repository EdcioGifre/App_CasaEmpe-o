package com.example.mvcAPP.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class ProductoEmpeno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;

    private String nombre;
    private float precio;
    private Date fechaEmpeno;
    private Date fechaFinalEmpen;
}