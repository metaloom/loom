package io.metaloom.loom.db.group;

import static io.metaloom.loom.db.jooq.tables.User.USER;

import java.util.UUID;
import java.util.function.Function;

import io.github.jklingsporn.vertx.jooq.rx.reactivepg.ReactiveRXQueryExecutor;
import io.metaloom.loom.db.jooq.tables.pojos.User;
import io.metaloom.loom.db.jooq.tables.records.UserRecord;
import io.reactivex.Single;

public final class GroupOps {

	private GroupOps() {
	}

	public static Single<User> createUserOp(ReactiveRXQueryExecutor<UserRecord, User, UUID> tx,
		io.metaloom.loom.db.jooq.tables.pojos.User userPojo, Function<Object, UUID> keyConverter) {
		Single<io.metaloom.loom.db.jooq.tables.pojos.User> createUser = tx.insertReturning(ctx -> {
			return ctx
				.insertInto(USER)
				.set(ctx.newRecord(USER, userPojo))
				.returning(USER.getPrimaryKey().getFieldsArray());
		}, keyConverter).map(pk -> userPojo.setUuid(pk));
		return createUser;
	}

	public static Single<User> insertUser(ReactiveRXQueryExecutor<UserRecord, User, UUID> tx, User userPojo, Function<Object, UUID> keyConverter) {
		return tx.insertReturning(ctx -> {
			return ctx
				.insertInto(USER)
				.set(ctx.newRecord(USER, userPojo))
				.returning(USER.getPrimaryKey().getFieldsArray());
		}, keyConverter).map(pk -> userPojo.setUuid(pk));
	}
}
