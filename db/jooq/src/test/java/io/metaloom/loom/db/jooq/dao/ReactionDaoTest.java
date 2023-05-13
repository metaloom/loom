package io.metaloom.loom.db.jooq.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import io.metaloom.loom.db.CRUDDaoTestcases;
import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.model.reaction.Reaction;
import io.metaloom.loom.db.model.reaction.ReactionDao;
import io.metaloom.loom.db.model.user.User;

public class ReactionDaoTest extends AbstractJooqTest implements CRUDDaoTestcases<ReactionDao, Reaction, UUID> {

	@Override
	public ReactionDao getDao() {
		return reactionDao();
	}

	@Override
	public Reaction createElement(User user, int i) {
		return getDao().createReaction(user, "type_" + i);
	}

	@Override
	public void assertUpdate(Reaction updatedElement) {
		assertEquals("new", updatedElement.getType());
	}

	@Override
	public void updateElement(Reaction reaction) {
		reaction.setType("new");
	}

}
