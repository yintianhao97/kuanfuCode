-- 注意：该页面对应的前台目录为views/link文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024022601423540350', NULL, '配比出库更新公司编码维护', '/link/linkPeibiListList', 'link/LinkPeibiListList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-02-26 13:42:35', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024022601423540351', '2024022601423540350', '添加配比出库更新公司编码维护', NULL, NULL, 0, NULL, NULL, 2, 'link:link_peibi_list:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-02-26 13:42:35', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024022601423540352', '2024022601423540350', '编辑配比出库更新公司编码维护', NULL, NULL, 0, NULL, NULL, 2, 'link:link_peibi_list:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-02-26 13:42:35', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024022601423540353', '2024022601423540350', '删除配比出库更新公司编码维护', NULL, NULL, 0, NULL, NULL, 2, 'link:link_peibi_list:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-02-26 13:42:35', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024022601423540354', '2024022601423540350', '批量删除配比出库更新公司编码维护', NULL, NULL, 0, NULL, NULL, 2, 'link:link_peibi_list:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-02-26 13:42:35', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024022601423540355', '2024022601423540350', '导出excel_配比出库更新公司编码维护', NULL, NULL, 0, NULL, NULL, 2, 'link:link_peibi_list:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-02-26 13:42:35', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024022601423540356', '2024022601423540350', '导入excel_配比出库更新公司编码维护', NULL, NULL, 0, NULL, NULL, 2, 'link:link_peibi_list:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-02-26 13:42:35', NULL, NULL, 0, 0, '1', 0);