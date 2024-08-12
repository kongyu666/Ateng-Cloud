package io.github.kongyu666.common.core.config;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfiguration;

/**
 * 全局配置fastjson2特性
 *
 * @author 孔余
 * @email 2385569970@qq.com
 * @date 2024-06-21 11:38:11
 */
@AutoConfiguration
public class MyFastJson2Config implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        JSON.config(
                JSONWriter.Feature.WriteNulls, // 将String类型字段的空值序列化输出为空字符串""
                JSONWriter.Feature.FieldBased, // 基于字段序列化，如果不配置，会默认基于public的field和getter方法序列化。配置后，会基于非static的field（包括private）做序列化。
                JSONWriter.Feature.BrowserCompatible, // 在大范围超过JavaScript支持的整数，输出为字符串格式
                JSONWriter.Feature.WriteMapNullValue,
                JSONWriter.Feature.NullAsDefaultValue // 将空置输出为缺省值，Number类型的null都输出为0，String类型的null输出为""，数组和Collection类型的输出为[]
        );

        JSON.config(
                JSONReader.Feature.FieldBased, // 基于字段反序列化，如果不配置，会默认基于public的field和getter方法序列化。配置后，会基于非static的field（包括private）做反序列化。在fieldbase配置下会更安全
                JSONReader.Feature.InitStringFieldAsEmpty, // 初始化String字段为空字符串""
                JSONReader.Feature.SupportArrayToBean, // 支持数据映射的方式
                JSONReader.Feature.UseBigDecimalForDoubles // 默认配置会使用BigDecimal来parse小数，打开后会使用Double
        );
    }
}
