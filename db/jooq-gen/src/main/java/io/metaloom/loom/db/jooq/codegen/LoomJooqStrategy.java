package io.metaloom.loom.db.jooq.codegen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.Definition;

public class LoomJooqStrategy extends DefaultGeneratorStrategy {

//	@Override
//	public List<String> getJavaClassImplements(Definition definition, Mode mode) {
//		if (mode == Mode.POJO && definition.getQualifiedName().equals("public.asset")) {
//			return Arrays.asList("io.metaloom.loom.db.jooq.dao.asset.JooqAsset");
//		}
//		return new ArrayList<>();
//	}

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
