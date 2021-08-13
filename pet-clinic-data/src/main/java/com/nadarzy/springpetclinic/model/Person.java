package com.nadarzy.springpetclinic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

  public Person(Long id, String firstName, String lastname) {
    super(id);
    this.firstName = firstName;
    this.lastname = lastname;
  }

  public Person(String firstName, String lastname) {
    this.firstName = firstName;
    this.lastname = lastname;
  }

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastname;
}
