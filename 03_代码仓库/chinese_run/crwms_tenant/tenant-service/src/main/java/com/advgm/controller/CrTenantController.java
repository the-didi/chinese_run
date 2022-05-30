package com.advgm.controller;

import com.advgm.domain.CrTenant;
import com.advgm.model.R;
import com.advgm.service.CrTenantService;
import com.advgm.util.NoUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (cr_wms.cr_tenant)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/cr_tenant")
public class CrTenantController {
    /**
     * 服务对象
     */
    @Resource
    private CrTenantService crTenantService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CrTenant selectOne(Integer id) {
        return crTenantService.getById(id);
    }

    /**
     * 分页查询
     *
     * @param page
     * @param tenantName
     * @return
     */
    @GetMapping
    @ApiOperation(value = "分页查询租户数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页"),
            @ApiImplicitParam(name = "size", value = "大小"),
            @ApiImplicitParam(name = "tenantName", value = "租户名称")
    })
    public R<Page<CrTenant>> findByPage(Page<CrTenant> page, String tenantName) {
        return R.ok(crTenantService.findByPage(page, tenantName));
    }

    /**
     * 更具ID删除数据
     *
     * @param id
     * @return
     */
    @DeleteMapping
    @ApiOperation(value = "更具ID删除租户数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "租户ID")
    })
    public R<String> deleteById(Long id) {
        boolean b = crTenantService.removeById(id);
        if (b) {
            return R.ok("删除成功");
        } else {
            return R.fail("删除失败");
        }
    }

    /**
     * 新增一条数据
     *
     * @param crTenant
     * @return
     */
    @PostMapping
    @ApiOperation(value = "新增一条数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tenant", value = "CR_TENANT的JSON数据")
    })
    public R<String> save(@RequestBody CrTenant crTenant) {
        crTenant.setTenantNo(NoUtils.getNo("tenant"));
        boolean save = crTenantService.save(crTenant);
        if (save) {
            return R.ok("添加成功");
        } else {
            return R.fail("添加失败");
        }
    }

    @PutMapping
    @ApiOperation(value = "修改一条数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tenant", value = "crTenant的JSON数据")
    })
    public R<String> edit(CrTenant crTenant) {
        boolean update = crTenantService.updateById(crTenant);
        if (update) {
            return R.ok("修改成功");
        } else {
            return R.fail("修改失败");
        }

    }

}
