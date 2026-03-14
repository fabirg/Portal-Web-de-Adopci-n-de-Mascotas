/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rescate.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rescate.demo.domain.SolicitudAdopcion;
import rescate.demo.service.SolicitudAdopcionService;

/**
 *
 * @author mgonz
 */
@Controller
@RequestMapping("/solicitud")
public class SolicitudAdopcionController {
    
    private final SolicitudAdopcionService solicitudService;

    public SolicitudAdopcionController(SolicitudAdopcionService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @GetMapping("/listado")
    public String listado(Model model){

        var solicitudes = solicitudService.getSolicitudes();

        model.addAttribute("solicitudes", solicitudes);

        return "/solicitud/listado";
    }

    @PostMapping("/guardar")
    public String guardar(SolicitudAdopcion solicitud){

        solicitudService.save(solicitud);

        return "redirect:/solicitud/listado";
    }
    
}
