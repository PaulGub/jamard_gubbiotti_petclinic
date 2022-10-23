package org.springframework.samples.petclinic.repository.springdatajpa;

import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.Memo;
import org.springframework.samples.petclinic.repository.MemoRepository;

public interface SpringDataMemoRepository extends MemoRepository, Repository<Memo, Integer> {
}
