package com.example.the2024exam.controller;


import com.example.the2024exam.entity.Firstapply;
import com.example.the2024exam.entity.Needstudent;
import com.example.the2024exam.service.IFirstapplyService;
import com.example.the2024exam.service.INeedstudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xue
 * @since 2024-02-27
 */
@RestController
@RequestMapping
public class NeedstudentController {
    @Autowired
    INeedstudentService needstudentService;
    @CrossOrigin
    @PostMapping("/insertneedstudent")
    public void insertneedstudent(@RequestBody Needstudent needstudent)
    {
        needstudentService.save(needstudent);

    }
    @CrossOrigin
    @PostMapping("/seekstudentneed")
    public List<Needstudent> seekStudentNeed() {
        return needstudentService.list();
}

}

