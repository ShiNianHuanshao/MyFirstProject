package com.example.the2024exam.controller;


import com.example.the2024exam.entity.Firstapply;
import com.example.the2024exam.entity.Staff;
import com.example.the2024exam.service.IFirstapplyService;
import com.example.the2024exam.service.impl.StaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
public class FirstapplyController {
    @Autowired
    IFirstapplyService firstapplyService;
    @Autowired
    StaffServiceImpl staffService;
    @CrossOrigin
    @PostMapping("/insertfirstapply")
    public void insertfirstapply(@RequestBody Firstapply firstapply)
    {
        List<String> randomTeachers = staffService.getRandomTeachers(3);
        firstapply.setFistername(randomTeachers.get(0));
        firstapply.setSecondname(randomTeachers.get(1));
        firstapply.setThirdname(randomTeachers.get(2));
        firstapplyService.save(firstapply);
    }
    @CrossOrigin
    @PostMapping("/checkresult")
    public String checkresult(@RequestBody Map<String, String> requestMap) {
        String userId = requestMap.get("userid");
        Firstapply firstapply=firstapplyService.findOneByusername(userId);
        String result=firstapply.getState();
        String re;
        if(Objects.equals(result, "3"))
            re="通过";
                    else re="不通过";
        return re;
    }
    @CrossOrigin
    @PostMapping("/checkfirstresult")
    public Firstapply checkfirstresult(@RequestBody Map<String, String> requestMap) {
        String userId = requestMap.get("userid");
        Firstapply firstapply=firstapplyService.findOneByusername(userId);
        return firstapply;
    }
    @CrossOrigin
    @PostMapping("/updatefirstapply")
    public void updatefirstapply(@RequestBody Firstapply firstapply)
    {
        firstapplyService.updateById(firstapply);
        firstapply.calculateAndSetAverageFromTeachers();
    }
    @CrossOrigin
    @PostMapping("/updatefirstapplystudent")
    public void updatefirstapplystudent(@RequestBody Firstapply firstapply)
    {
        firstapplyService.updateById(firstapply);}
    @CrossOrigin
    @PostMapping("/seekstudentneedbyteacher")
    public Firstapply seekstudentneedbyteacher(@RequestBody Map<String, String> requestMap) {
        String username = requestMap.get("username").toString();
        System.out.println(username);
        System.out.println(firstapplyService.findOneByFirstteacher(username));
        return firstapplyService.findOneByFirstteacher(username);}
    @CrossOrigin
    @PostMapping("/changescore")
    public void changescore(@RequestBody Map<String, String> requestMap)
    {
        String userId = requestMap.get("userid");
        firstapplyService.Updatefirstapply(userId);
    }
    @CrossOrigin
    @PostMapping("/checkbyteacher")
    public Firstapply checkbyteacher() {
        return firstapplyService.findOneByapply();}
    @CrossOrigin
    @PostMapping("/changefirstapply")
    public List<Firstapply> changefirstapply() {
        firstapplyService.getAllDataDescendingOrder();

        firstapplyService.updateCurrentAndSortByScore(1);
        List<Firstapply> firstapplies=firstapplyService.list();
        return firstapplies;
        }
    @CrossOrigin
    @PostMapping("/changesecondtapply")
    public List<Firstapply> changesecondtapply(String number) {
        firstapplyService.updatesecondapply(number);
        List<Firstapply> firstapplies=firstapplyService.getAllDataDescendingOrder();
        return firstapplies;
    }
    @CrossOrigin
    @PostMapping("/changethirdapply")
    public List<Firstapply> changethirdapply(@RequestBody Map<String, String> requestMap) {

        String number = requestMap.get("number").toString();
        firstapplyService.updatethirdapply(number);
        List<Firstapply> firstapplies=firstapplyService.getAllDataDescendingOrder();
        return firstapplies;
    }
}
