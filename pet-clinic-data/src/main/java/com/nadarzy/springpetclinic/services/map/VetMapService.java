package com.nadarzy.springpetclinic.services.map;

import com.nadarzy.springpetclinic.model.Vet;
import com.nadarzy.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
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
    return super.save(vet.getId(), vet);
  }
}
