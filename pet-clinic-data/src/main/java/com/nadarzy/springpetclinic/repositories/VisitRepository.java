package com.nadarzy.springpetclinic.repositories;

import com.nadarzy.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {}
