
CREATE TABLE IF NOT EXISTS "contentItem" (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    content_name_id INTEGER NOT NULL,
    item_content TEXT NOT NULL,
    item_Field TEXT,
    date TEXT NOT NULL );



CREATE TABLE IF NOT EXISTS "contentName" (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    name TEXT(10) NOT NULL,
    "type" INTEGER DEFAULT (0) NOT NULL,
    create_time TEXT NOT NULL,
    update_time TEXT NOT NULL );


CREATE TABLE IF NOT EXISTS "contentType" (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    des TEXT );


CREATE TABLE IF NOT EXISTS dataVersion (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
       tag TEXT NOT NULL,
       Log TEXT);


CREATE TABLE IF NOT EXISTS "user" (
                        id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                        avatar_url TEXT NOT NULL,
                        name TEXT NOT NULL,
                        oauth_provider TEXT NOT NULL,
                        oauth_provider_user_id TEXT NOT NULL,
                        created_at TEXT NOT NULL
);


CREATE TABLE IF NOT EXISTS user_contentName (
                                  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                                  userId INTEGER NOT NULL,
                                  contentNameId INTEGER NOT NULL,
                                  "typeId" INTEGER NOT NULL
);

CREATE UNIQUE INDEX IF NOT EXISTS user_contentName_userId_IDX ON user_contentName (userId,"typeId");



CREATE TABLE IF NOT EXISTS "user_selector" (
                                 id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                                 user_id INTEGER NOT NULL,
                                 content_type_id INTEGER NOT NULL, deleted INTEGER DEFAULT (1) NOT NULL,
                                 CONSTRAINT user_contentType_FK FOREIGN KEY (user_id) REFERENCES "user"(id) ON DELETE CASCADE,
                                 CONSTRAINT user_contentType_FK_1 FOREIGN KEY (content_type_id) REFERENCES contentType(id) ON DELETE CASCADE
);










