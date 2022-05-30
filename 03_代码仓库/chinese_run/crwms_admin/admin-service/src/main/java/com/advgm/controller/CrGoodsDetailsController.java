package com.advgm.controller;
import com.advgm.domain.CrGoodsDetails;
import com.advgm.domain.Driver;
import com.advgm.model.R;
import com.advgm.service.CrGoodsDetailsService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* (cr_wms.cr_goods_details)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/goods_details")
public class CrGoodsDetailsController {
    /**
     * 服务对象
     */
    @Resource
    private CrGoodsDetailsService crGoodsDetailsService;
@GetMapping("/info")
@ApiOperation(value = "商品信息查询")
@ApiImplicitParams({
        @ApiImplicitParam(name = "current" ,value = "当前页") ,
        @ApiImplicitParam(name = "size" ,value = "每页显示的大小") ,
})
public R<Page<CrGoodsDetails>> getInformationByPage(Page<CrGoodsDetails> page){
    return R.ok(crGoodsDetailsService.queryAllCrGoodsDetails(page));
}
    @PostMapping("/add")
    public R<String> addDriver(@RequestBody CrGoodsDetails crGoodsDetails){
        int i = crGoodsDetailsService.addCrGoodsDetails(crGoodsDetails);
        if(i==0){
            return R.ok("添加失败");
        }
        return R.ok("添加成功");
    }
    @DeleteMapping("/del")
    public R<String> deleteDriver(long id){
        int i = crGoodsDetailsService.deleteCrGoodsDetailsById(id);
        if(i==0){
            return R.ok("删除失败");
        }
        return R.ok("删除成功");
    }
    @PutMapping("/update")
    public R<String> update(@RequestBody CrGoodsDetails crGoodsDetails){
        int i = crGoodsDetailsService.updateCrGoodsDetailsById(crGoodsDetails);
        if(i==0){
            return R.ok("更新失败");
        }
        return R.ok("更新成功");
    }
    @GetMapping("/getById")
    public R<CrGoodsDetails> getDriverById(Long id){
        CrGoodsDetails byId = crGoodsDetailsService.getCrGoodsDetailsById(id);
        return R.ok(byId);
    };
    @GetMapping("/getByName")
    public List<CrGoodsDetails> getCrGoodsDetailsByName(String name){
        return crGoodsDetailsService.getCrGoodSDetailsByName(name);
    }
}