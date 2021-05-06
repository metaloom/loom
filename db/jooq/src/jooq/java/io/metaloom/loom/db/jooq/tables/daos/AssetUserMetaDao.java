/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.daos;


import io.github.jklingsporn.vertx.jooq.shared.reactive.AbstractReactiveVertxDAO;
import io.metaloom.loom.db.jooq.tables.AssetUserMeta;
import io.metaloom.loom.db.jooq.tables.records.AssetUserMetaRecord;

import java.util.Collection;
import java.util.UUID;

import org.jooq.Configuration;
import org.jooq.Record2;


import java.util.List;
import io.reactivex.Single;
import java.util.Optional;
import io.github.jklingsporn.vertx.jooq.rx.reactivepg.ReactiveRXQueryExecutor;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AssetUserMetaDao extends AbstractReactiveVertxDAO<AssetUserMetaRecord, io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta, Record2<UUID, UUID>, Single<List<io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta>>, Single<Optional<io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta>>, Single<Integer>, Single<Record2<UUID, UUID>>> implements io.github.jklingsporn.vertx.jooq.rx.VertxDAO<AssetUserMetaRecord,io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta,Record2<UUID, UUID>> {

        /**
     * @param configuration The Configuration used for rendering and query execution.
     * @param vertx the vertx instance
     */
        public AssetUserMetaDao(Configuration configuration, io.vertx.reactivex.sqlclient.SqlClient delegate) {
                super(AssetUserMeta.ASSET_USER_META, io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta.class, new ReactiveRXQueryExecutor<AssetUserMetaRecord,io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta,Record2<UUID, UUID>>(configuration,delegate,io.metaloom.loom.db.jooq.tables.mappers.RowMappers.getAssetUserMetaMapper()));
        }

        @Override
        protected Record2<UUID, UUID> getId(io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta object) {
                return compositeKeyRecord(object.getAssetUuid(), object.getUserUuid());
        }

        /**
     * Find records that have <code>user_uuid IN (values)</code> asynchronously
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta>> findManyByUserUuid(Collection<UUID> values) {
                return findManyByCondition(AssetUserMeta.ASSET_USER_META.USER_UUID.in(values));
        }

        /**
     * Find records that have <code>user_uuid IN (values)</code> asynchronously limited by the given limit
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta>> findManyByUserUuid(Collection<UUID> values, int limit) {
                return findManyByCondition(AssetUserMeta.ASSET_USER_META.USER_UUID.in(values),limit);
        }

        /**
     * Find records that have <code>rating IN (values)</code> asynchronously
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta>> findManyByRating(Collection<Integer> values) {
                return findManyByCondition(AssetUserMeta.ASSET_USER_META.RATING.in(values));
        }

        /**
     * Find records that have <code>rating IN (values)</code> asynchronously limited by the given limit
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta>> findManyByRating(Collection<Integer> values, int limit) {
                return findManyByCondition(AssetUserMeta.ASSET_USER_META.RATING.in(values),limit);
        }

        /**
     * Find records that have <code>meta IN (values)</code> asynchronously
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta>> findManyByMeta(Collection<String> values) {
                return findManyByCondition(AssetUserMeta.ASSET_USER_META.META.in(values));
        }

        /**
     * Find records that have <code>meta IN (values)</code> asynchronously limited by the given limit
     */
        public Single<List<io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta>> findManyByMeta(Collection<String> values, int limit) {
                return findManyByCondition(AssetUserMeta.ASSET_USER_META.META.in(values),limit);
        }

        @Override
        public ReactiveRXQueryExecutor<AssetUserMetaRecord,io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta,Record2<UUID, UUID>> queryExecutor(){
                return (ReactiveRXQueryExecutor<AssetUserMetaRecord,io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta,Record2<UUID, UUID>>) super.queryExecutor();
        }
}
