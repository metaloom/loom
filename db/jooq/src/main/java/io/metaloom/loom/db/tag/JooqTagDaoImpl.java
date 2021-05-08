package io.metaloom.loom.db.tag;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.metaloom.loom.db.jooq.tables.daos.TagDao;
import io.metaloom.loom.db.jooq.tables.pojos.Tag;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqTagDaoImpl extends TagDao implements LoomTagDao {

	@Inject
	public JooqTagDaoImpl(Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
	}

	// protected JooqType getType() {
	// return JooqType.ROLE;
	// }

	@Override
	public Maybe<? extends LoomTag> loadTag(UUID uuid) {
		return wrap(findOneById(uuid), JooqTagImpl.class);
	}

	@Override
	public Completable deleteTag(LoomTag role) {
		Objects.requireNonNull(role, "Tag must not be null");
		return deleteById(role.getUuid()).ignoreElement();
	}

	@Override
	public Single<LoomTag> createTag(String name, String collection) {
		Tag tag = new Tag();
		tag.setName(name);
		tag.setCollection(collection);
		return insertReturningPrimary(tag).map(pk -> new JooqTagImpl(tag.setUuid(pk)));
	}

	@Override
	public Completable updateTag(LoomTag tag) {
		Objects.requireNonNull(tag, "Tag must not be null");
		Tag jooqTag = unwrap(tag);
		return update(jooqTag).ignoreElement();
	}

	@Override
	public Completable clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
		return Completable.complete();
	}

}
