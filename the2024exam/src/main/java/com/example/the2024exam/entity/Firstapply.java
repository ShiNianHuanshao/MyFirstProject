package com.example.the2024exam.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Arrays;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xue
 * @since 2024-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("firstapply")
public class Firstapply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("name")
    private String name;

    @TableField("number")
    private String number;

    @TableField("major")
    private String major;

    @TableField("score")
    private String score;

    @TableField("current")
    private String current;

    @TableField("english")
    private String english;

    @TableField("math")
    private String math;

    @TableField("majorscore")
    private String majorscore;

    @TableField("state")
    private String state;

    @TableField("because")
    private String because;

    @TableField("button")
    private String button;

    @TableField("firstteacher")
    private String firstteacher;

    @TableField("secondteacher")
    private String secondteacher;

    @TableField("thirdteacher")
    private String thirdteacher;

    @TableField(exist = false)
    private String average;

    @TableField("fistername")
    private String fistername;

    @TableField("secondname")
    private String secondname;

    @TableField("thirdname")
    private String thirdname;

    @TableField("apply")
    private String apply;

    @TableField("time")
    private String time;
    public void calculateAndSetAverageFromTeachers() {
        int firstTeacherValue = 0;
        int secondTeacherValue = 0;
        int thirdTeacherValue=0;
        // 假设 firstteacher、secondteacher 和 thirdteacher 的值是作为字符串表示的有效整数
        if (firstteacher!= null&&secondteacher!=null&&thirdteacher!=null)
        // Convert string values to integers
        {
             firstTeacherValue = Integer.parseInt(firstteacher);
           secondTeacherValue = Integer.parseInt(secondteacher);
           thirdTeacherValue = Integer.parseInt(thirdteacher);
        }

        // Calculate the average
        int[] values = {firstTeacherValue, secondTeacherValue, thirdTeacherValue};
        int sum = Arrays.stream(values).sum();
        int averageValue = sum / values.length;

        // Assign the average to the transient field
        setAverage(String.valueOf(averageValue));}

}
