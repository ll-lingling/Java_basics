package com.lagou.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 薪资视图对象
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryVo {
    private String cityName;
    private double salary;
}