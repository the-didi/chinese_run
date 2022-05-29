package com.advgm.controller;
import com.advgm.domain.CrObserveIn;
import com.advgm.domain.Driver;
import com.advgm.model.R;
import com.advgm.service.CrObserveInService;
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
* (cr_wms.cr_observe_in)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/observe")
public class CrObserveInController {
/**
* 服务对象
*/
@Resource
private CrObserveInService crObserveInService;
    @Autowired
    private DriverService driverService;
    @GetMapping("/info")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current" ,value = "当前页") ,
            @ApiImplicitParam(name = "size" ,value = "每页显示的大小") ,
    })
    public R<Page<CrObserveIn>> getInformationByPage(Page<CrObserveIn> page){
        return R.ok(crObserveInService.queryAllCrObserveIns(page));
    }
    @PostMapping("/add")
    public R<String> add(@RequestBody CrObserveIn crObserveIn){
        int i = crObserveInService.addCrObserveIn(crObserveIn);
        if(i==0){
            return R.ok("添加失败");
        }
        return R.ok("添加成功");
    }
    @DeleteMapping("/del")
    public R<String> delete(long id){
        int i = crObserveInService.deleteCrObserveInById(id);
        if(i==0){
            return R.ok("删除失败");
        }
        return R.ok("删除成功");
    }
    @PutMapping("/update")
    public R<String> update(@RequestBody CrObserveIn crObserveIn){

        int i = crObserveInService.updateCrObserveById(crObserveIn);
        if(i==0){
            return R.ok("更新失败");
        }
        return R.ok("更新成功");
    }
    @GetMapping("/getById")
    @ApiImplicitParam(value = "通过id查询司机信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "司机编号")
    })
    public R<CrObserveIn> getById(Long id){

        return R.ok(crObserveInService.getCrObserveById(id));
    };
    @GetMapping("/getByName")
    public R<List<CrObserveIn>> getByName(String name){
        return R.ok(crObserveInService.getCrObserveInByName(name));
    }

}
