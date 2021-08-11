package com.nadarzy.springpetclinic.repositories;

import com.nadarzy.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {}
