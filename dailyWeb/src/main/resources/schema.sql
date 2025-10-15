

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





