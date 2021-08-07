package com.nadarzy.springpetclinic.bootstrap;

import com.nadarzy.springpetclinic.model.Owner;
import com.nadarzy.springpetclinic.model.Vet;
import com.nadarzy.springpetclinic.services.OwnerService;
import com.nadarzy.springpetclinic.services.VetService;
import com.nadarzy.springpetclinic.services.map.OwnerMapService;
import com.nadarzy.springpetclinic.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;

  @Override
  public void run(String... args) throws Exception {

    Owner owner1 = new Owner();
    owner1.setId(1L);
    owner1.setFirstName("John");
    owner1.setLastname("Doe");
    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setId(2L);
    owner2.setFirstName("Erica");
    owner2.setLastname("Musterfrau");
    ownerService.save(owner2);

    System.out.println("loaded Onwers");

    Vet vet1 = new Vet();
    vet1.setId(1L);
    vet1.setFirstName("Sam");
    vet1.setLastname("Sammington");
    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setId(2L);
    vet2.setFirstName("Mr");
    vet2.setLastname("Dr");
    vetService.save(vet2);

    System.out.println("loaded Vets");
  }

  public DataLoader() {
    ownerService = new OwnerMapService();
    vetService = new VetMapService();
  }
}
