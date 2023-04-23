package io.metaloom.loom.db.jooq.wrapper;

import io.metaloom.loom.db.Element;
import io.metaloom.loom.db.jooq.LoomJooqException;
import io.metaloom.loom.db.jooq.dao.asset.AssetBinaryImpl;
import io.metaloom.loom.db.jooq.dao.asset.AssetImpl;
import io.metaloom.loom.db.jooq.dao.content.ContentImpl;
import io.metaloom.loom.db.jooq.dao.group.GroupImpl;
import io.metaloom.loom.db.jooq.dao.namespace.NamespaceImpl;
import io.metaloom.loom.db.jooq.dao.role.RoleImpl;
import io.metaloom.loom.db.jooq.dao.tag.TagImpl;
import io.metaloom.loom.db.jooq.dao.user.UserImpl;
import io.metaloom.loom.db.jooq.extension.ExtensionImpl;
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

	default <T> T unwrap(Element element) {
		if (element == null) {
			return null;
		}
		return switch (element) {
		case JooqWrapper w -> (T) w.delegate();
		default -> throw new LoomJooqException("Unknown type encountered is not supported " + element.getClass().getName());
		};
	}

	@SuppressWarnings("unchecked")
	default <T extends Element> T wrap(Object jooq) {
		if (jooq == null) {
			return null;
		}
		return (T) switch (jooq) {
		case JooqUser u -> new UserImpl(u);
		case JooqGroup g -> new GroupImpl(g);
		case JooqRole r -> new RoleImpl(r);
		case JooqAsset a -> new AssetImpl(a);
		case JooqNamespace n -> new NamespaceImpl(n);
		case JooqAssetBinarie b -> new AssetBinaryImpl(b);
		case JooqContent c -> new ContentImpl(c);
		case JooqExtension e -> new ExtensionImpl(e);
		case JooqTag t -> new TagImpl(t);
		default -> throw new LoomJooqException("Unknown type encountered is not supported " + jooq.getClass().getName());
		};
	}

}
