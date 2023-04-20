package io.metaloom.loom.auth.jwt;

import java.nio.file.Files;
import java.nio.file.Paths;

import dagger.Module;
import dagger.Provides;
import io.metaloom.loom.api.options.AuthenticationOptions;
import io.metaloom.loom.api.options.LoomOptions;
import io.metaloom.loom.auth.KeyStoreHelper;
import io.vertx.core.Vertx;
import io.vertx.ext.auth.KeyStoreOptions;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTAuthOptions;

@Module
public class JWTAuthModule {

	@Provides
	public JWTAuth authProvider(Vertx vertx, LoomOptions options) {
		AuthenticationOptions loomAuthOptions = options.getAuth();
		String path = loomAuthOptions.getKeystorePath();
		if (!Files.exists(Paths.get(path))) {
			String pass = options.getAuth().getKeystorePassword();
			try {
				KeyStoreHelper.gen(path, pass);
			} catch (Exception e) {
				throw new RuntimeException("Failure while creating keystore " + path, e);
			}
		}

		JWTAuthOptions config = new JWTAuthOptions().setKeyStore(new KeyStoreOptions().setPath(path)
			.setPassword(loomAuthOptions.getKeystorePassword())
			.setType("jceks"));

		return JWTAuth.create(vertx, config);
	}
}
