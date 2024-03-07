package com.example.the2024exam.mapper;

import com.example.the2024exam.entity.Firstapply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xue
 * @since 2024-02-27
 */
public interface FirstapplyMapper extends BaseMapper<Firstapply> {
    int updateById(Firstapply firstapply);
}
