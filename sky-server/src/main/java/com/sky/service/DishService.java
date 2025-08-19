package com.sky.service;

import com.sky.dto.DishDTO;

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
}
