package io.metaloom.loom.db.extension;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.JooqType;
import io.metaloom.loom.db.jooq.tables.daos.ExtensionDao;
import io.reactivex.Maybe;

public class JooqExtensionsDaoImpl extends AbstractJooqDao implements ExtensionsDao {

	private final ExtensionDao delegate;

	protected JooqType getType() {
		return JooqType.EXTENSION;
	}

	public JooqExtensionsDaoImpl(ExtensionDao delegate) {
		this.delegate = delegate;
	}

	@Override
	public Maybe<? extends Extension> loadExtension(UUID uuid) {
		return wrap(delegate.findOneById(uuid), JooqExtensionImpl.class);
	}

	@Override
	public void deleteExtension(Extension extension) {
		Objects.requireNonNull(extension, "Extension must not be null");
		delegate.deleteById(extension.getUuid());
	}

	@Override
	public Extension createExtension() {
		io.metaloom.loom.db.jooq.tables.pojos.Extension extension = new io.metaloom.loom.db.jooq.tables.pojos.Extension();
		delegate.insert(extension);
		return new JooqExtensionImpl(extension);
	}

	@Override
	public void updateExtension(Extension extension) {
		Objects.requireNonNull(extension, "Extension must not be null");
		io.metaloom.loom.db.jooq.tables.pojos.Extension jooqExtension = unwrap(extension);
		delegate.update(jooqExtension);
	}

	@Override
	public void storeExtension(Extension extension) {
		Objects.requireNonNull(extension, "Extension must not be null");
		delegate.update(unwrap(extension));
	}

	@Override
	public void clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
	}

}
