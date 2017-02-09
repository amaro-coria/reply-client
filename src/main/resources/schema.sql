CREATE SCHEMA IF NOT EXISTS sitm_disp
  AUTHORIZATION postgres;

GRANT ALL ON SCHEMA sitm_disp TO postgres;
GRANT USAGE ON SCHEMA sitm_disp TO sitm_tor;

CREATE SCHEMA IF NOT EXISTS  sitm_envi
  AUTHORIZATION postgres;

GRANT ALL ON SCHEMA sitm_envi TO postgres;
GRANT USAGE ON SCHEMA sitm_envi TO sitm_tor;

--tables


