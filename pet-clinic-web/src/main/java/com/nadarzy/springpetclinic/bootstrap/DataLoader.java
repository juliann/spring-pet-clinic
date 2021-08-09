package com.nadarzy.springpetclinic.bootstrap;

import com.nadarzy.springpetclinic.model.*;
import com.nadarzy.springpetclinic.services.OwnerService;
import com.nadarzy.springpetclinic.services.PetTypeService;
import com.nadarzy.springpetclinic.services.SpecialtyService;
import com.nadarzy.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialtyService specialtyService;

  public DataLoader(
      OwnerService ownerService,
      VetService vetService,
      PetTypeService petTypeService,
      SpecialtyService specialtyService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;

    this.specialtyService = specialtyService;
  }

  @Override
  public void run(String... args) throws Exception {
    int count = petTypeService.findAll().size();
    if(count==0){loadData();}



  }

  private void loadData() {
    PetType dog = new PetType();
    dog.setName("Dog");

    PetType savedDogType = petTypeService.save(dog);

    PetType cat = new PetType();
    cat.setName("Cat");

    PetType savedCatType = petTypeService.save(cat);

    Specialty radiology = new Specialty();
    radiology.setDescription("Radiology");

    Specialty surgery = new Specialty();
    surgery.setDescription("Surgery");

    Specialty dentistry = new Specialty();
    dentistry.setDescription("Dentistry");

    Specialty savedRadiology = specialtyService.save(radiology);
    Specialty savedSurgery = specialtyService.save(surgery);
    Specialty savedDentistry = specialtyService.save(dentistry);

    Owner owner1 = new Owner();

    owner1.setFirstName("John");
    owner1.setLastname("Doe");
    owner1.setAddress("123 Mainstreet");
    owner1.setCity("New York");
    owner1.setTelephone("123-456-789");

    Pet johnsPet = new Pet();
    johnsPet.setName("fluffy");
    johnsPet.setPetType(savedDogType);
    johnsPet.setBirthDate(LocalDate.now());
    johnsPet.setOwner(owner1);
    owner1.getPets().add(johnsPet);

    ownerService.save(owner1);

    Owner owner2 = new Owner();

    owner2.setFirstName("Erica");
    owner2.setLastname("Musterfrau");
    owner2.setAddress("Hauptstraße 32b");
    owner2.setCity("Berlin");
    owner2.setTelephone("+49-173-456-789");

    Pet eriasCat = new Pet();
    eriasCat.setName("Mauzi");
    eriasCat.setBirthDate(LocalDate.now());
    eriasCat.setPetType(savedCatType);
    eriasCat.setOwner(owner2);
    owner2.getPets().add(eriasCat);

    ownerService.save(owner2);

    System.out.println("loaded Onwers");

    Vet vet1 = new Vet();

    vet1.setFirstName("Sam");
    vet1.setLastname("Sammington");
    vet1.getSpecialties().add(savedRadiology);

    vetService.save(vet1);

    Vet vet2 = new Vet();

    vet2.setFirstName("Mr");
    vet2.setLastname("Dr");
    vet2.getSpecialties().add(savedRadiology);
    vet2.getSpecialties().add(savedSurgery);

    vetService.save(vet2);

    System.out.println("loaded Vets");
  }
}
