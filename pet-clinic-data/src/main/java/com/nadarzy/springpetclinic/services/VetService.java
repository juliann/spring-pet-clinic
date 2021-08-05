package com.nadarzy.springpetclinic.services;

import com.nadarzy.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

  Vet findById(long id);

  Vet save(Vet vet);

  Set<Vet> findAll();
}