package com.advgm.controller;
import com.advgm.domain.CrBaseGoods;
import com.advgm.domain.Driver;
import com.advgm.model.R;
import com.advgm.service.DriverService;
import com.advgm.service.CrBaseGoodsService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/base_goods")
public class CrBaseGoodsController {
@Resource
private CrBaseGoodsService crBaseGoodsService;

    @GetMapping("/info")
    public R<Page<CrBaseGoods>> getInformationByPage(Page<CrBaseGoods> page){
        return R.ok(crBaseGoodsService.queryAllDrivers(page));
    }
    @PostMapping("/add")
    public R<String> add(@RequestBody CrBaseGoods crBaseGoods){
        int i = crBaseGoodsService.addCrBaseGoods(crBaseGoods);
        if(i==0){
            return R.ok("添加失败");
        }
        return R.ok("添加成功");
    }
    @DeleteMapping("/del")
    public R<String> delete(long id){
        int i =crBaseGoodsService.deleteCrBaseGoodsById(id);
        if(i==0){
            return R.ok("删除失败");
        }
        return R.ok("删除成功");
    }
    @PutMapping("/update")
    public R<String> update(@RequestBody CrBaseGoods crBaseGoods){
        int i =crBaseGoodsService.updateCrBaseGoodsById(crBaseGoods);
        if(i==0){
            return R.ok("更新失败");
        }
        return R.ok("更新成功");
    }
    @GetMapping("/getById")
    public R<CrBaseGoods> getById(Long id){
        CrBaseGoods byId = crBaseGoodsService.getCrBaseGoodsById(id);
        return R.ok(byId);
    };
    @GetMapping("/getByName")
    public List<CrBaseGoods> getByName(String name){
        return crBaseGoodsService.getCrBaseGoodsByName(name);
    }
}
