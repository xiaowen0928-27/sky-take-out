package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;

import java.util.List;

/**
 * @author xiaowen
 * @version 1.0
 */
public interface DishService {


    /**
     * 新增菜品，同时保存对应的口味数据
     * @param dishDTO 菜品 数据
     */
    public void saveWithFlavor(DishDTO dishDTO);

    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    void deleteBatch(List<Long> ids);

    void startOrStop(Integer status, Long id);
}
