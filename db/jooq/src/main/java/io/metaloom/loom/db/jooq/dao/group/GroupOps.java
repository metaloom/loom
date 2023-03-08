package io.metaloom.loom.db.jooq.dao.group;

public final class GroupOps {

	private GroupOps() {
	}

//	public static Single<User> createUserOp(ReactiveRXQueryExecutor<UserRecord, User, UUID> tx,
//		io.metaloom.loom.db.jooq.tables.pojos.User userPojo, Function<Object, UUID> keyConverter) {
//		Single<io.metaloom.loom.db.jooq.tables.pojos.User> createUser = tx.insertReturning(ctx -> {
//			return ctx
//				.insertInto(USER)
//				.set(ctx.newRecord(USER, userPojo))
//				.returning(USER.getPrimaryKey().getFieldsArray());
//		}, keyConverter).map(pk -> userPojo.setUuid(pk));
//		return createUser;
//	}
//
//	public static Single<User> insertUser(ReactiveRXQueryExecutor<UserRecord, User, UUID> tx, User userPojo, Function<Object, UUID> keyConverter) {
//		return tx.insertReturning(ctx -> {
//			return ctx
//				.insertInto(USER)
//				.set(ctx.newRecord(USER, userPojo))
//				.returning(USER.getPrimaryKey().getFieldsArray());
//		}, keyConverter).map(pk -> userPojo.setUuid(pk));
//	}
}
