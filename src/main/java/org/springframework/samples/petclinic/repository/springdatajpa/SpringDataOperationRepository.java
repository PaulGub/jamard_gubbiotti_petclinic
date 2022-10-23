package org.springframework.samples.petclinic.repository.springdatajpa;

import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.Operation;
import org.springframework.samples.petclinic.repository.OperationRepository;

public interface SpringDataOperationRepository extends OperationRepository, Repository<Operation, Integer> {
}
