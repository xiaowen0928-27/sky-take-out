package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

import java.util.List;

/**
 * @author xiaowen
 * @version 1.0
 */
public interface SetmealService {
    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    void saveWithDish(SetmealDTO setmealDTO);

    void setStatus(Integer status, Long id);

    SetmealVO getByIdWithDish(Long id);

    void update(SetmealDTO setmealDTO);

    void deleteBatch(List<Long> ids);
}
