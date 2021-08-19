package com.nadarzy.springpetclinic.services.map;

import com.nadarzy.springpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

  OwnerMapService ownerMapService;
  final Long ownerId = 1L;
  final String lastName = "Smith";

  @BeforeEach
  void setUp() {
    ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
    ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
  }

  @Test
  void findByLastName() {
    Owner owner = ownerMapService.findByLastName(lastName);

    assertNotNull(owner);
    assertEquals(lastName, owner.getLastName());
  }

  @Test
  void findByLastNameFound() {
    Owner owner = ownerMapService.findByLastName("foo");

    assertNull(owner);
  }

  @Test
  void findAll() {
    Set<Owner> owners = ownerMapService.findAll();
    assertEquals(1, owners.size());
  }

  @Test
  void findById() {
    Owner owner = ownerMapService.findById(ownerId);
    assertEquals(ownerId, owner.getId());
  }

  @Test
  void deleteById() {
    ownerMapService.deleteById(ownerId);
  }

  @Test
  void delete() {
    ownerMapService.delete(ownerMapService.findById(ownerId));
    assertEquals(0, ownerMapService.findAll().size());
  }

  @Test
  void save() {
    long id = 2L;
    Owner owner2 = Owner.builder().id(id).build();
    Owner savedOwner = ownerMapService.save(owner2);

    assertEquals(id, savedOwner.getId());
  }

  @Test
  void saveNoId() {
    Owner owner3 = Owner.builder().build();
    Owner savedOwner = ownerMapService.save(owner3);

    assertNotNull(savedOwner);
    assertNotNull(savedOwner.getId());
  }
}
