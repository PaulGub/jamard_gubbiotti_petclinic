package org.springframework.samples.petclinic.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.samples.petclinic.model.Operation;
import org.springframework.samples.petclinic.repository.OperationRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcOperationRepositoryImpl implements OperationRepository {

    private SimpleJdbcInsert insertOperation;

    @Autowired
    public JdbcOperationRepositoryImpl(DataSource dataSource) {
        this.insertOperation = new SimpleJdbcInsert(dataSource).withTableName("operations").usingGeneratedKeyColumns("id");
    }


    @Override
    public void save(Operation operation) throws DataAccessException {
        if (operation.isNew()) {
            Number newKey = this.insertOperation.executeAndReturnKey(
                createOperationParameterSource(operation));
            operation.setId(newKey.intValue());
        } else {
            throw new UnsupportedOperationException("Operation update not supported");
        }
    }

    /**
     * Creates a {@link MapSqlParameterSource} based on data values from the supplied {@link Operation} instance.
     */
    private MapSqlParameterSource createOperationParameterSource(Operation operation) {
        return new MapSqlParameterSource()
            .addValue("id", operation.getId())
            .addValue("vet_id", operation.getVet().getId())
            .addValue("pet_id", operation.getPet().getId())
            .addValue("description", operation.getDescription())
            .addValue("operations_date", operation.getDate());
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
