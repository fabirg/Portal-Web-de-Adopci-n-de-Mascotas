/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rescate.demo.controller;

import org.springframework.ui.Model;
import jakarta.validation.Valid;
import java.util.Locale;
import java.util.Optional;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rescate.demo.domain.Mascota;
import rescate.demo.service.MascotaService;

/**
 *
 * @author mgonz
 */
@Controller
@RequestMapping("/mascota")
public class MascotaController {
    
    private final MascotaService mascotaService;
    private final MessageSource messageSource;

    public MascotaController(MascotaService mascotaService,
            MessageSource messageSource) {
        this.mascotaService = mascotaService;
        this.messageSource = messageSource;
    }

    @GetMapping("/listado")
    public String listado(Model model) {

        var mascotas = mascotaService.getMascotas(false);

        model.addAttribute("mascotas", mascotas);
        model.addAttribute("totalMascotas", mascotas.size());

        return "/mascota/listado";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Mascota mascota,
            @RequestParam MultipartFile imagenFile,
            RedirectAttributes redirectAttributes) {

        mascotaService.save(mascota, imagenFile);

        redirectAttributes.addFlashAttribute(
                "todoOk",
                messageSource.getMessage("mensaje.actualizado",
                        null,
                        Locale.getDefault()));

        return "redirect:/mascota/listado";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer idMascota,
            RedirectAttributes redirectAttributes) {

        mascotaService.delete(idMascota);

        redirectAttributes.addFlashAttribute(
                "todoOk",
                messageSource.getMessage("mensaje.eliminado",
                        null,
                        Locale.getDefault()));

        return "redirect:/mascota/listado";
    }

    @GetMapping("/modificar/{idMascota}")
    public String modificar(@PathVariable Integer idMascota,
            Model model,
            RedirectAttributes redirectAttributes) {

        Optional<Mascota> mascotaOpt = mascotaService.getMascota(idMascota);

        if (mascotaOpt.isEmpty()) {

            redirectAttributes.addFlashAttribute(
                    "error",
                    "Mascota no encontrada");

            return "redirect:/mascota/listado";
        }

        model.addAttribute("mascota", mascotaOpt.get());

        return "/mascota/modifica";
    }
    
}
