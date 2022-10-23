package org.springframework.samples.petclinic.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.samples.petclinic.model.Memo;
import org.springframework.samples.petclinic.repository.MemoRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcMemoRepositoryImpl implements MemoRepository {

    private SimpleJdbcInsert insertMemo;

    @Autowired
    public JdbcMemoRepositoryImpl(DataSource dataSource) {
        this.insertMemo = new SimpleJdbcInsert(dataSource).withTableName("memos").usingGeneratedKeyColumns("id");
    }

    @Override
    public void save(Memo memo) throws DataAccessException {
        if (memo.isNew()) {
            Number newKey = this.insertMemo.executeAndReturnKey(
                createMemoParameterSource(memo));
            memo.setId(newKey.intValue());
        } else {
            throw new UnsupportedOperationException("Memo update not supported");
        }
    }

    /**
     * Creates a {@link MapSqlParameterSource} based on data values from the supplied {@link Memo} instance.
     */
    private MapSqlParameterSource createMemoParameterSource(Memo memo) {
        return new MapSqlParameterSource()
            .addValue("id", memo.getId())
            .addValue("vet_id", memo.getVet().getId())
            .addValue("memo_date", memo.getDate())
            .addValue("description", memo.getDescription());
    }

    @Override
    public List<Memo> findByVetId(Integer vetId) {
        return null;
    }
}
