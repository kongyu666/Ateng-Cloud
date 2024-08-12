package io.github.kongyu666.common.mybatisflex.config;

import com.mybatisflex.core.audit.AuditManager;
import io.github.kongyu666.common.core.factory.YmlPropertySourceFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@AutoConfiguration
@MapperScan("io.github.kongyu666.**.mapper")
@PropertySource(value = "classpath:common-mf.yml", factory = YmlPropertySourceFactory.class)
public class MyBatisFlexConfiguration {

    private static final Logger logger = LoggerFactory.getLogger("mybatis-flex-sql");

    // SQL 日志打印
    public MyBatisFlexConfiguration() {
        //开启审计功能
        AuditManager.setAuditEnable(true);

        //设置 SQL 审计收集器
        AuditManager.setMessageCollector(auditMessage -> logger.info("访问数据库 ==> Time={}ms, SQL={}", auditMessage.getElapsedTime(), auditMessage.getFullSql()));
    }
}
