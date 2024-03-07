package com.example.the2024exam.service;

import com.example.the2024exam.entity.Staff;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xue
 * @since 2024-02-25
 */
public interface IStaffService extends IService<Staff> {

    Staff queryagent(String userid, String password);
}
