package org.springframework.samples.petclinic.repository.jpa;

import org.springframework.samples.petclinic.model.Operation;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.repository.OperationRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JpaOperationRepositoryImpl implements OperationRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Operation operation) throws DataAccessException {
        if(operation.getId() == null){
            this.em.persist(operation);
        }
        else {
            this.em.merge(operation);
        }
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<Operation> findByPetId(Integer petId) {
        Query query = this.em.createQuery("SELECT o FROM Operation o where o.pet.id= :id");
        query.setParameter("id", petId);
        return query.getResultList();
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<Operation> findByVetId(Integer vetId) {
        Query query = this.em.createQuery("SELECT o FROM Operation o where o.vet.id= :id");
        query.setParameter("id", vetId);
        return query.getResultList();
    }
}
