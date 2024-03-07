package com.example.the2024exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.the2024exam.entity.Firstapply;
import com.example.the2024exam.mapper.FirstapplyMapper;
import com.example.the2024exam.service.IFirstapplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xue
 * @since 2024-02-27
 */
@Service
public class FirstapplyServiceImpl extends ServiceImpl<FirstapplyMapper, Firstapply> implements IFirstapplyService {
    @Autowired
    private FirstapplyMapper firstapplyMapper;

    // 根据 firstteacher 查询一条记录
    public Firstapply findOneByFirstteacher(String firstteacher) {
        String a="0";
        QueryWrapper<Firstapply> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("fistername", firstteacher)
                .eq("firstteacher",a)
                .eq("state","1");

        Firstapply firstTeacherResult = firstapplyMapper.selectOne(queryWrapper);

        if (firstTeacherResult == null) {
            // 如果在 firstteacher 中找不到，则在 secondteacher 中查找
            queryWrapper.clear();
            queryWrapper.eq("secondname", firstteacher).eq("secondteacher",a).eq("state","1");
            Firstapply secondTeacherResult = firstapplyMapper.selectOne(queryWrapper);

            if (secondTeacherResult == null) {
                // 如果在 secondteacher 中找不到，则在 thirdteacher 中查找
                queryWrapper.clear();
                queryWrapper.eq("thirdname", firstteacher).eq("thirdteacher",a).eq("state","1");
                System.out.println(firstteacher);
                return  lambdaQuery().eq(Firstapply::getThirdname,firstteacher).one();
            } else {
                return secondTeacherResult;
            }
        } else {
            return firstTeacherResult;
        }
    }


    @Override
    public Firstapply findOneByusername(String userId) {
        return lambdaQuery().eq(userId!=null, Firstapply::getNumber, userId )
                .one();
    }

    @Override
    public void Updatefirstapply(String userId) {
        String a="1";
        lambdaUpdate().set(Firstapply::getApply,a)
                .eq(Firstapply::getNumber,userId);
    }

    @Override
    public Firstapply findOneByapply() {
        String a="1";
        return lambdaQuery().eq(Firstapply::getApply,a)
                .one();
    }
    public List<Firstapply> getAllDataDescendingOrder() {
        // 查询所有数据并按 score 字段降序排列
        List<Firstapply> result = firstapplyMapper.selectList(
                new QueryWrapper<Firstapply>().orderByDesc("score")
        );

        return result;
    }
    public void updateCurrentAndSortByScore(int numberOfPeopleToUpdate) {
        // 查询指定数量的记录并按 score 降序排列
        List<Firstapply> firstapplyList = firstapplyMapper.selectList(
                new QueryWrapper<Firstapply>()
                        .orderByDesc("score")
                        .last("LIMIT " + numberOfPeopleToUpdate)
        );

        // 将给定人数的 current 改为 1
        firstapplyList.forEach(firstapply -> firstapply.setState("1"));

        // 更新数据库中的记录
        firstapplyList.forEach(firstapplyMapper::updateById);
    }

    @Override
    public void updatesecondapply(String number) {
        String a="2";
        lambdaUpdate().set(Firstapply::getState,a)
                .eq(Firstapply::getNumber,number)
                .update();
    }

    @Override
    public void updatethirdapply(String number) {
        System.out.println(number);
        String a="3";
        lambdaUpdate().set(Firstapply::getState,a)
                .eq(Firstapply::getNumber,number)
                .update();
    }
}
