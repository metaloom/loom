# Asset

```d2 layout=elk theme=200
direction: right
title: |md
  # Asset Management
| { near: top-center }


# Project
prc: Project Collection { shape: cylinder

}

# Asset
ac: Asset Collection
ac: {
  a1: Asset 1  { shape: class
    path: "string"
    meta: "json"
  }
  a2: Asset 2 { shape: package }
}

# Asset Binary
abc: Asset Binary Collection {
 ab: Asset Binary { shape: class
    initialPath: "string"
    sha512: "string"
    sha256: "string"
    md5: "string"
    fingerprint: "string"
    size: "long"
 }
 ab2: Asset Binary 2
}

abc.ab -> ac.a1
abc.ab -> ac.a2

#  Report
rc: ReportResult Collection { shape: cylinder }
rc: {
  # Asset has been reported by user xyz
  r: ReportResult { shape: class
    uuid: "<uuid>"
    type: "<string>"
    asset_binary_uuid: "<uuid>"
    reviewer: "<uuid>"
    reviewdate: "<date>"
    reviewed: "boolean"
    result: "<boolean / enum>"
  }
}
rc.r -> abc.ab: Reported by user
rc.r -> user

# Blacklisting
blc: Blacklist Collection  { shape: cylinder }
blc: {
  b: Blacklist { shape: class
    uuid: "<uuid>"
    asset_binary_uuid: "<uuid>"
    creation_date:     "<date>"
    type:              "<enum>"
  }
}

blc.b -> abc.ab


# Collections
gac: Global Asset Collection { shape: cylinder }
gc: Geo Collection { shape: cylinder }
gc.location: Location {
  shape: class
  lon: "double"
  lat: "double"
  name: "string"
  meta: "json"
}

gac -> ac

# Embeddings
ebc: Embedding Collection {
  embedding1: Embedding 1 {shape: class
    embedding: "string"
    type: "string"
  }
  embedding2: Embedding 2 { shape: circle }
}

# Persons
pc: Person Collection {
 person1: Person (mutable) {shape: class
    name: "string"
    meta: "json"
    description: "string"
  }
}

ebc.embedding1 -> ac.a1
ebc.embedding2 -> ac.a2
prc -> ac: has project
gc -> ac.a1: has location
pc.person1 -> ebc.embedding1: automatically tagged
pc.person1 -> ebc.embedding2: manually tagged

# Tagging
tc: Tag Collection
tc: {
  tag1: Tag { shape: class
    name: "string"
    meta: "json"
  }
  tag2: Tag
}

tc.tag1 -> ac.a1
tc.tag2 -> ac.a1

# Task + Annotation
an: Annotation
task: Task
task -> an

user -> task: comments on
user -> an: comments on
user -> ac.a2: comments on
user: User

ap: AssetPOJO {
  shape: class
}
ap -> pc.person1
ap -> pc.person2
ap -> tc.tag1
ap -> ebc.embedding1

```

## Usecases

- Query asset by area
- Query asset by person
- Query asset by face embedding
- Query asset by tag
- Query asset by creator
- Crop to focalpoint of Person
- Find asset with given bpm

## AssetPOJO

`/binaries/:hash`

`/assets/:uuid`

```json
{
 "uuid": "UUID",
 "kind": "TYPE",
 "status": {
   "created": "",
   "creator": {
     "uuid": "<uuid>",
     "name": "joedoe"
   },
   "edited": "",
   "editor": {
     "uuid": "<uuid>",
     "name": "joedoe"
   }
 },
 "views": 0,
 "location": {
   "lastSeen": "date",
   "filekey": {
    // TODO use hash instead?
    "inode": 42,
    "st_dev": 24,
    "edate_nano": 42,
    "edate": 41
   },
   "path": "/now/somewhere/else/blume.jpg"
 },
 "collections": [
    {
      "name":
    }
 ],
 "binary": {
   "uuid": "",
   "initialOrigin": "/somewhere/test.jpg",
   "firstSeen": "date",
   "hashes":  {
    "sha256":"",
    "sha512": "",
    "md5": ""
   },
   "geo": {

   },
   "licenses": {

   },
   "author": {

   },
   "social": {
     "rating": {

     },
     "reactions": {

     }
   },
   "image": {
     "dimension": {
       "width": 42,
       "height": 42
     },
     "dominantColor": "",
     "embeddings": {
        "dlib_face": 20
     }
   },
   "video": {
     "dimension": {
       "width": 42,
       "height": 42
     },
     "audioTracks": 2,
     "duration": 0,
     "fingerprint": "",
     "embeddings": {
        "dlib_face": 20
     }
   },
   "audio": {
      "duration": 0,
      "bpm": 80,
      "samplingRate": 42000,
      "channels": 2,
      "encoding": "mp3",
      "fingerprint": ""
   },
   "size": 0,
   "mimeType": "image/jpg",
   "meta": {}
 },
 "meta": {

 },
 // Annotations used to track comments/tasks on specific (spatial or temporal aspects of the asset)
 "annotations": [ {
   "meta": {

    },
   "from": 42,
   "to": 45,
   "area": {
      "width": 120,
      "height": 120,
      "startX": 0,
      "startY": 0
   },
   "tasks": [],
   "comments": []
 }],

 // Generic comments to the asset
 "comments":
 [
  {
    "uuid": "<uuid>",
    "user": {
      "uuid": "<uuid>",
      "name": "joedoe"
    },
    "title": "Cool image!",
    "text": "-",
    "reactions": []
    // Add thread support
    // Add like/dislike/rating
  }
 ],
 "reactions": [
  {
    "type": "<emoji-code>",
    "count": 41
  }
 ]
 },
 "project": {
    "uuid": "<uuid>",
    "name": "zoo-summer-2023"
 },
 "tags": [
  {
    "name": "red",
    "collection": "colors",
    "meta": {}
  }
 ]
}
```

`/assets/:uuid/persons`

`/assets/:uuid/tags/colors/red`
