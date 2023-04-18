//package io.metaloom.loom.rest;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.util.concurrent.ExecutionException;
//
//import org.junit.jupiter.api.Test;
//
//import io.vertx.core.Vertx;
//import io.vertx.ext.web.Router;
//import io.vertx.ext.web.openapi.router.RouterBuilder;
//import io.vertx.openapi.contract.OpenAPIContract;
//
//public class ContractTest {
//
//	@Test
//	public void testContract() throws InterruptedException, ExecutionException {
//		Vertx vertx = Vertx.vertx();
//		OpenAPIContract contract = OpenAPIContract.from(vertx, "src/main/resources/api-contract.yaml").toCompletionStage().toCompletableFuture().get();
//		assertNotNull(contract);
//		RouterBuilder routerBuilder = RouterBuilder.create(vertx, contract);
//		routerBuilder.getRoute("checkUsers").addHandler(rc -> {
//			System.out.println("Check users");
//			rc.response().end();
//		});
//		Router router = routerBuilder.createRouter();
//
//		vertx.createHttpServer().requestHandler(router).listen(8080);
//	}
//}
