package com.SmartHome.SpringProject.service;


import com.SmartHome.SpringProject.model.Appareil;
import com.SmartHome.SpringProject.repository.AppareilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppareilService {

    @Autowired
    private final AppareilRepo appareilRepo;

    public AppareilService(AppareilRepo appareilRepo) {
        this.appareilRepo = appareilRepo;
    }

    //we get a list of them as a return
    public List<Appareil> getAllAppareils(){
        return appareilRepo.findAll();
    }
    //it can be found or not, for that we use Optional & the return type is <Appareil>
    public Optional<Appareil> getAppareilByID(Long id){
        return appareilRepo.findById(id);
    }


    //save one, we'll get an App in return
    public Appareil saveAppareil(Appareil appareil){
        return appareilRepo.save(appareil);
    }

    //delete one, we get nothing back so the return type is void
    public void deleteAppareilById(Long id){
        appareilRepo.deleteById(id);
    }

    //Update an appareil, so we get an appareil as a return, we give the id of the appareil we want to update and the new appareil
    public Appareil updateAppareil(Long id, Appareil appareil){
        if(appareilRepo.existsById(id)){
            appareil.setId(id);
            return appareilRepo.save(appareil);
        }
        return null;

    }



}
