package com.advgm.service.impl;

import com.advgm.domain.SysRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.advgm.domain.SysMenu;
import com.advgm.mapper.SysMenuMapper;
import com.advgm.service.SysMenuService;
import com.advgm.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService{

    @Autowired
    private SysRoleService sysRoleService ;

    @Autowired
    private SysMenuMapper sysMenuMapper ;

    /**
     * 通过用户的id 查询用户的菜单数据
     *
     * @param userId
     * @return
     */
    @Override
    public List<SysMenu> getMenusByUserId(Long userId) {
        // 1 如果该用户是超级管理员->>拥有所有的菜单
        if(sysRoleService.isSuperAdmin(userId)){
            return list() ; // 查询所有
        }
        // 2 如果该用户不是超级管理员->>查询角色->查询菜单
        return sysMenuMapper.selectMenusByUserId(userId);
    }

    /**
     * 使用菜单的名称模糊分页菜单查询
     *
     * @param page 分页数据
     * @param name 菜单的名称
     * @return
     */
    @Override
    public Page<SysMenu> findByPage(Page<SysMenu> page, String name) {
        return page(page, new LambdaQueryWrapper<SysMenu>().like(
                !StringUtils.isEmpty(name),
                SysMenu::getName,
                name
        ));
    }

    @Override
    public int deleteMenuById(Long menuId) {
        return sysMenuMapper.deleteMenuById(menuId);
    }

    @Override
    public int addMenu(SysMenu sysMenu) {
        return sysMenuMapper.addMenu(sysMenu);
    }

    @Override
    public int updateMenu(SysMenu sysMenu) {
        return sysMenuMapper.update(sysMenu,null);
    }


}
