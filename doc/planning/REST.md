# REST API

## Sorting

* OData web api

## Paging

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

## Content API

/api/v1/spaces/:spaceUuid/contents/:uuid/


## Key API

NOTE: Maybe add to user pojo?

/api/v1/users/:userId/keys
