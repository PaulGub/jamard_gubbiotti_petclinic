package org.springframework.samples.petclinic.repository;

import org.springframework.samples.petclinic.model.Operation;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Repository class for <code>Operation</code> domain objects
 */
public interface OperationRepository {
    /**
     * Save a <code>Operation</code> to the data store, either inserting or updating it. * * @param operation the <code>Operation</code> to save * @see BaseEntity#isNew
     */
    void save(Operation operation) throws DataAccessException;

    /**
     * Retrieves a list of <code>Operation</code> associated to a pet * * @param petId the <code>Pet</code> identifier * @return List of  <code>Operation</code>
     */
    List<Operation> findByPetId(Integer petId);

    /**
     * Retrieves a list of <code>Operation</code> associated to a vet * * @param vetId the <code>Vet</code> identifier * @return List of  <code>Operation</code>
     */
    List<Operation> findByVetId(Integer vetId);

}
