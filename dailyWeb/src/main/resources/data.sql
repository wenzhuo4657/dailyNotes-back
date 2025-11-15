-- 修正第一条
INSERT INTO "docs_type" (id, type_id, name, des)
SELECT 0, 0, 'dailyBase', '基本日报类型：以日期 格式分割content_item数据返回前端展示 '
    WHERE NOT EXISTS (SELECT 1 FROM "docs_type" WHERE id = 0);

-- 修正第二条
INSERT INTO "docs_type" (id, type_id, name, des)
SELECT 1, 1, 'checkList', '备忘录类型：可以通过是否完成来过滤展示 '
    WHERE NOT EXISTS (SELECT 1 FROM "docs_type" WHERE id = 1);



