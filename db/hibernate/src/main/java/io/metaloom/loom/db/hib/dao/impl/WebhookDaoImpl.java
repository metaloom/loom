package io.metaloom.loom.db.hib.dao.impl;

import java.io.IOException;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.reactive.mutiny.Mutiny;

import io.metaloom.loom.db.hib.dao.AbstractDao;
import io.metaloom.loom.db.model.webhook.Webhook;
import io.metaloom.loom.db.model.webhook.WebhookDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class WebhookDaoImpl extends AbstractDao implements WebhookDao {

	@Inject
	public WebhookDaoImpl(Mutiny.SessionFactory emf) {
		super(emf);
	}

	@Override
	public Completable clear() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Single<? extends Webhook> createWebhook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maybe<? extends Webhook> loadWebhook(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable updateWebhook(Webhook webhook) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable deleteWebhook(Webhook webhook) {
		// TODO Auto-generated method stub
		return null;
	}

}
