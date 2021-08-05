package com.nadarzy.springpetclinic.services;

import com.nadarzy.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(long id);


    Pet save(Pet pet);

    Set<Pet> findAll();
}
