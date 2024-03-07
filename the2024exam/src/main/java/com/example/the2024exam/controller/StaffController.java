package com.example.the2024exam.controller;


import com.example.the2024exam.entity.Staff;
import com.example.the2024exam.mapper.StaffMapper;
import com.example.the2024exam.service.IStaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xue
 * @since 2024-02-25
 */
@RestController
@RequestMapping
@RequiredArgsConstructor
public class StaffController {
    private final IStaffService staffService;
    private final StaffMapper staffmapper;
    @CrossOrigin
    @PostMapping("/stafflogin")
    public Map<String, Object> stafflogin(@RequestBody Map<String, Object> requestData)
    {
        String userid = requestData.get("userid").toString();
        String password = requestData.get("password").toString();
        Staff staff =staffService.queryagent(userid,password);
        if(staff==null)
        {
            return null;
        }
        String state=staff.getIdentity();
        Map<String, Object> response = new HashMap<>();
        response.put("data", state);
        return response;
    }


}
