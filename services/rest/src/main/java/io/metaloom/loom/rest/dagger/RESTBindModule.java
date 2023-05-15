package io.metaloom.loom.rest.dagger;

import dagger.Binds;
import dagger.Module;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.builder.impl.LoomModelBuilderImpl;
import io.metaloom.loom.rest.validation.LoomModelValidator;
import io.metaloom.loom.rest.validation.impl.LoomModelValidatorImpl;

@Module
public abstract class RESTBindModule {

	@Binds
	abstract LoomModelBuilder bindModelBuilder(LoomModelBuilderImpl e);

	@Binds
	abstract LoomModelValidator bindModelValidator(LoomModelValidatorImpl e);
}
