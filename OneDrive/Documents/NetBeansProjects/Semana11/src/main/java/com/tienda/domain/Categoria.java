package com.tienda.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.validation.constraints.NotNull;
import jakarta.persistence.validation.constraints.Size;
import.io.Serializable;
import lombok.Data;
      
@Data
@Entity
@Table (name = "categoria")
public class Categoria implements Serializable {
    // Se recomienda añadir un serialVersionUID
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_categoria")
    private Integer idCategoria;
    
    @Column (unique = true, nullable = false, lenght = 50)
    @NotNull
    @Size (max = 50)
    private String descripcion;
    
    @Column (lenght = 1024)
    @Size (max = 1024)
    private String rutaImagen;
    
    @Column (name = "activo")
    private Boolean activo;
}
