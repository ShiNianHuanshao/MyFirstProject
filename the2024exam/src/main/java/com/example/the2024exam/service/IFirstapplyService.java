package com.example.the2024exam.service;

import com.example.the2024exam.entity.Firstapply;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xue
 * @since 2024-02-27
 */
public interface IFirstapplyService extends IService<Firstapply> {

    Firstapply findOneByFirstteacher(String userId);

    Firstapply findOneByusername(String userId);

    void Updatefirstapply(String userId);

    Firstapply findOneByapply();

    List<Firstapply> getAllDataDescendingOrder();

    void updateCurrentAndSortByScore(int i);

    void updatesecondapply(String number);

    void updatethirdapply(String number);
}
