-- content_name definition

CREATE TABLE content_name (
                              id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                              name TEXT(10) NOT NULL,
                              "type" INTEGER DEFAULT (0) NOT NULL,
                              create_time TEXT NOT NULL,
                              update_time TEXT NOT NULL
);


insert into content_name(id,name,type,create_time,update_time)
values(0,'daily-base',0,datetime(),datetime());



-- content_item definition

CREATE TABLE content_item (
                              id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                              content_name_id INTEGER NOT NULL,
                              item_content TEXT NOT NULL,
                              item_Field TEXT,
                              "date" TEXT NOT NULL
);

-- content_type definition

CREATE TABLE content_type (
                              id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                              name TEXT NOT NULL,
                              des TEXT
);
insert into content_type(id,name,des) values(0,'daily-base','基本日报类型：以日期 格式分割content_item数据返回前端展示 ');





