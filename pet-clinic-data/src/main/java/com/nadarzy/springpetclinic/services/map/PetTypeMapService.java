package com.nadarzy.springpetclinic.services.map;

import com.nadarzy.springpetclinic.model.PetType;
import com.nadarzy.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
  @Override
  public Set<PetType> findAll() {
    return super.findAll();
  }

  @Override
  public PetType findById(Long id) {
    return super.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(PetType t) {
    super.delete(t);
  }

  @Override
  public PetType save(PetType t) {
    return super.save(t);
  }
}
