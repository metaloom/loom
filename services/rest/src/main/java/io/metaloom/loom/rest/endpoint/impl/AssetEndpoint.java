package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.model.ModelExamples;
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
	private final ModelExamples examples;

	@Inject
	public AssetEndpoint(AssetEndpointService service, TagEndpointService tagService, AssetLocationEndpointService locationService,
		ReactionEndpointService reactionService,
		EndpointDependencies deps, ModelExamples examples) {
		super(deps);
		this.service = service;
		this.tagService = tagService;
		this.locationService = locationService;
		this.reactionService = reactionService;
		this.examples = examples;
	}

	@Override
	public String name() {
		return "asset";
	}

	@Override
	public void register() {
		log.info("Registering assets endpoint");

		secure(basePath() + "*");
		addRoute(basePath(), POST,
			"Create a new asset",
			examples.assetCreateRequestExample(), 
			examples.assetResponseExample(),
			lrc -> {
				service.create(lrc);
			});

		addRoute(basePath() + "/:sha512orUUID", POST,
			"Update an asset",
			examples.assetUpdateRequestExample(), 
			examples.assetResponseExample(),
			lrc -> {
				service.update(lrc, lrc.pathParamAssetId("sha512orUUID"));
			});

		addRoute(basePath() + "/:sha512orUUID", DELETE,
			"Delete a specific asset",
			null,
			examples.deleteResponseExample(),
			lrc -> {
				service.delete(lrc, lrc.pathParamAssetId("sha512orUUID"));
			});

		addRoute(basePath(), GET,
			"List assets",
			null, 
			examples.assetListResponseExample(),
			lrc -> {
				service.list(lrc);
			});

		addRoute(basePath() + "/:sha512orUUID", GET,
			"Load an asset",
			null, 
			examples.assetResponseExample(),
			lrc -> {
				service.load(lrc, lrc.pathParamAssetId("sha512orUUID"));
			});

		// TAG

		addRoute(basePath() + "/:sha512orUUID" + "/tags", POST,
			"Tag the asset",
			lrc -> {
				tagService.tagAsset(lrc, lrc.pathParamAssetId("sha512orUUID"));
			});

		addRoute(basePath() + "/:sha512orUUID/tags/:tagUuid", DELETE,
			"Remove a tag from an asset",
			lrc -> {
				tagService.untagAsset(lrc, lrc.pathParamAssetId("sha512orUUID"), lrc.pathParamUUID("tagUuid"));
			});

		// REACTION

		addRoute(basePath() + "/:sha512orUUID/reactions", POST,
			"Create a new reaction on an asset",
			lrc -> {
				reactionService.createAssetReaction(lrc, lrc.pathParamAssetId("sha512orUUID"));
			});

		addRoute(basePath() + "/:sha512orUUID/reactions/:reactionUuid", DELETE,
			"Delete the reaction on an asset",
			lrc -> {
				reactionService.deleteAssetReaction(lrc, lrc.pathParamAssetId("sha512orUUID"), lrc.pathParamUUID("reactionUuid"));
			});

		addRoute(basePath() + "/:sha512orUUID/reactions", GET,
			"List the reactions on an asset",
			lrc -> {
				reactionService.listAssetReactions(lrc, lrc.pathParamAssetId("sha512orUUID"));
			});

		addRoute(basePath() + "/:sha512orUUID/reactions/:reactionUuid", GET,
			"Load a reaction for an asset",
			lrc -> {
				reactionService.loadAssetReaction(lrc, lrc.pathParamAssetId("sha512orUUID"), lrc.pathParamUUID("reactionUuid"));
			});

		addRoute(basePath() + "/:sha512orUUID/reactions/:reactionUuid", POST,
			"Update an reaction for an asset",
			lrc -> {
				reactionService.updateAssetReaction(lrc, lrc.pathParamAssetId("sha512orUUID"), lrc.pathParamUUID("reactionUuid"));
			});

	}

	private String basePath() {
		return "/assets";
	}

}
