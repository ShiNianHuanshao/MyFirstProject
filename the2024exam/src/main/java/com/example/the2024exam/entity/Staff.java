package com.example.the2024exam.entity;

import com.baomidou.mybatisplus.annotation.TableName;

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
 * @since 2024-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("staff")
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private String identity;


}
