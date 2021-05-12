package io.metaloom.loom.db;

import io.metaloom.loom.db.user.LoomUser;
import io.vertx.core.json.JsonObject;

public interface MetaElement extends LoomElement {

	JsonObject getMeta();

	LoomElement setMeta(JsonObject meta);

}
