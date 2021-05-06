/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.daos;


import io.github.jklingsporn.vertx.jooq.shared.reactive.AbstractReactiveVertxDAO;
import io.metaloom.loom.db.jooq.enums.LoomPermissionFlag;
import io.metaloom.loom.db.jooq.tables.Role;
import io.metaloom.loom.db.jooq.tables.records.RoleRecord;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

import org.jooq.Configuration;


import java.util.List;
import io.reactivex.Single;
import java.util.Optional;
import io.github.jklingsporn.vertx.jooq.rx.reactivepg.ReactiveRXQueryExecutor;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RoleDao extends AbstractReactiveVertxDAO<RoleRecord, io.metaloom.loom.db.jooq.tables.pojos.Role, UUID, Single<List<io.metaloom.loom.db.jooq.tables.pojos.Role>>, Single<Optional<io.metaloom.loom.db.jooq.tables.pojos.Role>>, Single<Integer>, Single<UUID>> implements io.github.jklingsporn.vertx.jooq.rx.VertxDAO<RoleRecord,io.metaloom.loom.db.jooq.tables.pojos.Role,UUID> {

        /**
     * @param configuration The Configuration used for rendering and query execution.
     * @param vertx the vertx instance
     */
        public RoleDao(Configuration configuration, io.vertx.reactivex.sqlclient.SqlClient delegate) {
                super(Role.ROLE, io.metaloom.loom.db.jooq.tables.pojos.Role.class, new ReactiveRXQueryExecutor<RoleRecord,io.metaloom.loom.db.jooq.tables.pojos.Role,UUID>(configuration,delegate,io.metaloom.loom.db.jooq.tables.mappers.RowMappers.getRoleMapper()));
        }

        @Override
        protected UUID getId(io.metaloom.loom.db.jooq.tables.pojos.Role object) {
                return object.getUuid();
        }

        /**
     * Find records that have <code>name IN (values)</code> asynchronously
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.Role>> findManyByName(Collection<String> values) {
                return findManyByCondition(Role.ROLE.NAME.in(values));
        }

        /**
     * Find records that have <code>name IN (values)</code> asynchronously limited by the given limit
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.Role>> findManyByName(Collection<String> values, int limit) {
                return findManyByCondition(Role.ROLE.NAME.in(values),limit);
        }

        /**
     * Find records that have <code>permissions IN (values)</code> asynchronously
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.Role>> findManyByPermissions(Collection<LoomPermissionFlag> values) {
                return findManyByCondition(Role.ROLE.PERMISSIONS.in(values));
        }

        /**
     * Find records that have <code>permissions IN (values)</code> asynchronously limited by the given limit
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.Role>> findManyByPermissions(Collection<LoomPermissionFlag> values, int limit) {
                return findManyByCondition(Role.ROLE.PERMISSIONS.in(values),limit);
        }

        /**
     * Find records that have <code>meta IN (values)</code> asynchronously
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.Role>> findManyByMeta(Collection<String> values) {
                return findManyByCondition(Role.ROLE.META.in(values));
        }

        /**
     * Find records that have <code>meta IN (values)</code> asynchronously limited by the given limit
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.Role>> findManyByMeta(Collection<String> values, int limit) {
                return findManyByCondition(Role.ROLE.META.in(values),limit);
        }

        /**
     * Find records that have <code>created IN (values)</code> asynchronously
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.Role>> findManyByCreated(Collection<LocalDateTime> values) {
                return findManyByCondition(Role.ROLE.CREATED.in(values));
        }

        /**
     * Find records that have <code>created IN (values)</code> asynchronously limited by the given limit
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.Role>> findManyByCreated(Collection<LocalDateTime> values, int limit) {
                return findManyByCondition(Role.ROLE.CREATED.in(values),limit);
        }

        /**
     * Find records that have <code>creator_uuid IN (values)</code> asynchronously
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.Role>> findManyByCreatorUuid(Collection<UUID> values) {
                return findManyByCondition(Role.ROLE.CREATOR_UUID.in(values));
        }

        /**
     * Find records that have <code>creator_uuid IN (values)</code> asynchronously limited by the given limit
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.Role>> findManyByCreatorUuid(Collection<UUID> values, int limit) {
                return findManyByCondition(Role.ROLE.CREATOR_UUID.in(values),limit);
        }

        /**
     * Find records that have <code>edited IN (values)</code> asynchronously
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.Role>> findManyByEdited(Collection<LocalDateTime> values) {
                return findManyByCondition(Role.ROLE.EDITED.in(values));
        }

        /**
     * Find records that have <code>edited IN (values)</code> asynchronously limited by the given limit
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.Role>> findManyByEdited(Collection<LocalDateTime> values, int limit) {
                return findManyByCondition(Role.ROLE.EDITED.in(values),limit);
        }

        /**
     * Find records that have <code>editor_uuid IN (values)</code> asynchronously
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.Role>> findManyByEditorUuid(Collection<UUID> values) {
                return findManyByCondition(Role.ROLE.EDITOR_UUID.in(values));
        }

        /**
     * Find records that have <code>editor_uuid IN (values)</code> asynchronously limited by the given limit
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.Role>> findManyByEditorUuid(Collection<UUID> values, int limit) {
                return findManyByCondition(Role.ROLE.EDITOR_UUID.in(values),limit);
        }

        /**
     * Find a unique record that has <code>name = value</code> asynchronously
     */
        public Single<Optional<io.metaloom.loom.db.jooq.tables.pojos.Role>> findOneByName(String value) {
                return findOneByCondition(Role.ROLE.NAME.eq(value));
        }

        @Override
        public ReactiveRXQueryExecutor<RoleRecord,io.metaloom.loom.db.jooq.tables.pojos.Role,UUID> queryExecutor(){
                return (ReactiveRXQueryExecutor<RoleRecord,io.metaloom.loom.db.jooq.tables.pojos.Role,UUID>) super.queryExecutor();
        }
}
