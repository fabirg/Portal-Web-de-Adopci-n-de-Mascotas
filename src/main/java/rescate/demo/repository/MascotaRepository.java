/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rescate.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rescate.demo.domain.Mascota;

/**
 *
 * @author mgonz
 */
@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer>{

    public List<Mascota> findByActivoTrue();
    
}
