/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.enums;


import io.metaloom.loom.db.jooq.Public;

import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum LoomExtensionType implements EnumType {

    ASSET_PROCESSOR("ASSET_PROCESSOR"),

    USER_MAPPER("USER_MAPPER");

    private final String literal;

    private LoomExtensionType(String literal) {
        this.literal = literal;
    }

    @Override
    public Catalog getCatalog() {
        return getSchema().getCatalog();
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public String getName() {
        return "loom_extension_type";
    }

    @Override
    public String getLiteral() {
        return literal;
    }

    /**
     * Lookup a value of this EnumType by its literal
     */
    public static LoomExtensionType lookupLiteral(String literal) {
        return EnumType.lookupLiteral(LoomExtensionType.class, literal);
    }
}
