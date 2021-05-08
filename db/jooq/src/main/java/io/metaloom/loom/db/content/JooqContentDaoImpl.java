package io.metaloom.loom.db.content;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.metaloom.loom.db.jooq.tables.daos.ContentDao;
import io.metaloom.loom.db.jooq.tables.pojos.Content;
import io.metaloom.loom.db.tag.LoomTag;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqContentDaoImpl extends ContentDao implements LoomContentDao {

	@Inject
	public JooqContentDaoImpl(Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
	}

	// protected JooqType getType() {
	// return JooqType.CONTENT;
	// }

	@Override
	public Maybe<? extends LoomContent> loadContent(UUID uuid) {
		return wrap(findOneById(uuid), JooqContentImpl.class);
	}

	@Override
	public void deleteContent(LoomContent content) {
		Objects.requireNonNull(content, "Content must not be null");
		deleteById(content.getUuid());
	}

	@Override
	public LoomContent createContent() {
		Content content = new Content();
		insert(content);
		return new JooqContentImpl(content);
	}

	@Override
	public void updateContent(LoomContent content) {
		Objects.requireNonNull(content, "Content must not be null");
		Content jooqContent = unwrap(content);
		update(jooqContent);
	}

	@Override
	public void storeContent(LoomContent content) {
		Objects.requireNonNull(content, "Content must not be null");
		update(unwrap(content));
	}

	@Override
	public Observable<LoomTag> loadTags(LoomContent content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(LoomContent content, LoomTag tag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTag(LoomContent content, LoomTag tag) {
		// TODO Auto-generated method stub

	}

	@Override
	public Completable clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
		return Completable.complete();
	}

}
