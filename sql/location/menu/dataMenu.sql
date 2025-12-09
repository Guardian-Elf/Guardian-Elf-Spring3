-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('GPS数据', '2001', '1', 'data', 'location/data/index', 1, 0, 'C', '0', '0', 'location:data:list', '#', 'admin', sysdate(), '', null, 'GPS数据菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('GPS数据查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'location:data:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('GPS数据新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'location:data:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('GPS数据修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'location:data:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('GPS数据删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'location:data:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('GPS数据导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'location:data:export',       '#', 'admin', sysdate(), '', null, '');