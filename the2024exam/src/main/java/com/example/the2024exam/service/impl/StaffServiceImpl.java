package com.example.the2024exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.the2024exam.entity.Staff;
import com.example.the2024exam.mapper.StaffMapper;
import com.example.the2024exam.service.IStaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xue
 * @since 2024-02-25
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements IStaffService {

    @Override
    public Staff queryagent(String userid, String password) {
        return lambdaQuery()
                .eq(userid !=null, Staff::getUsername,userid)
                .like(password !=null,Staff::getPassword,password)
                .one();
    }


    @Autowired
   StaffMapper staffMapper;

    public List<String> getRandomTeachers(int count) {
        List<Staff> allTeachers = staffMapper.selectList(new QueryWrapper<Staff>().eq("identity", "teacher"));

        if (allTeachers.size() < count) {
            throw new IllegalArgumentException("Not enough teachers in the database");
        }

        List<String> randomTeachers = new ArrayList<>();
        List<Staff> remainingTeachers = new ArrayList<>(allTeachers);

        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int randomIndex = random.nextInt(remainingTeachers.size());
            Staff selectedTeacher = remainingTeachers.get(randomIndex);
            randomTeachers.add(selectedTeacher.getUsername());
            remainingTeachers.remove(randomIndex);
        }

        return randomTeachers;
    }

}
