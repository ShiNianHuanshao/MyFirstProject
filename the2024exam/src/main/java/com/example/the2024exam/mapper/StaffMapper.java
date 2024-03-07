package com.example.the2024exam.mapper;

import com.example.the2024exam.entity.Firstapply;
import com.example.the2024exam.entity.Staff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xue
 * @since 2024-02-25
 */
public interface StaffMapper extends BaseMapper<Staff> {
    Firstapply selectOneByFirstteacher(String firstteacher);
}
