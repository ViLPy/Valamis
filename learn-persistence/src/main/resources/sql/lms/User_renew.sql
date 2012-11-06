DROP TABLE IF EXISTS LMSUser CASCADE;

CREATE TABLE LMSUser
(
  id integer,
  username text,
  preferredAudioLevel real,
  preferredLanguage text,
  preferredDeliverySpeed integer,
  preferredAudioCaptioning real,
  CONSTRAINT LMSUser_pk PRIMARY KEY (id)
<#if dbType=="postgres">
) WITH (
  OIDS=FALSE
</#if>
);
-- default user
INSERT INTO LMSUser(id, username, preferredAudioLevel, preferredLanguage, preferredDeliverySpeed, preferredAudioCaptioning)
VALUES (-1, 'Guest', 0, 'en', '0', '0');