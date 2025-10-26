

-- content_name definition

CREATE TABLE if not exists content_name (
                              id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                              name TEXT(10) NOT NULL,
                              "type" INTEGER DEFAULT (0) NOT NULL,
                              create_time TEXT NOT NULL,
                              update_time TEXT NOT NULL
);






-- content_item definition

CREATE TABLE  if not exists content_item (
                              id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                              content_name_id INTEGER NOT NULL,
                              item_content TEXT NOT NULL,
                              item_Field TEXT,
                              date TEXT NOT NULL

);

-- content_type definition

CREATE TABLE if not exists content_type (
                              id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                              name TEXT NOT NULL,
                              des TEXT
);

-- "user" definition

CREATE TABLE "user" (
                        id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                        avatar_url TEXT NOT NULL,
                        name TEXT NOT NULL,
                        oauth_provider TEXT NOT NULL,
                        oauth_provider_user_id TEXT NOT NULL,
                        created_at TEXT NOT NULL
);


-- user_contentType definition

CREATE TABLE user_contentType (
                                  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                                  user_id INTEGER NOT NULL,
                                  content_type_id INTEGER NOT NULL,
                                  CONSTRAINT user_contentType_FK FOREIGN KEY (user_id) REFERENCES "user"(id) ON DELETE CASCADE,
                                  CONSTRAINT user_contentType_FK_1 FOREIGN KEY (content_type_id) REFERENCES contentType(id) ON DELETE CASCADE
);

-- contentType_contentName definition

CREATE TABLE contentType_contentName (
                                         id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                                         contentTypeId INTEGER NOT NULL,
                                         contentNameId INTEGER NOT NULL
);

CREATE INDEX contentType_contentName_contentTypeId_IDX ON contentType_contentName (contentTypeId);
CREATE INDEX contentType_contentName_contentNameId_IDX ON contentType_contentName (contentNameId);


-- dataVersion definition

CREATE TABLE dataVersion (
                             id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                             tag TEXT NOT NULL, Log TEXT
                         );







