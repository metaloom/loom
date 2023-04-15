# MetaLoom - Loom

Loom is an advanced media asset management system designed to ease the management processes for digital media assets. With a decoupled processing mechanism, Loom separates processing of media assets, providing users with greater flexibility and scalability. Loom supports a wide range of industry-standard protocols, including REST, gRPC, and GraphQL, making it easy to integrate with other systems and workflows. In addition, Loom offers powerful features such as fingerprinting and face detection, enabling users to easily search, categorize, and manage their media assets.

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

## Goals

### Model

- Support for non-translatable fields has been added.
- Fields can now be nested to any depth using the `nested` field type. Thus microschemas are no longer needed.
- Content models are directly accessible. The models no longer need to be manually assigned to the namespace.
- Models can now extend another model

### Tagging

- Tag families are gone and were replaced by inline properties ('collection')
- Assets can now also be tagged

### Authentication

- Roles have dedicated permissions.
- Direct native keycloak, auth0 support
- Users can now have multiple API tokens
- API tokens have dedicated permissions

### Assets

- Binary data can now be managed via the assets entity
- Support for asset fingerprinting
- Support for asset thumbnail generation

### Search 

- The search support has been limited to contents and assets (for now)

### New Features

- Native webhook support.
- Native S3 support.
- Full HTTP HEAD, PUT support in the API.
- Namespace import / exported.
- Users, Groups, Roles, Namespaces can now have arbitrary properties.
- Manual tagging of elements will create tags on-the fly. No need to create tags upfront.

## Development Status

* Project Structure: 80%
* REST Model: 80%
* REST API Spec: 80%
* REST API Implementation: 0%
* GraphQL Spec: 0%
* GraphQL Implementation: 0%
* Database Models: 0%
  * Tags
  * Contents
  * Assets
  * Extensions
  * Users
  * Groups
  * Roles
  * Webhooks
  * Namespaces
  * Models
* Database DAOs: 0%
* Auth0, Keycloak: 0%
* Asset Processing: 80%
* Content Model migrations: 0%
* Content Model extension handling: 0%
* Extensions: 0%
* Webhooks: 0%
* S3: 0%
* Clustering: 0%
* Import/Export: 0%

## License

Apache License, Version 2.0.
