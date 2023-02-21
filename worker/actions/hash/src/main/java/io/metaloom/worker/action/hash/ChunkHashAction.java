package io.metaloom.worker.action.hash;

import io.metaloom.loom.client.grpc.LoomGRPCClient;
import io.metaloom.loom.proto.AssetResponse;
import io.metaloom.utils.hash.HashUtils;
import io.metaloom.worker.action.AbstractFilesystemAction;
import io.metaloom.worker.action.ActionResult;
import io.metaloom.worker.action.ProcessableMedia;
import io.metaloom.worker.action.WorkerActionSettings;

public class ChunkHashAction extends AbstractFilesystemAction {

	private static final String NAME = "chunk-hash";

	public static final String CHUNK_HASH_ATTR_KEY = "chunkHash";

	public ChunkHashAction(LoomGRPCClient client, WorkerActionSettings settings) {
		super(client, settings);
	}

	@Override
	public String name() {
		return NAME;
	}

	@Override
	public ActionResult process(ProcessableMedia media) {
		long start = System.currentTimeMillis();
		String info = "";
		String chunkHash = getChunkHash(media);
		if (chunkHash == null) {
			String sha512 = media.getHash512();
			AssetResponse entry = client().loadAsset(sha512).sync();
			if (entry == null) {
				info = "hashed";
				getChunkHash(media);
			} else {
				String dbHash = entry.getChunkHash();
				if (dbHash != null) {
					writeChunkHash(media, dbHash);
					info = "from db";
				}
			}
			return done(media, start, info);
		} else {
			return done(media, start, info);
		}
	}

	private String getChunkHash(ProcessableMedia media) {
		String chunkHashSum = media.readAttrStr(CHUNK_HASH_ATTR_KEY);
		if (chunkHashSum == null) {
			chunkHashSum = HashUtils.computeChunkHash(media.file());
			writeChunkHash(media, chunkHashSum);
		}
		return chunkHashSum;
	}

	private void writeChunkHash(ProcessableMedia media, String hashSum) {
		media.writeAttr(CHUNK_HASH_ATTR_KEY, hashSum);
	}

}
