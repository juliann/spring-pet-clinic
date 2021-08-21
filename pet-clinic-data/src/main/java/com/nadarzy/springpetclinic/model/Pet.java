package com.nadarzy.springpetclinic.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pet extends BaseEntity {
  private String name;

  @Column(name = "birth_date")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthDate;

  @ManyToOne
  @JoinColumn(name = "type_id")
  private PetType petType;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Owner owner;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
  private Set<Visit> visits = new HashSet<>();

  @Builder
  public Pet(
      Long id, String name, LocalDate birthDate, PetType petType, Owner owner, Set<Visit> visits) {
    super(id);
    this.name = name;
    this.birthDate = birthDate;
    this.petType = petType;
    this.owner = owner;
    if (visits == null || visits.size() > 0) this.visits = visits;
  }
}
