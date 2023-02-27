package io.metaloom.loom.test.assertj;

import static org.junit.Assert.assertEquals;

import org.assertj.core.api.AbstractAssert;

import io.metaloom.worker.action.api.ActionResult;
import io.metaloom.worker.action.api.ResultState;

public class ActionResultAssert extends AbstractAssert<ActionResultAssert, ActionResult> {

	protected ActionResultAssert(ActionResult actual) {
		super(actual, ActionResultAssert.class);
	}

	public ActionResultAssert isProcessed() {
		assertEquals("The action was not in stat processed.", ResultState.PROCESSED, actual.getState());
		return this;
	}

	public ActionResultAssert isSkipped() {
		assertEquals("The action was not in stat skipped.", ResultState.SKIPPED, actual.getState());
		return this;
	}
}
