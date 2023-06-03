package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.AssetEndpointService;
import io.metaloom.loom.rest.service.impl.AssetLocationEndpointService;
import io.metaloom.loom.rest.service.impl.ReactionEndpointService;
import io.metaloom.loom.rest.service.impl.TagEndpointService;

public class AssetEndpoint extends AbstractEndpoint {

	private static final Logger log = LoggerFactory.getLogger(AssetEndpoint.class);
	private final AssetEndpointService service;
	private final TagEndpointService tagService;
	private final AssetLocationEndpointService locationService;
	private final ReactionEndpointService reactionService;

	@Inject
	public AssetEndpoint(AssetEndpointService service, TagEndpointService tagService, AssetLocationEndpointService locationService,
		ReactionEndpointService reactionService,
		EndpointDependencies deps) {
		super(deps);
		this.service = service;
		this.tagService = tagService;
		this.locationService = locationService;
		this.reactionService = reactionService;
	}

	@Override
	public String name() {
		return "asset";
	}

	@Override
	public void register() {
		log.info("Registering assets endpoint");

		secure(basePath() + "*");
		addRoute(basePath(), POST, lrc -> {
			service.create(lrc);
		});

		addRoute(basePath() + "/:sha512orUUID", POST, lrc -> {
			service.update(lrc, lrc.pathParamAssetId("sha512orUUID"));
		});

		addRoute(basePath() + "/:sha512orUUID", DELETE, lrc -> {
			service.delete(lrc, lrc.pathParamAssetId("sha512orUUID"));
		});

		addRoute(basePath(), GET, lrc -> {
			service.list(lrc);
		});

		addRoute(basePath() + "/:sha512orUUID", GET, lrc -> {
			service.load(lrc, lrc.pathParamAssetId("sha512orUUID"));
		});

		// TAG

		addRoute(basePath() + "/:sha512orUUID" + "/tags", POST, lrc -> {
			tagService.tagAsset(lrc, lrc.pathParamAssetId("sha512orUUID"));
		});

		addRoute(basePath() + "/:sha512orUUID/tags/:tagUuid", DELETE, lrc -> {
			tagService.untagAsset(lrc, lrc.pathParamAssetId("sha512orUUID"), lrc.pathParamUUID("tagUuid"));
		});

		// REACTION

		addRoute(basePath() + "/:sha512orUUID/reactions", POST, lrc -> {
			reactionService.createAssetReaction(lrc, lrc.pathParamAssetId("sha512orUUID"));
		});

		addRoute(basePath() + "/:sha512orUUID/reactions/:reactionUuid", DELETE, lrc -> {
			reactionService.deleteAssetReaction(lrc, lrc.pathParamAssetId("sha512orUUID"), lrc.pathParamUUID("reactionUuid"));
		});

		addRoute(basePath() + "/:sha512orUUID/reactions", GET, lrc -> {
			reactionService.listAssetReactions(lrc, lrc.pathParamAssetId("sha512orUUID"));
		});

		addRoute(basePath() + "/:sha512orUUID/reactions/:reactionUuid", GET, lrc -> {
			reactionService.loadAssetReaction(lrc, lrc.pathParamAssetId("sha512orUUID"), lrc.pathParamUUID("reactionUuid"));
		});

		addRoute(basePath() + "/:sha512orUUID/reactions/:reactionUuid", POST, lrc -> {
			reactionService.updateAssetReaction(lrc, lrc.pathParamAssetId("sha512orUUID"), lrc.pathParamUUID("reactionUuid"));
		});

	}

	private String basePath() {
		return "/assets";
	}

}
