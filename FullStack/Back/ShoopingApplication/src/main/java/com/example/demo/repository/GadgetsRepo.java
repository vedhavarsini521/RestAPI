package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Gadgets;


@Repository
public interface GadgetsRepo extends JpaRepository<Gadgets, Integer>{
	

}
