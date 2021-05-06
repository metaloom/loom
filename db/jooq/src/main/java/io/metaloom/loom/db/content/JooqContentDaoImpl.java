package io.metaloom.loom.db.content;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.metaloom.loom.db.tag.Tag;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqContentDaoImpl extends io.metaloom.loom.db.jooq.tables.daos.ContentDao implements ContentDao {

	@Inject
	public JooqContentDaoImpl(Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
	}

	// protected JooqType getType() {
	// return JooqType.CONTENT;
	// }

	@Override
	public Maybe<? extends Content> loadContent(UUID uuid) {
		return wrap(findOneById(uuid), JooqContentImpl.class);
	}

	@Override
	public void deleteContent(Content content) {
		Objects.requireNonNull(content, "Content must not be null");
		deleteById(content.getUuid());
	}

	@Override
	public Content createContent() {
		io.metaloom.loom.db.jooq.tables.pojos.Content content = new io.metaloom.loom.db.jooq.tables.pojos.Content();
		insert(content);
		return new JooqContentImpl(content);
	}

	@Override
	public void updateContent(Content content) {
		Objects.requireNonNull(content, "Content must not be null");
		io.metaloom.loom.db.jooq.tables.pojos.Content jooqContent = unwrap(content);
		update(jooqContent);
	}

	@Override
	public void storeContent(Content content) {
		Objects.requireNonNull(content, "Content must not be null");
		update(unwrap(content));
	}

	@Override
	public Observable<Tag> loadTags(Content content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(Content content, Tag tag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTag(Content content, Tag tag) {
		// TODO Auto-generated method stub

	}

	@Override
	public Completable clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
		return Completable.complete();
	}

}
