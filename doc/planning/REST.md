# REST API

## Sorting

* OData web api

## Methods

* POST, PUT, DELETE, GET, HEAD

## Paging

## Space API

/api/v1/spaces

```json
{
	"name": "a",
	"cdate": "",
	"creator": {

	}
}
```

# User API

/api/v1/users
```json
{
	"name": "username",
	"email": "",
	"extra": {
		"a":  "b"
	},
	"admin": true,
	"enabled": true,
}
```

# Group API

/api/v1/groups

```json
{
  "name": "groupName",
  "creator": {

  },
  "cdate": "",
  "editor": {

  },
  "edate": "",
  "version": "?"

}
```

## Content API


/api/v1/:projectName/nodes/:nodeUuid

```
```

## WebRoot API

/api/v1/:projectName/webroot/


## Asset API

/api/v1/assets
/api/v1/assets/:uuid

```json
{
	"filename":"",
	"size": "",
	"mimeType": ""
	"description": {
	   "en": "ABC",
	   "de": "ABC",
	   "default": ""
	}
}
```

POST /api/v1/assets
-> 201 + location with uuid

/api/v1/assets/:uuid/versions
/api/v1/assets/:uuid/publish
/api/v1/assets/:uuid/unpublish
/api/v1/assets/:uuid/archive


## Content API

/api/v1/spaces/:spaceUuid/contents/:uuid/

## Archive API

/api/v1/archive


```json

```

## Language API

/api/v1/languages

```json
{
	"name": "de-DE",
	"nativeName": "Deutsch",
	"fallback": "en-GB"
}
```

## Key API

NOTE: Maybe add to user pojo?

/api/v1/users/:userId/keys

```

```

## Webhook API

```
```


## Search API

```json

```


## GraphQL API


```json

```


