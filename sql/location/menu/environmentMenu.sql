-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('环境数据', '2002', '1', 'environment', 'location/environment/index', 1, 0, 'C', '0', '0', 'location:environment:list', '#', 'admin', sysdate(), '', null, '环境数据菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('环境数据查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'location:environment:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('环境数据新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'location:environment:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('环境数据修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'location:environment:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('环境数据删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'location:environment:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('环境数据导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'location:environment:export',       '#', 'admin', sysdate(), '', null, '');