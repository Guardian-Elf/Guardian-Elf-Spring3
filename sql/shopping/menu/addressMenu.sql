-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('地址', '2081', '1', 'address', 'shopping/address/index', 1, 0, 'C', '0', '0', 'shopping:address:list', '#', 'admin', sysdate(), '', null, '地址菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('地址查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'shopping:address:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('地址新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'shopping:address:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('地址修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'shopping:address:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('地址删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'shopping:address:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('地址导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'shopping:address:export',       '#', 'admin', sysdate(), '', null, '');