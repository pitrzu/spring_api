package com.pitrzuu.api.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Long>, JpaSpecificationExecutor<Location>{
    Optional<Location> findLocationById( Long id );


}
