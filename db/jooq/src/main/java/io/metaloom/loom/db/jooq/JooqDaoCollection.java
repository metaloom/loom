package io.metaloom.loom.db.jooq;

import io.metaloom.loom.db.jooq.tables.daos.AssetDao;
import io.metaloom.loom.db.jooq.tables.daos.ContentDao;
import io.metaloom.loom.db.jooq.tables.daos.GroupDao;
import io.metaloom.loom.db.jooq.tables.daos.RoleDao;
import io.metaloom.loom.db.jooq.tables.daos.TagDao;
import io.metaloom.loom.db.jooq.tables.daos.UserDao;
import io.metaloom.loom.db.jooq.tables.daos.UserGroupDao;

public class JooqDaoCollection {

	private UserDao userDao;

	private GroupDao groupDao;

	private RoleDao roleDao;

	private TagDao tagDao;

	private ContentDao contentDao;

	private AssetDao assetDao;

	private UserGroupDao userGroupDao;

	public ContentDao getContentDao() {
		return contentDao;
	}

	public GroupDao getGroupDao() {
		return groupDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public TagDao getTagDao() {
		return tagDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public AssetDao getAssetDao() {
		return assetDao;
	}

	public UserGroupDao getUserGroupDao() {
		return userGroupDao;
	}
}
