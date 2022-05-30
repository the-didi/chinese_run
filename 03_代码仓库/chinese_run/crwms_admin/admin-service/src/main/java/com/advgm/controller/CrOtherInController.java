package com.advgm.controller;
import com.advgm.domain.CrOtherIn;
import com.advgm.domain.Driver;
import com.advgm.model.R;
import com.advgm.service.CrOtherInService;
import com.advgm.service.DriverService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* (cr_wms.cr_other_in)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/otherstorage")
public class CrOtherInController {
/**
* 服务对象
*/
@Resource
private CrOtherInService crOtherInService;
    @Autowired
    private DriverService driverService;
    @GetMapping("/info")
    @ApiOperation(value = "其他入库信息查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current" ,value = "当前页") ,
            @ApiImplicitParam(name = "size" ,value = "每页显示的大小") ,
    })
    public R<Page<CrOtherIn>> getInformationByPage(Page<CrOtherIn> page){
        return R.ok(crOtherInService.queryAllCrOtherIn(page));
    }
    @PostMapping("/add")
    @ApiOperation(value = "商品信息")
    public R<String> addDriver(@RequestBody CrOtherIn crOtherIn){
        int i = crOtherInService.addCrOtherIn(crOtherIn);
        if(i==0){
            return R.ok("添加失败");
        }
        return R.ok("添加成功");
    }
    @DeleteMapping("/del")
    @ApiOperation(value = "通过编号删除入库信息")
    public R<String> delete(long id){
        int i = crOtherInService.deleteCrOtherInById(id);
        if(i==0){
            return R.ok("删除失败");
        }
        return R.ok("删除成功");
    }
    @PutMapping("/update")
    @ApiOperation(value = "修改其他入库信息")
    public R<String> update(@RequestBody CrOtherIn crOtherIn){

        int i = crOtherInService.updateCrOtherById(crOtherIn);
        if(i==0){
            return R.ok("更新失败");
        }
        return R.ok("更新成功");
    }
    @GetMapping("/getById")
    @ApiImplicitParam(value = "通过id查询其他入库信息")
    public R<CrOtherIn> getDriverById(Long id){
        CrOtherIn byId = crOtherInService.getCrOtherInById(id);
        return R.ok(byId);
    };
    @GetMapping("/getByName")
    @ApiOperation(value = "通过姓名查询司机信息")
    public R<List<CrOtherIn>> getDriverByName(String name){
        return R.ok(crOtherInService.getCrOtherInByName(name));
    }

}
