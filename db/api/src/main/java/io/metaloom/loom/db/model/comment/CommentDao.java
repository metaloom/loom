package io.metaloom.loom.db.model.comment;

import java.util.List;
import java.util.UUID;

import io.metaloom.loom.db.CRUDDao;
import io.metaloom.loom.db.model.user.User;

public interface CommentDao extends CRUDDao<Comment, UUID> {

	default Comment createComment(User user, String title) {
		return createComment(user.getUuid(), title);
	}

	Comment createComment(UUID userUuid, String title);

	List<Comment> loadForTask(UUID taskUuid);

}
