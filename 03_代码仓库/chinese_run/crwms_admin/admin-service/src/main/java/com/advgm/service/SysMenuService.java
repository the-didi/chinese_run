package com.advgm.service;

import com.advgm.domain.SysMenu;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface SysMenuService extends IService<SysMenu>{

    /**
     * 通过用户的id 查询用户的菜单数据
     * @param userId
     * @return
     */

    List<SysMenu> getMenusByUserId(Long userId);

    Page<SysMenu> findByPage(Page<SysMenu> page, String name);
}
