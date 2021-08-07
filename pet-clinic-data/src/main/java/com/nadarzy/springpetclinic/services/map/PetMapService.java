package com.nadarzy.springpetclinic.services.map;

import com.nadarzy.springpetclinic.model.Pet;
import com.nadarzy.springpetclinic.services.PetService;

import java.util.Set;

public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
  @Override
  public Set<Pet> findAll() {
    return super.findAll();
  }

  @Override
  public Pet findById(Long id) {
    return super.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Pet t) {
    super.delete(t);
  }

  @Override
  public Pet save(Pet pet) {
    return super.save(pet.getId(), pet);
  }
}
