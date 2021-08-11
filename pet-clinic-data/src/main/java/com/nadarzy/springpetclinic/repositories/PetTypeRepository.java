package com.nadarzy.springpetclinic.repositories;

import com.nadarzy.springpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {}
