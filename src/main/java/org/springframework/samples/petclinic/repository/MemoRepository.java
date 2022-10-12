package org.springframework.samples.petclinic.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Memo;

import java.util.List;

/**
 * Repository class for <code>Memo</code> domain objects
 */
public interface MemoRepository {
    /**
     * Save a <code>Memo</code> to the data store, either inserting or updating it. * * @param memo the <code>Memo</code> to save * @see BaseEntity#isNew
     */
    void save(Memo memo) throws DataAccessException;

    /**
     * Retrieves a list of <code>Memo</code> associated to a vet * * @param vetId the <code>Vet</code> identifier * @return List  of <code>Memo</code>
     */
    List<Memo> findByVetId(Integer vetId);
}
