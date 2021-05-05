package io.metaloom.loom.db.model;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.JooqType;
import io.metaloom.loom.db.jooq.tables.daos.ModelDao;
import io.reactivex.Maybe;

public class JooqModelsDaoImpl extends AbstractJooqDao implements ModelsDao {

	private final ModelDao delegate;

	protected JooqType getType() {
		return JooqType.ROLE;
	}

	public JooqModelsDaoImpl(ModelDao delegate) {
		this.delegate = delegate;
	}

	@Override
	public Maybe<? extends Model> loadModel(UUID uuid) {
		return wrap(delegate.findOneById(uuid), JooqModelImpl.class);
	}

	@Override
	public void deleteModel(Model model) {
		Objects.requireNonNull(model, "Model must not be null");
		delegate.deleteById(model.getUuid());
	}

	@Override
	public Model createModel() {
		io.metaloom.loom.db.jooq.tables.pojos.Model model = new io.metaloom.loom.db.jooq.tables.pojos.Model();
		delegate.insert(model);
		return new JooqModelImpl(model);
	}

	@Override
	public void updateModel(Model model) {
		Objects.requireNonNull(model, "Model must not be null");
		io.metaloom.loom.db.jooq.tables.pojos.Model jooqModel = unwrap(model);
		delegate.update(jooqModel);
	}

	@Override
	public void storeModel(Model model) {
		Objects.requireNonNull(model, "Model must not be null");
		delegate.update(unwrap(model));
	}

	@Override
	public void clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
	}

}
