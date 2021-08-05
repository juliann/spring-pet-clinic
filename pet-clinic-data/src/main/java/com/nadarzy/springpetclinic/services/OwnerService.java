package com.nadarzy.springpetclinic.services;

import com.nadarzy.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(long id);

    Owner findByLastName(String lastName);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
