package com.advgm.controller;

import com.advgm.domain.Driver;
import com.advgm.model.R;
import com.advgm.service.DriverService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 袁鹏
 * @date 2022年05月03日 14:51
 */
@RestController
@RequestMapping("/driver")
@Api(tags="司机管理")
public class DriverController {
    @Autowired
    private DriverService driverService;
    @GetMapping("/info")
    @ApiOperation(value = "司机信息查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current" ,value = "当前页") ,
            @ApiImplicitParam(name = "size" ,value = "每页显示的大小") ,
    })
    public R<Page<Driver>> getInformationByPage(Page<Driver> page){
        return R.ok(driverService.queryAllDrivers(page));
    }
    @PostMapping("/add")
    @ApiOperation(value = "添加司机")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value = "司机姓名"),
            @ApiImplicitParam(name="sex",value = "司机性别"),
            @ApiImplicitParam(name = "age",value = "司机年龄"),
            @ApiImplicitParam(name = "tel", value = "司机电话号码"),
            @ApiImplicitParam(name = "carId" , value = "司机车牌号")

    })
    public R<String> addDriver(@RequestBody Driver driver){
        int i = driverService.addDriver(driver);
        if(i==0){
            return R.ok("添加失败");
        }
        return R.ok("添加成功");
    }
    @DeleteMapping("/del")
    @ApiOperation(value = "通过编号删除司机")
    @ApiImplicitParam(name = "id",value = "司机编号")
    public R<String> deleteDriver(long id){
        int i = driverService.deleteDriverById(id);
        if(i==0){
            return R.ok("删除失败");
        }
        return R.ok("删除成功");
    }
    @PutMapping("/update")
    @ApiOperation(value = "修改司机信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" , value = "司机编号"),
            @ApiImplicitParam(name="name",value = "司机姓名"),
            @ApiImplicitParam(name="sex",value = "司机性别"),
            @ApiImplicitParam(name = "age",value = "司机年龄"),
            @ApiImplicitParam(name = "tel", value = "司机电话号码"),
            @ApiImplicitParam(name = "carId" , value = "司机车牌号")

    })
    public R<String> updateDriver(@RequestBody Driver driver){
        System.out.println(driver);
        int i = driverService.updateDriverById(driver);
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
  public R<Driver> getDriverById(Long id){
        Driver byId = driverService.getDriverById(id);
        return R.ok(byId);
  };
    @GetMapping("/getByName")
    @ApiOperation(value = "通过姓名查询司机信息")
    public List<Driver> getDriverByName(String name){
        return driverService.getDriverByName(name);
    }
}