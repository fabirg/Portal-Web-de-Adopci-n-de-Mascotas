/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rescate.demo.service;


import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rescate.demo.domain.SolicitudAdopcion;
import rescate.demo.repository.SolicitudAdopcionRepository;

/**
 *
 * @author mgonz
 */
@Service
public class SolicitudAdopcionService {
    
    private final SolicitudAdopcionRepository solicitudRepository;

    public SolicitudAdopcionService(SolicitudAdopcionRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    @Transactional(readOnly = true)
    public List<SolicitudAdopcion> getSolicitudes() {
        return solicitudRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<SolicitudAdopcion> getSolicitud(Integer idSolicitud) {
        return solicitudRepository.findById(idSolicitud);
    }

    @Transactional
    public void save(SolicitudAdopcion solicitud) {
        solicitudRepository.save(solicitud);
    }

    @Transactional
    public void delete(Integer idSolicitud) {
        solicitudRepository.deleteById(idSolicitud);
    }
    
}
