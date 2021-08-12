package com.nadarzy.springpetclinic.services.springdatajpa;

import com.nadarzy.springpetclinic.model.Owner;
import com.nadarzy.springpetclinic.repositories.OwnerRepository;
import com.nadarzy.springpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

  private OwnerRepository ownerRepository;

  public OwnerSDJpaService(OwnerRepository ownerRepository) {
    this.ownerRepository = ownerRepository;
  }

  @Override
  public Set<Owner> findAll() {
    Set<Owner> owners = new HashSet<>();
    ownerRepository.findAll().forEach(owners::add);
    return owners;
  }

  @Override
  public Owner findById(Long id) {
    return ownerRepository.findById(id).orElse(null);
  }

  @Override
  public Owner save(Owner owner) {
    return ownerRepository.save(owner);
  }

  @Override
  public void delete(Owner owner) {
    ownerRepository.delete(owner);
  }

  @Override
  public void deleteById(Long id) {
    ownerRepository.deleteById(id);
  }

  @Override
  public Owner findByLastName(String lastName) {
    return ownerRepository.findByLastname(lastName);
  }
}
