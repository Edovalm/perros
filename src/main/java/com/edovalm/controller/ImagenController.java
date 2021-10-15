package com.edovalm.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edovalm.model.entity.Imagen;
import com.edovalm.repository.ImagenRepository;

@Controller
public class ImagenController {
    @Autowired
    private ImagenRepository imagenRepository;
    
    @GetMapping("/api/imagenes")
    public String form(Model model) {
        model.addAttribute("imagenes", new Imagen());
        return"form";
    }
    
    @PostMapping("/api/imagenes")
    public String guardar(@RequestParam(name = "file", required = false) MultipartFile archivo_imagen, Imagen imagen,
            RedirectAttributes flash) {
        
        if(!archivo_imagen.isEmpty()) {
        	String ruta = "C://Temp";
            
            try {
                byte[] bytes = archivo_imagen.getBytes();
                Path rutaAbsoluta = Paths.get(ruta + "//" + archivo_imagen.getOriginalFilename());
                Files.write(rutaAbsoluta, bytes);
                imagen.setArchivo_imagen(archivo_imagen.getOriginalFilename());
                    
            }catch (Exception e) {
                // TODO: handle exception
            }
            
            imagenRepository.save(imagen);
            flash.addFlashAttribute("success", "Imagen Subida con Éxito");
        }
        
        return "redirect:/api/imagenes";
    }
    
    @GetMapping("/api/imagenes/listar")
    public String listar(Model model) {
        model.addAttribute("imagenes", imagenRepository.findAll());
        return "listar";
    }
}