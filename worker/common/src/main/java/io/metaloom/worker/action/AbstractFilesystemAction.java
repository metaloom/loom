package io.metaloom.worker.action;

import static io.metaloom.utils.ConvertUtils.toHumanTime;
import static io.metaloom.worker.action.ActionResult.CONTINUE_NEXT;
import static org.apache.commons.lang3.StringUtils.rightPad;

import io.metaloom.loom.client.grpc.LoomGRPCClient;
import io.metaloom.utils.hash.HashUtils;

public abstract class AbstractFilesystemAction implements FilesystemAction {

	private long current;
	private long total;
	private LoomGRPCClient client;
	private WorkerActionSettings settings;

	public AbstractFilesystemAction(LoomGRPCClient client, WorkerActionSettings settings) {
		this.client = client;
		this.settings = settings;
	}

	protected LoomGRPCClient client() {
		return client;
	}

	protected WorkerActionSettings settings() {
		return settings;
	}


	protected String shortHash(ProcessableMedia media) {
		return media.getHash512().substring(0, 8);
	}

	protected ActionResult completed(ProcessableMedia media, long start, String msg) {
		print(media, "COMPLETED", "(" + msg + ")", start);
		return ActionResult.processed(true, start);
	}

	protected ActionResult skipped(ProcessableMedia media, long start, String msg) {
		print(media, "SKIPPED", "(" + msg + ")", start);
		return ActionResult.skipped(true, start);
	}

	protected ActionResult failure(ProcessableMedia media, long start, String msg) {
		print(media, "FAILURE", "(" + msg + ")", start);
		return ActionResult.failed(true, start);
	}

	protected ActionResult done(ProcessableMedia media, long start, String info) {
		print(media, "DONE", "(" + info + ")", start);
		return ActionResult.processed(CONTINUE_NEXT, start);
	}

	@Override
	public void error(ProcessableMedia media, String msg) {
		String prefix = prefix(media);
		System.err.println(prefix + msg);
	}

	@Override
	public void print(ProcessableMedia file, String result, String msg, long start) {
		if (result == null) {
			result = "";
		}
		long dur = System.currentTimeMillis() - start;
		String prefix = prefix(file);
		result = rightPad(result, 12);
		String time = rightPad(" [" + toHumanTime(dur) + "] ", 12);
		System.out.println(prefix + result + time + msg);
	}

	private String prefix(ProcessableMedia media) {
		String progress = rightPad("[" + current + "/" + total + "] ", 17);
		if (media.getHash512() == null) {
			return progress + rightPad("[" + name() + "]", 28);
		} else {
			return progress + rightPad(shortHash(media) + " [" + name() + "]", 28);
		}
	}
	
	@Override
	public void set(long current, long total) {
		this.current = current;
		this.total = total;
	}

}
