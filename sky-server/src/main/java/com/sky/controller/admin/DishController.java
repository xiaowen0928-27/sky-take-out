package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiaowen
 * @version 1.0
 * 菜品管理
 */
@RestController
@RequestMapping("/admin/dish")
@Api(tags = "菜品相关接口")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    /**
     * 新增菜品
     *
     * @param dishDTO 菜品DTO
     * @return Result
     */
    @ApiOperation("新增菜品")
    @PostMapping
    public Result<T> save(@RequestBody DishDTO dishDTO) {
        log.info("新增菜品: {}", dishDTO);
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }

    /**
     * 菜品分页查询
     *
     * @param dishPageQueryDTO 菜品分页查询DTO
     * @return Result
     */
    @GetMapping("/page")
    @ApiOperation("菜品分页查询")
    public Result<PageResult> pageQuery(DishPageQueryDTO dishPageQueryDTO) {
        log.info("分页查询: {}", dishPageQueryDTO);
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }


    @DeleteMapping
    @ApiOperation("删除菜品")
    public Result<T> delete(@RequestParam List<Long> ids) {
        log.info("删除菜品: {}", ids);
        dishService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 起售、停售菜品
     *
     * @param status 状态
     * @param id     菜品id
     * @return Result
     */
    @PostMapping("/status/{status}")
    @ApiOperation("起售、停售菜品")
    public Result<T> startOrStop(@PathVariable Integer status, Long id) {
        log.info("起售、停售菜品: {}, {}", status, id);
        dishService.startOrStop(status, id);
        return Result.success();
    }

    /**
     * 根据id查询菜品和对应的口味
     *
     * @param id 菜品id
     * @return Result
     */
    @GetMapping("/{id}")
    public Result<DishVO> getById(@PathVariable Long id) {
        log.info("根据id查询菜品: {}", id);
        DishVO dishVO = dishService.getByIdWithFlavor(id);
        return Result.success(dishVO);
    }

    @PutMapping
    @ApiOperation("修改菜品")
    public Result<T> update(@RequestBody DishDTO dishDTO) {
        log.info("修改菜品: {}", dishDTO);
        dishService.updateWithFlavor(dishDTO);
        return Result.success();
    }
}
