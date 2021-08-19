package com.nadarzy.springpetclinic.services.map;

import com.nadarzy.springpetclinic.model.Owner;
import com.nadarzy.springpetclinic.model.Pet;
import com.nadarzy.springpetclinic.services.OwnerService;
import com.nadarzy.springpetclinic.services.PetService;
import com.nadarzy.springpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

  private final PetTypeService petTypeService;
  private final PetService petService;

  public OwnerMapService(PetTypeService petTypeService, PetService petService) {
    this.petTypeService = petTypeService;
    this.petService = petService;
  }

  @Override
  public Owner findByLastName(String lastName) {
    return findAll().stream()
        .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
        .findFirst()
        .orElse(null);
  }

  @Override
  public Set<Owner> findAll() {
    return super.findAll();
  }

  @Override
  public Owner findById(Long id) {
    return super.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Owner t) {
    super.delete(t);
  }

  @Override
  public Owner save(Owner owner) {
    Owner savedOwner = null;
    if (owner != null) {
      if (owner.getPets() != null) {
        owner
            .getPets()
            .forEach(
                pet -> {
                  if (pet.getPetType() != null) {
                    if (pet.getPetType().getId() == null) {
                      pet.setPetType(petTypeService.save(pet.getPetType()));
                    }
                  } else {
                    throw new RuntimeException("Pet requires to be of a specific Type");
                  }
                  if (pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                  }
                });
      }
      return super.save(owner);
    } else {
      return null;
    }
  }
}
