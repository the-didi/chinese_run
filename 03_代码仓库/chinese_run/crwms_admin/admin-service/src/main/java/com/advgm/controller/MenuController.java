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
    @RequestMapping("/del")
    @ApiOperation(value = "菜单的删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name="menuId",value = "菜单id")
    })
    public R<String> deleteMenuById(long menuId){
        if(sysMenuService.deleteMenuById(menuId)==1)
        return R.ok();
        return R.fail();
    }
    @RequestMapping("/add")
    @ApiOperation(value = "菜单的新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name="parentId",value = "上级菜单ID"),
            @ApiImplicitParam(name="parentKey",value = "上级菜单唯一KEY值"),
            @ApiImplicitParam(name = "type",value = "类型 1-分类 2-节点"),
            @ApiImplicitParam(name="name",value = "名称"),
            @ApiImplicitParam(name="desc",value = "描述"),
            @ApiImplicitParam(name="targetUrl",value = "目标地址"),
            @ApiImplicitParam(name="sort",value = "排序索引"),
            @ApiImplicitParam(name="status",value = "状态 0-无效； 1-有效；"),
            @ApiImplicitParam(name="createBy",value = "创建人"),
            @ApiImplicitParam(name="modifyBy",value = "修改人")
    })
    public R<String> addMenu(
            Long parentId,
            String parentKey,
            Byte type,
            String name,
            String desc,
            String targetUrl,
            Integer sort,
            Byte status,
            Long createBy,
            Long modifyBy

    ){
        SysMenu sysMenu = new SysMenu(parentId, parentKey, type, name, desc, targetUrl, sort, status, createBy, modifyBy);
        if(sysMenuService.addMenu(sysMenu)==1)
        return R.ok();
        return R.fail();
    }
    @RequestMapping("/update")
    @ApiOperation(value = "菜单的修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "菜单id"),
            @ApiImplicitParam(name="parentId",value = "上级菜单ID"),
            @ApiImplicitParam(name="parentKey",value = "上级菜单唯一KEY值"),
            @ApiImplicitParam(name = "type",value = "类型 1-分类 2-节点"),
            @ApiImplicitParam(name="name",value = "名称"),
            @ApiImplicitParam(name="desc",value = "描述"),
            @ApiImplicitParam(name="targetUrl",value = "目标地址"),
            @ApiImplicitParam(name="sort",value = "排序索引"),
            @ApiImplicitParam(name="status",value = "状态 0-无效； 1-有效；"),
            @ApiImplicitParam(name="createBy",value = "创建人"),
            @ApiImplicitParam(name="modifyBy",value = "修改人")
    })
    public R<String> updateMenu(
            Long id,
            Long parentId,
            String parentKey,
            Byte type,
            String name,
            String desc,
            String targetUrl,
            Integer sort,
            Byte status,
            Long createBy,
            Long modifyBy
    ){
        SysMenu sysMenu = new SysMenu(id, parentId, parentKey, type, name, desc, targetUrl, sort, status, createBy, modifyBy);
      if( sysMenuService.updateMenu(sysMenu)==1)
        return R.ok();
      return R.fail();
    }
}
