/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.enums;


import io.metaloom.loom.db.jooq.JooqPublic;

import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum JooqLoomPermission implements EnumType {

    CREATE_ANNOTATION("CREATE_ANNOTATION"),

    READ_ANNOTATION("READ_ANNOTATION"),

    DELETE_ANNOTATION("DELETE_ANNOTATION"),

    UPDATE_ANNOTATION("UPDATE_ANNOTATION"),

    CREATE_ASSET("CREATE_ASSET"),

    READ_ASSET("READ_ASSET"),

    DELETE_ASSET("DELETE_ASSET"),

    UPDATE_ASSET("UPDATE_ASSET"),

    CREATE_ASSET_LOCATION("CREATE_ASSET_LOCATION"),

    READ_ASSET_LOCATION("READ_ASSET_LOCATION"),

    DELETE_ASSET_LOCATION("DELETE_ASSET_LOCATION"),

    UPDATE_ASSET_LOCATION("UPDATE_ASSET_LOCATION"),

    CREATE_ATTACHMENT("CREATE_ATTACHMENT"),

    READ_ATTACHMENT("READ_ATTACHMENT"),

    DELETE_ATTACHMENT("DELETE_ATTACHMENT"),

    UPDATE_ATTACHMENT("UPDATE_ATTACHMENT"),

    CREATE_USER("CREATE_USER"),

    READ_USER("READ_USER"),

    DELETE_USER("DELETE_USER"),

    UPDATE_USER("UPDATE_USER"),

    CREATE_ROLE("CREATE_ROLE"),

    READ_ROLE("READ_ROLE"),

    DELETE_ROLE("DELETE_ROLE"),

    UPDATE_ROLE("UPDATE_ROLE"),

    CREATE_GROUP("CREATE_GROUP"),

    READ_GROUP("READ_GROUP"),

    DELETE_GROUP("DELETE_GROUP"),

    UPDATE_GROUP("UPDATE_GROUP"),

    CREATE_PROJECT("CREATE_PROJECT"),

    READ_PROJECT("READ_PROJECT"),

    DELETE_PROJECT("DELETE_PROJECT"),

    UPDATE_PROJECT("UPDATE_PROJECT"),

    CREATE_CLUSTER("CREATE_CLUSTER"),

    READ_CLUSTER("READ_CLUSTER"),

    DELETE_CLUSTER("DELETE_CLUSTER"),

    UPDATE_CLUSTER("UPDATE_CLUSTER"),

    CREATE_COLLECTION("CREATE_COLLECTION"),

    READ_COLLECTION("READ_COLLECTION"),

    DELETE_COLLECTION("DELETE_COLLECTION"),

    UPDATE_COLLECTION("UPDATE_COLLECTION"),

    CREATE_COMMENT("CREATE_COMMENT"),

    READ_COMMENT("READ_COMMENT"),

    DELETE_COMMENT("DELETE_COMMENT"),

    UPDATE_COMMENT("UPDATE_COMMENT"),

    CREATE_EMBEDDING("CREATE_EMBEDDING"),

    READ_EMBEDDING("READ_EMBEDDING"),

    DELETE_EMBEDDING("DELETE_EMBEDDING"),

    UPDATE_EMBEDDING("UPDATE_EMBEDDING"),

    CREATE_REACTION("CREATE_REACTION"),

    READ_REACTION("READ_REACTION"),

    DELETE_REACTION("DELETE_REACTION"),

    UPDATE_REACTION("UPDATE_REACTION"),

    CREATE_TASK("CREATE_TASK"),

    READ_TASK("READ_TASK"),

    DELETE_TASK("DELETE_TASK"),

    UPDATE_TASK("UPDATE_TASK"),

    CREATE_TAG("CREATE_TAG"),

    READ_TAG("READ_TAG"),

    DELETE_TAG("DELETE_TAG"),

    UPDATE_TAG("UPDATE_TAG"),

    TAG_ASSET("TAG_ASSET"),

    UNTAG_ASSET("UNTAG_ASSET"),

    CREATE_TOKEN("CREATE_TOKEN"),

    READ_TOKEN("READ_TOKEN"),

    DELETE_TOKEN("DELETE_TOKEN"),

    UPDATE_TOKEN("UPDATE_TOKEN"),

    CREATE_WEBHOOK("CREATE_WEBHOOK"),

    READ_WEBHOOK("READ_WEBHOOK"),

    DELETE_WEBHOOK("DELETE_WEBHOOK"),

    UPDATE_WEBHOOK("UPDATE_WEBHOOK"),

    CREATE_LIBRARY("CREATE_LIBRARY"),

    READ_LIBRARY("READ_LIBRARY"),

    DELETE_LIBRARY("DELETE_LIBRARY"),

    UPDATE_LIBRARY("UPDATE_LIBRARY");

    private final String literal;

    private JooqLoomPermission(String literal) {
        this.literal = literal;
    }

    @Override
    public Catalog getCatalog() {
        return getSchema().getCatalog();
    }

    @Override
    public Schema getSchema() {
        return JooqPublic.PUBLIC;
    }

    @Override
    public String getName() {
        return "loom_permission";
    }

    @Override
    public String getLiteral() {
        return literal;
    }

    /**
     * Lookup a value of this EnumType by its literal
     */
    public static JooqLoomPermission lookupLiteral(String literal) {
        return EnumType.lookupLiteral(JooqLoomPermission.class, literal);
    }
}
