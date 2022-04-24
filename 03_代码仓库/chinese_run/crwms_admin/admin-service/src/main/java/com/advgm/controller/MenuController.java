package com.advgm.controller;

import com.advgm.domain.SysMenu;
import com.advgm.model.R;
import com.advgm.service.SysMenuService;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menus")
@Api(tags = "菜单的管理")
public class MenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping
    @ApiOperation(value = "分页查询菜单数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current" ,value = "当前页") ,
            @ApiImplicitParam(name = "size" ,value = "每页显示的大小") ,
            @ApiImplicitParam(name="name",value = "菜单名称")
    })
    public R<Page<SysMenu>> findByPage(Page<SysMenu> page,String name){
        page.addOrder(OrderItem.desc("last_update_time"));
        return R.ok(sysMenuService.findByPage(page, name));
    }
}
