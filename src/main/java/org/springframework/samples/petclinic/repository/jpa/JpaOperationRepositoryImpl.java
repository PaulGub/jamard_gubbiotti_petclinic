package org.springframework.samples.petclinic.repository.jpa;

import jdk.dynalink.Operation;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.repository.OperationRepository;

import java.util.List;

public class JpaOperationRepositoryImpl implements OperationRepository {

    /**
     * Save a <code>Operation</code> to the data store, either inserting or updating it. * * @param operation the <code>Operation</code> to save * @see BaseEntity#isNew
     *
     * @param operation
     */
    @Override
    public void save(Operation operation) throws DataAccessException {

    }

    /**
     * Retrieves a list of <code>Operation</code> associated to a pet * * @param petId the <code>Pet</code> identifier * @return List of  <code>Operation</code>
     *
     * @param petId
     */
    @Override
    public List<Operation> findByPetId(Integer petId) {
        return null;
    }

    /**
     * Retrieves a list of <code>Operation</code> associated to a vet * * @param vetId the <code>Vet</code> identifier * @return List of  <code>Operation</code>
     *
     * @param vetId
     */
    @Override
    public List<Operation> findByVetId(Integer vetId) {
        return null;
    }
}
