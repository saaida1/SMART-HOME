package com.SmartHome.SpringProject.controller;


import com.SmartHome.SpringProject.model.Appareil;
import com.SmartHome.SpringProject.service.AppareilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appareils")
public class AppareilController {

    public AppareilController(AppareilService appareilService) {
        this.appareilService = appareilService;
    }

    @Autowired
    private final AppareilService appareilService;


    @GetMapping
    public List<Appareil> getAllAppareils(){
        return appareilService.getAllAppareils();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appareil> getAppareilById(@PathVariable Long id) {
        return appareilService.getAppareilByID(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Appareil saveAppareil(@RequestBody Appareil appareil){
        return  appareilService.saveAppareil(appareil);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appareil> updateAppareil(@PathVariable Long id, @RequestBody Appareil appareil){
        Appareil updatedAppareil = appareilService.updateAppareil(id, appareil);
        return updatedAppareil != null ? ResponseEntity.ok(updatedAppareil) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppareil(@PathVariable Long id) {
        appareilService.deleteAppareilById(id);
        return ResponseEntity.ok().build();
    }






}
