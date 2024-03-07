package com.example.the2024exam.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
@TableName("needstudent")
public class Needstudent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("major")
    private String major;

    @TableField("number")
    private String number;

    @TableField("scoreneed")
    private String scoreneed;

    @TableField("politics")
    private String politics;

    @TableField("english")
    private String english;

    @TableField("math")
    private String math;

    @TableField("deadline")
    private String deadline;


}
