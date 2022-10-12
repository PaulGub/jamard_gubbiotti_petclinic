package org.springframework.samples.petclinic.repository.jpa;

import org.springframework.samples.petclinic.model.Memo;
import org.springframework.samples.petclinic.repository.MemoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * JPA implementation of the {@link MemoRepository} interface.
 * 6
 */
@Repository
public class JpaMemoRepositoryImpl implements MemoRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(final Memo memo) {
        if (memo.getId() == null) {
            this.em.persist(memo);
        } else {
            this.em.merge(memo);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Memo> findByVetId(final Integer vetId) {
        Query query = this.em.createQuery("SELECT m FROM Memo m where m.vet.id= :id");
        query.setParameter("id", vetId);
        return query.getResultList();
    }
}
