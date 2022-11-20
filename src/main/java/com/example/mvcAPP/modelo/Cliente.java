package com.example.mvcAPP.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Cliente  implements Serializable {

    @Id
    private Long cedula;

    private String nombre;
    private String apellido;
    private Long telefono;
}