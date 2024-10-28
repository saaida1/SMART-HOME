package com.SmartHome.SpringProject.repository;


import com.SmartHome.SpringProject.model.Appareil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppareilRepo  extends JpaRepository<Appareil, Long> {

}
