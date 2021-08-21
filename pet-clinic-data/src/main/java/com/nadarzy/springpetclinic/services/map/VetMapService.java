package com.nadarzy.springpetclinic.services.map;

import com.nadarzy.springpetclinic.model.Specialty;
import com.nadarzy.springpetclinic.model.Vet;
import com.nadarzy.springpetclinic.services.SpecialtyService;
import com.nadarzy.springpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
  private final SpecialtyService specialtyService;

  public VetMapService(SpecialtyService specialtyService) {
    this.specialtyService = specialtyService;
  }

  @Override
  public Set<Vet> findAll() {
    return super.findAll();
  }

  @Override
  public Vet findById(Long id) {
    return super.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Vet t) {
    super.delete(t);
  }

  @Override
  public Vet save(Vet vet) {
    if (vet.getSpecialities().size() > 0) {
      vet.getSpecialities()
          .forEach(
              specialty -> {
                if (specialty.getId() == null) {
                  Specialty savedSpecialty = specialtyService.save(specialty);
                  specialty.setId(savedSpecialty.getId());
                }
              });
    }
    return super.save(vet);
  }
}
