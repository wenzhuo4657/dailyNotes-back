INSERT INTO content_type (id, name, des)
SELECT 0, 'daily-base', '基本日报类型：以日期 格式分割content_item数据返回前端展示 '
    WHERE NOT EXISTS (SELECT 1 FROM content_type WHERE id = 0);


INSERT INTO content_type (id, name, des)
SELECT 1, 'checkList', '备忘录类型：可以通过是否完成来过滤展示 '
    WHERE NOT EXISTS (SELECT 1 FROM content_type WHERE id = 1);

INSERT INTO content_name (id, name, type, create_time, update_time)
SELECT 0, 'daily-base', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    WHERE NOT EXISTS (SELECT 1 FROM content_name WHERE id = 0);


INSERT INTO content_name (id, name, type, create_time, update_time)
SELECT 1, 'checkList', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
    WHERE NOT EXISTS (SELECT 1 FROM content_name WHERE id = 1);
