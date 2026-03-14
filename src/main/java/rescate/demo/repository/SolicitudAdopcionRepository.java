/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rescate.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rescate.demo.domain.SolicitudAdopcion;

/**
 *
 * @author mgonz
 */
@Repository
public interface SolicitudAdopcionRepository extends JpaRepository<SolicitudAdopcion, Integer>{
    
}
