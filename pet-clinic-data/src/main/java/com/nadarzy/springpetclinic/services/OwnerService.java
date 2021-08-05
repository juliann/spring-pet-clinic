package com.nadarzy.springpetclinic.services;

import com.nadarzy.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

  Owner findByLastName(String lastName);
}
