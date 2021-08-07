package com.nadarzy.springpetclinic.services.map;

import com.nadarzy.springpetclinic.model.Owner;
import com.nadarzy.springpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
  @Override
  public Owner findByLastName(String lastName) {
    return null;
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
    return super.save(owner.getId(), owner);
  }
}
