package io.metaloom.loom.core.dagger;

import dagger.Component;
import io.metaloom.Loom;
import io.metaloom.loom.options.LoomOptions;

/**
 * Central dagger loom component.
 */
@Component
public interface LoomComponent {

	interface Builder {

		/**
		 * Inject configuration options.
		 * 
		 * @param options
		 * @return
		 */
		Builder configuration(LoomOptions options);

		/**
		 * Inject loom instance.
		 * 
		 * @param mesh
		 * @return
		 */
		Builder loom(Loom loom);

		/**
		 * Build the component.
		 * 
		 * @return
		 */
		LoomComponent build();

	}
}
