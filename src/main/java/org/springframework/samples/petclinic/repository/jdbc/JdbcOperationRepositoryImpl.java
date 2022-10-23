package org.springframework.samples.petclinic.repository.jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Operation;
import org.springframework.samples.petclinic.repository.OperationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcOperationRepositoryImpl implements OperationRepository {

    @Override
    public void save(Operation operation) throws DataAccessException {

    }

    @Override
    public List<Operation> findByPetId(Integer petId) {
        return null;
    }

    @Override
    public List<Operation> findByVetId(Integer vetId) {
        return null;
    }
}
