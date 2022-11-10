package com.pitrzuu.api.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IPersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person>{}
