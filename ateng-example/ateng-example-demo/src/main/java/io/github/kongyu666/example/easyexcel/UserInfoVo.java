package io.github.kongyu666.example.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

import java.util.Date;

/**
 * 类的模板注释
 *
 * @author 孔余
 * @since 2024-02-05 22:21
 */
@Data
public class UserInfoVo {
    @ExcelProperty(value = "用户ID", index = 0)
    private Long id;
    @ExcelProperty(value = "用户姓名", index = 1)
    @ColumnWidth(15)
    private String name;
    @ExcelProperty(value = "用户年龄", index = 2)
    @ColumnWidth(15)
    private Integer age;
    @ExcelProperty(value = "分数", index = 3)
    //@NumberFormat(value = "#.##%",roundingMode = RoundingMode.HALF_UP) //数字格式化
    private Double score;
    @ExcelProperty(value = "用户生日", index = 4)
    @DateTimeFormat("yyyy年MM月dd日 HH时mm分ss秒")
    @ColumnWidth(35)
    private Date birthday;
    @ExcelProperty(value = "用户所在省份", index = 5)
    @ColumnWidth(20)
    private String province;
    @ExcelProperty(value = "用户所在城市", index = 6)
    @ColumnWidth(20)
    private String city;
}
