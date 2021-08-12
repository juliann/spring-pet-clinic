package com.nadarzy.springpetclinic.services.map;

import com.nadarzy.springpetclinic.model.Visit;
import com.nadarzy.springpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
  @Override
  public Set<Visit> findAll() {
    return super.findAll();
  }

  @Override
  public Visit findById(Long id) {
    return super.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Visit t) {
    super.delete(t);
  }

  @Override
  public Visit save(Visit t) {
    if (t.getPet() == null || t.getPet().getOwner() == null || t.getPet().getId() == null) {
      throw new RuntimeException("invalid visit");
    }
    return super.save(t);
  }
}
