package io.metaloom.loom.db.tag;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqTagDaoImpl extends io.metaloom.loom.db.jooq.tables.daos.TagDao implements TagDao {

	@Inject
	public JooqTagDaoImpl(Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
	}

	// protected JooqType getType() {
	// return JooqType.ROLE;
	// }

	@Override
	public Maybe<? extends Tag> loadTag(UUID uuid) {
		return wrap(findOneById(uuid), JooqTagImpl.class);
	}

	@Override
	public void deleteTag(Tag role) {
		Objects.requireNonNull(role, "Tag must not be null");
		deleteById(role.getUuid());
	}

	@Override
	public Single<Tag> createTag(String name, String collection) {
		io.metaloom.loom.db.jooq.tables.pojos.Tag tag = new io.metaloom.loom.db.jooq.tables.pojos.Tag();
		tag.setName(name);
		tag.setCollection(collection);
		return insertReturningPrimary(tag).map(pk -> new JooqTagImpl(tag.setUuid(pk)));
	}

	@Override
	public void updateTag(Tag tag) {
		Objects.requireNonNull(tag, "Tag must not be null");
		io.metaloom.loom.db.jooq.tables.pojos.Tag jooqTag = unwrap(tag);
		update(jooqTag);
	}

	@Override
	public void storeTag(Tag tag) {
		Objects.requireNonNull(tag, "Tag must not be null");
		update(unwrap(tag));
	}

	@Override
	public Completable clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
		return Completable.complete();
	}

}
