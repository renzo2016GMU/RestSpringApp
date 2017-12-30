package org.demo.demo.person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Collection<Person> findByPersonName(String name);
}
