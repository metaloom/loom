DROP SCHEMA IF EXISTS loom CASCADE;

CREATE SCHEMA loom;

/*
Enable UUID V4 Support
*/
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
