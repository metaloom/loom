# Asset

```d2 layout=elk theme=200
direction: right
title: |md
  # Asset Management
| { near: top-center }


face1: Face 1 { shape: circle }
face2: Face 2 { shape: circle }
person1: Person
project: Project

ac: {
  a1: Asset 1 { shape: package }
  a2: Asset 2 { shape: package }
}

# Collections
ac: Asset Collection
gac: Global Asset Collection { shape: cylinder }
gc: Geo Collection { shape: cylinder }
fc: Face Collection { shape: cylinder }
pc: Person Collection { shape: cylinder }

gac -> ac
project -> ac
face1 -> ac.a1
face2 -> ac.a2
gc -> ac.a1: has location
person1 -> face1: automatically tagged
person1 -> face2: manually tagged

tc: Tag Collection

tc: {
  tag1: Tag
  tag2: Tag
}

tc.tag1 -> ac.a1
tc.tag2 -> ac.a1

pc <- person1
fc <- face1
fc <- face2

timeline: Timeline
an: Annotation

timeline <- ac.a2
timeline -> an

task: Task
task -> timeline
task -> an

user -> task: comments on
user -> an: comments on
user -> ac.a2: comments on
user: User

# Client usecases
client: Client { shape: cloud }

client -> gc: Query asset by area
client -> pc: Query asset by person
client -> fc: Query asset by face embedding
client -> tc.tag1: Query asset by tag
client -> user: Query asset by creator
client -> ac.a1: Crop to focalpoint of Person 
client -> ac: Find asset with given bpm
client -> ac.a1: |md
Query by:
dominant color, path, filetype
|


```

