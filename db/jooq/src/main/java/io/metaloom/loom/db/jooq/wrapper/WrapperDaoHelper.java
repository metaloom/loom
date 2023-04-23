package io.metaloom.loom.db.jooq.wrapper;

import io.metaloom.loom.db.LoomElement;
import io.metaloom.loom.db.jooq.LoomJooqException;
import io.metaloom.loom.db.jooq.dao.asset.AssetBinaryImpl;
import io.metaloom.loom.db.jooq.dao.asset.AssetImpl;
import io.metaloom.loom.db.jooq.dao.content.LoomContentImpl;
import io.metaloom.loom.db.jooq.dao.group.LoomGroupImpl;
import io.metaloom.loom.db.jooq.dao.namespace.LoomNamespaceImpl;
import io.metaloom.loom.db.jooq.dao.role.LoomRoleImpl;
import io.metaloom.loom.db.jooq.dao.tag.LoomTagImpl;
import io.metaloom.loom.db.jooq.dao.user.LoomUserImpl;
import io.metaloom.loom.db.jooq.extension.LoomExtensionImpl;
import io.metaloom.loom.db.jooq.tables.pojos.JooqAsset;
import io.metaloom.loom.db.jooq.tables.pojos.JooqAssetBinarie;
import io.metaloom.loom.db.jooq.tables.pojos.JooqContent;
import io.metaloom.loom.db.jooq.tables.pojos.JooqExtension;
import io.metaloom.loom.db.jooq.tables.pojos.JooqGroup;
import io.metaloom.loom.db.jooq.tables.pojos.JooqNamespace;
import io.metaloom.loom.db.jooq.tables.pojos.JooqRole;
import io.metaloom.loom.db.jooq.tables.pojos.JooqTag;
import io.metaloom.loom.db.jooq.tables.pojos.JooqUser;

public interface WrapperDaoHelper {

	default <T> T unwrap(JooqWrapper<T> wrapper) {
		if (wrapper == null) {
			return null;
		}
		return wrapper.delegate();
	}

	default <T> T unwrap(LoomElement element) {
		if (element == null) {
			return null;
		}
		return switch (element) {
		case JooqWrapper w -> (T) w.delegate();
		default -> throw new LoomJooqException("Unknown type encountered is not supported " + element.getClass().getName());
		};
	}

	@SuppressWarnings("unchecked")
	default <T extends LoomElement> T wrap(Object jooq) {
		if (jooq == null) {
			return null;
		}
		return (T) switch (jooq) {
		case JooqUser u -> new LoomUserImpl(u);
		case JooqGroup g -> new LoomGroupImpl(g);
		case JooqRole r -> new LoomRoleImpl(r);
		case JooqAsset a -> new AssetImpl(a);
		case JooqNamespace n -> new LoomNamespaceImpl(n);
		case JooqAssetBinarie b -> new AssetBinaryImpl(b);
		case JooqContent c -> new LoomContentImpl(c);
		case JooqExtension e -> new LoomExtensionImpl(e);
		case JooqTag t -> new LoomTagImpl(t);
		default -> throw new LoomJooqException("Unknown type encountered is not supported " + jooq.getClass().getName());
		};
	}

}
