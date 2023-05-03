package io.metaloom.loom.db.jooq.dao.reaction;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.JooqLibrary;
import io.metaloom.loom.db.model.reaction.Reaction;
import io.metaloom.loom.db.model.reaction.ReactionDao;

@Singleton
public class ReactionDaoImpl extends AbstractJooqDao<Reaction> implements ReactionDao {

	@Inject
	public ReactionDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	protected Table<? extends TableRecord<?>> getTable() {
		return JooqLibrary.LIBRARY;
	}

	@Override
	protected Class<? extends Reaction> getPojoClass() {
		return ReactionImpl.class;
	}

	@Override
	public Reaction createReaction(String name) {
		Reaction reaction = new ReactionImpl();
		return reaction;
	}

}
