package io.github.kongyu666.example.easyexcel;

import cn.hutool.core.date.DateUtil;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的模板注释
 *
 * @author 孔余
 * @since 2024-01-18 14:17
 */
@Getter
public class InitData {
    List<UserInfoEntity> list = new ArrayList<>();

    public InitData(Integer count) {
        //生成测试数据
        // 创建一个Java Faker实例，指定Locale为中文
        // 创建一个包含不少于100条JSON数据的列表
        for (int i = 1; i <= count; i++) {
            UserInfoEntity user = new UserInfoEntity();
            user.setId((long) i);
            user.setName("阿腾" + i);
            user.setBirthday(DateUtil.date());
            user.setAge(i);
            user.setProvince("阿腾" + i);
//            user.setCity(faker.address().cityName());
//            user.setScore(faker.number().randomDouble(3, 1, 100));
            list.add(user);
        }
    }

}
