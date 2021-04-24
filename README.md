# MetaLoom - Loom

Loom is an asset management API and persistence server for your web applications.

### **Loom is still under development and not yet in a usable state.**

## Planned Features

* Multi database support for relational databases. (MariaDB, PostgreSQL)
* REST API for management
* Native S3 support for storage
* GraphQL API for easy traversal of nested data structures
* Content Models
* Native support for Keycloak, Auth0, Okta
* Extension microservice API
* Native K8S OpenShift support
* Webhook support
* Eventbus support
* OpenAPI spec
* Clustering to allow for horizontal scaling

## History / Goals

Loom is highly influenced by Gentics Mesh and can be seen as a total rewrite / conversion of Mesh.

### Why a rewrite and not a fork?

Starting all-over gives me the option to address various flaws and create a new project structure.

## Why is there no OrientDB support anymore?

The usage of OrientDB is one of the biggest issues of Gentics Mesh. In my experience the database is not reliable for the usecase. An embedded DB makes it easy to startup a single instance but causes big problems when trying to address scaling. Additionally I have experience a lot of cases database inconsistencies and clustering issues. Futhermore the database does not provide support for transaction isolation and can't cope well in situations which lead to database contention. (e.g. when updating connected types of records in parallel)

## Model

- Support for non-translatable fields has been added.
- Fields can now be nested to any depth using the `nested` field type. Thus microschemas are no longer needed.
- Content models are directly accessible. The models no longer need to be manually assigned to the namespace.
- Models can now extend another model

## Tagging

- Tag families are gone and were replaced by inline properties ('collection')
- Assets can now also be tagged

## Authentication

- Roles have dedicated permissions.
- Direct native keycloak, auth0 support
- Users can now have multiple API tokens
- API tokens have dedicated permissions

## Assets

- Binary data can now be managed via the assets entity
- Support for asset fingerprinting
- Support for asset thumbnail generation

## GraphQL

- The GraphQL endpoint is globally accessible and no longer scoped for namespaces (for now)

## Search 

- The search support has been limited to contents and assets (for now)

## New Features

- Native webhook support.
- Native S3 support.
- Full HTTP HEAD, PUT support in the API.
- Namespace import / exported.
- Users, Groups, Roles, Namespaces can now have arbitrary properties.
- Manual tagging of elements will create tags on-the fly. No need to create tags upfront.

## Deprecations

- Support for branches has been dropped. The concept of branches made the internal and external API very complicated.
- Plugins are gone and are replaced by external extensions which can be implemented as microservices
- Microschemas are gone since content models can be nested

## Under the hood

* Upgrade to Vert.x 4
* No OrientDB support
* Restructured REST models (No more custom serializes)

## License

Apache License, Version 2.0.
