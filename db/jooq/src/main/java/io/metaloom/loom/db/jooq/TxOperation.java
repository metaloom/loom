package io.metaloom.loom.db.jooq;

import java.util.UUID;


import io.github.jklingsporn.vertx.jooq.rx.reactivepg.ReactiveRXQueryExecutor;
import io.metaloom.loom.db.jooq.tables.pojos.User;
import io.metaloom.loom.db.jooq.tables.records.UserRecord;

@FunctionalInterface
public interface TxOperation<R> {

	R apply(ReactiveRXQueryExecutor<UserRecord, User, UUID> t);

}
