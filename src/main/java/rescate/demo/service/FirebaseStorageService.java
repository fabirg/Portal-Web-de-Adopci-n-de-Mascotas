/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rescate.demo.service;

import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author mgonz
 */
@Service
public class FirebaseStorageService {
    
    // Método simulado para evitar errores
    public String uploadImage(MultipartFile localFile, String folder, Integer id) throws IOException {

        String nombreArchivo = localFile.getOriginalFilename();

        // Simula la ruta donde estaría la imagen
        String rutaImagen = "/images/" + folder + "/" + id + "_" + nombreArchivo;

        return rutaImagen;
    }
    
}
