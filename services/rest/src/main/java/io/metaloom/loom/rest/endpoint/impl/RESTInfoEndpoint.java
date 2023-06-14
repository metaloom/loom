package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.GET;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.api.LoomVersion;
import io.metaloom.loom.api.error.LoomRestException;
import io.metaloom.loom.rest.AbstractEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.HTTPConstants;
import io.metaloom.vertx.openapi.OpenAPIGenerator;
import io.metaloom.vertx.openapi.OpenAPIGenerator.Builder;

@Singleton
public class RESTInfoEndpoint extends AbstractEndpoint {

	private static final Logger log = LoggerFactory.getLogger(RESTInfoEndpoint.class);

	@Inject
	public RESTInfoEndpoint(EndpointDependencies deps) {
		super(deps);
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void register() {
		addRoute("/v1", GET, "Load REST API info", lrc -> {
			// TODO implement handler
			lrc.error("not yet implemented");
		});

		addRoute("/v1/openapi", GET, "Load REST API OpenAPI spec", lrc -> {
			try {
				Builder builder = OpenAPIGenerator.builder();
				builder.title("MetaLoom // Loom REST API");
				builder.baseUrl("https://server.tld");
				builder.version(LoomVersion.VERSION);
				builder.description("The API for our example server");
				builder.apiRouter(apiRouter());
				// TODO check accept header for types
				String yaml = builder.generateYaml();
				lrc.sendText(yaml, HTTPConstants.TEXT_YAML, 200);
			} catch (Exception e) {
				log.error("Error while invoking API spec generator", e);
				throw new LoomRestException(500, "Error while generating spec");
			}
		});
	}

}
