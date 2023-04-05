package io.metaloom.loom.db.jooq.codegen;

import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.Definition;

public class LoomJooqStrategy extends DefaultGeneratorStrategy {

	@Override
	public String getJavaClassName(Definition definition, Mode mode) {
		String defaultName = super.getJavaClassName(definition, mode);
		if (mode == Mode.POJO || mode == Mode.DAO) {
			return "Jooq" + defaultName;
		} else {
			return defaultName;
		}
	}

}
