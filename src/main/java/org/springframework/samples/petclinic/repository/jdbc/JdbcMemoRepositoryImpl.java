package org.springframework.samples.petclinic.repository.jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Memo;
import org.springframework.samples.petclinic.repository.MemoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcMemoRepositoryImpl implements MemoRepository {

    @Override
    public void save(Memo memo) throws DataAccessException {

    }

    @Override
    public List<Memo> findByVetId(Integer vetId) {
        return null;
    }
}
