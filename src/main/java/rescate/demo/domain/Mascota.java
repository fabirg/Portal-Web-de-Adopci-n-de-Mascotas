/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// ... (imports anteriores)
import jakarta.validation.constraints.NotNull;

@Data
@Entity
@Table(name="mascota")
public class Mascota implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_mascota")
    private Integer idMascota;

    @NotBlank
    @Column(nullable=false, length=50)
    private String nombre;

    @NotBlank 
    private String especie; 

    @NotNull
    private Integer edad;

    private String raza; 

    private String sexo; 

    private String tamano; 

    private String descripcion; 

    @Column(name="ruta_imagen", length=1024)
    private String rutaImagen;

    private boolean activo;
}
