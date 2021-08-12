package com.nadarzy.springpetclinic.services.springdatajpa;

import com.nadarzy.springpetclinic.model.Specialty;
import com.nadarzy.springpetclinic.repositories.SpecialtyRepository;
import com.nadarzy.springpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpoa")
public class VetSpecialtiesSDJpaService implements SpecialtyService {

  private final SpecialtyRepository specialtyRepository;

  public VetSpecialtiesSDJpaService(SpecialtyRepository specialtyRepository) {
    this.specialtyRepository = specialtyRepository;
  }

  @Override
  public Set<Specialty> findAll() {
    Set<Specialty> specialties = new HashSet<>();
    specialtyRepository.findAll().forEach(specialties::add);
    return specialties;
  }

  @Override
  public Specialty findById(Long id) {
    return specialtyRepository.findById(id).orElse(null);
  }

  @Override
  public Specialty save(Specialty specialty) {
    return specialtyRepository.save(specialty);
  }

  @Override
  public void delete(Specialty specialty) {
    specialtyRepository.delete(specialty);
  }

  @Override
  public void deleteById(Long id) {
    specialtyRepository.deleteById(id);
  }
}
