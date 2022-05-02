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
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getById")
    @ApiOperation(value="更具ID获取菜单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "菜单ID")
    })
    public R<SysMenu> findById(Long id){
        SysMenu byId = sysMenuService.getById(id);
        return R.ok(byId);
    }

    @DeleteMapping("/del")
    @ApiOperation(value = "菜单的删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name="menuId",value = "菜单id")
    })
    public R<String> deleteMenuById(long menuId){
        int i = sysMenuService.deleteMenuById(menuId);
        if(i==1){
            return R.ok("删除成功");
        }else{
            return R.fail("删除失败");
        }
    }

    @DeleteMapping("/batchDel")
    @ApiOperation(value="菜单批量删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name="menuIds",value = "菜单ID集合的json")
    })
    public R<String> deleteMenuByIds(@RequestBody List<Long> ids){
        boolean del=sysMenuService.deleteMenuByIds(ids);
        if(del){
            return R.ok("批量删除成功");
        }else{
            return R.fail("批量删除失败");
        }
    }

    @PostMapping("/add")
    @ApiOperation(value = "菜单的新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysMenu",value = "sysMenu 的json数据")
    })
    public R<String> addMenu(@RequestBody SysMenu sysMenu){
        boolean save = sysMenuService.save(sysMenu);
        if(save){
            return R.ok("新增成功");
        }else{
            return R.ok("新增失败");
        }

    }
    @PutMapping("/update")
    @ApiOperation(value = "菜单的修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysMenu",value = "sysMenu 的json数据")
    })
    public R<String> updateMenu(@RequestBody SysMenu sysMenu){
        boolean update = sysMenuService.updateById(sysMenu);
        if(update){
            return R.ok("修改菜单成功");
        }else {
            return R.fail("修改菜单失败");
        }
    }
}
