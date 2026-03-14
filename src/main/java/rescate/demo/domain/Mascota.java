/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rescate.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author mgonz
 */
@Data
@Entity
@Table(name="mascota")
public class Mascota implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_mascota")
    private Integer idMascota;

    @Column(nullable=false, length=50)
    @NotBlank
    private String nombre;

    @Column(length=50)
    private String especie;

    private Integer edad;

    private String raza;

    @Column(name="ruta_imagen", length=1024)
    private String rutaImagen;

    private boolean activo;
    
}
