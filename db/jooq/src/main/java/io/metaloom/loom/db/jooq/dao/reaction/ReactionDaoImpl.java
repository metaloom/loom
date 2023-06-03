package io.metaloom.loom.db.jooq.dao.reaction;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.JooqReaction;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetId;
import io.metaloom.loom.db.model.reaction.Reaction;
import io.metaloom.loom.db.model.reaction.ReactionDao;
import io.metaloom.loom.db.model.task.Task;

@Singleton
public class ReactionDaoImpl extends AbstractJooqDao<Reaction> implements ReactionDao {

	@Inject
	public ReactionDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	public String getTypeName() {
		return "Reactions";
	}

	@Override
	protected Table<? extends TableRecord<?>> getTable() {
		return JooqReaction.REACTION;
	}

	@Override
	protected Class<? extends Reaction> getPojoClass() {
		return ReactionImpl.class;
	}

	@Override
	public Reaction createReaction(UUID userUuid, String type) {
		Reaction reaction = new ReactionImpl();
		reaction.setType(type);
		setCreatorEditor(reaction, userUuid);
		return reaction;
	}
	
	@Override
	public Reaction createAssetReaction(UUID userUuid, AssetId assetId, String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
