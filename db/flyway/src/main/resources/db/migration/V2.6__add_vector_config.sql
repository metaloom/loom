CREATE TABLE "vector_config" (
   "uuid" uuid DEFAULT uuid_generate_v4 (),
  "name" varchar UNIQUE NOT NULL,
  "weights" jsonb
);

COMMENT ON TABLE "vector_config" IS 'This table stores the custom index definition that will be used when creating custom indices in a vector database that list specific aspects of loom data.

A custom configuration may define that a specific meta property should be added to the index when generating the vector.
This feature can be used to generate a custom recommendation feature by including and ranking and encoding specific properties as vectors.';

COMMENT ON COLUMN "vector_config"."weights" IS 'Index definition which lists the weights for each component that should be included in the index';
