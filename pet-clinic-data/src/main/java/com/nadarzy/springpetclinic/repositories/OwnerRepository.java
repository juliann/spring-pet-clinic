package com.nadarzy.springpetclinic.repositories;

import com.nadarzy.springpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

  Owner findByLastname(String lastName);
}
