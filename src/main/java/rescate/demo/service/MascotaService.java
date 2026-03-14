/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rescate.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import rescate.demo.domain.Mascota;
import rescate.demo.repository.MascotaRepository;

/**
 *
 * @author mgonz
 */
@Service
public class MascotaService {
    
    private final MascotaRepository mascotaRepository;
    private final FirebaseStorageService firebaseStorageService;

    public MascotaService(MascotaRepository mascotaRepository,
            FirebaseStorageService firebaseStorageService) {
        this.mascotaRepository = mascotaRepository;
        this.firebaseStorageService = firebaseStorageService;
    }

    @Transactional(readOnly = true)
    public List<Mascota> getMascotas(boolean activo) {

        if (activo) {
            return mascotaRepository.findByActivoTrue();
        }

        return mascotaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Mascota> getMascota(Integer idMascota) {
        return mascotaRepository.findById(idMascota);
    }

    @Transactional
    public void save(Mascota mascota, MultipartFile imagenFile) {

        mascota = mascotaRepository.save(mascota);

        if (!imagenFile.isEmpty()) {

            try {

                String rutaImagen = firebaseStorageService.uploadImage(
                        imagenFile,
                        "mascota",
                        mascota.getIdMascota());

                mascota.setRutaImagen(rutaImagen);
                mascotaRepository.save(mascota);

            } catch (IOException e) {

            }
        }
    }

    @Transactional
    public void delete(Integer idMascota) {

        if (!mascotaRepository.existsById(idMascota)) {
            throw new IllegalArgumentException("La mascota no existe");
        }

        try {

            mascotaRepository.deleteById(idMascota);

        } catch (DataIntegrityViolationException e) {

            throw new IllegalStateException("No se puede eliminar la mascota");

        }
    }
    
}
