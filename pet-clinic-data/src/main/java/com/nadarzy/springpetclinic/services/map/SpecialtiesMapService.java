package com.nadarzy.springpetclinic.services.map;

import com.nadarzy.springpetclinic.model.Specialty;
import com.nadarzy.springpetclinic.services.SpecialtiesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtiesMapService extends AbstractMapService<Specialty, Long>
    implements SpecialtiesService {
  @Override
  public Set<Specialty> findAll() {
    return super.findAll();
  }

  @Override
  public Specialty findById(Long id) {
    return findById(id);
  }

  @Override
  public Specialty save(Specialty t) {
    return super.save(t);
  }

  @Override
  public void delete(Specialty t) {
    super.delete(t);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }
}
