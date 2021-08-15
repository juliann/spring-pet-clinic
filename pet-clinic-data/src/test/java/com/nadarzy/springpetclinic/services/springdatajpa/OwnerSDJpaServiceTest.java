package com.nadarzy.springpetclinic.services.springdatajpa;

import com.nadarzy.springpetclinic.model.Owner;
import com.nadarzy.springpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class OwnerSDJpaServiceTest {

  final String lastName = "Smith";

  Owner returnOwner;

  @Mock OwnerRepository ownerRepository;
  @InjectMocks OwnerSDJpaService service;

  @BeforeEach
  void setUp() {
    returnOwner = Owner.builder().id(1L).lastname(lastName).build();
  }

  @Test
  void findAll() {
    Set<Owner> ownerSet = new HashSet<>();
    ownerSet.add(returnOwner);
    ownerSet.add(Owner.builder().id(2L).lastname("lastName").build());
    when(ownerRepository.findAll()).thenReturn(ownerSet);
    Set<Owner> owners = service.findAll();
    assertNotNull(owners);
    assertEquals(2, owners.size());
  }

  @Test
  void findById() {
    when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));

    Owner owner = service.findById(1L);
    assertNotNull(owner);
  }

  @Test
  void findByIdNotFound() {
    when(ownerRepository.findById(any())).thenReturn(Optional.empty());

    Owner owner = service.findById(1L);
    assertNull(owner);
  }

  @Test
  void save() {
    Owner owner = Owner.builder().id(1L).lastname("lastName").build();
    when(ownerRepository.save(any())).thenReturn(returnOwner);
    Owner savedOwner = service.save(owner);
    assertNotNull(savedOwner);
    verify(ownerRepository).save(any());
  }

  @Test
  void delete() {
    service.delete(returnOwner);
    verify(ownerRepository).delete(any());
  }

  @Test
  void deleteById() {
    service.deleteById(1L);
    verify(ownerRepository).deleteById(anyLong());
  }

  @Test
  void findByLastName() {

    when(ownerRepository.findByLastname(any())).thenReturn(returnOwner);

    Owner smith = service.findByLastName(lastName);
    assertEquals(lastName, smith.getLastname());
    verify(ownerRepository).findByLastname(any());
  }
}
