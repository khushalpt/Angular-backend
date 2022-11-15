package net.javatest.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javatest.springboot.model.Registry;

@Repository
public interface RegistryRepository extends JpaRepository<Registry, Long>{

}