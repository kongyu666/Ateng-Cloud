package io.github.kongyu666.example.mybatisflex;

import com.alibaba.druid.pool.DruidDataSource;
import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.ColumnConfig;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.core.BaseMapper;
import com.mybatisflex.core.service.IService;
import com.mybatisflex.spring.service.impl.ServiceImpl;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

/**
 * 在 mybatis-flex 的模块 mybatis-flex-codegen 中，提供了可以通过数据库表，生成 Entity 类和 Mapper 类的功能。
 * 当我们把数据库表设计完成 后可以使用其快速生成 Entity 和 Mapper 的 java 类。
 * https://mybatis-flex.com/zh/others/codegen.html
 *
 * @author 孔余
 * @since 2024-02-19 10:56
 */
public class MybatisFlexGenerator {
    // 生成的包路径
    private static final String BasePackage = "io.github.kongyu666.example.system";
    // 需要生成的表
    private static final List<String> GenerateTable = Arrays.asList(
            "sys_user"
    );
    // 不需要生成的表（排除）
    private static final List<String> UnGenerateTable = Arrays.asList(
            "test", "demo", "spatial_ref_sys"
    );


    public static void main(String[] args) {
        //配置数据源
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:postgresql://192.168.1.10:32297/lx_facility?currentSchema=public");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Lingo@local_postgresql_5432");

        //创建配置内容，两种风格都可以。
        GlobalConfig globalConfig = createGlobalConfigUseStyle();

        //通过 datasource 和 globalConfig 创建代码生成器
        Generator generator = new Generator(dataSource, globalConfig);

        //生成代码
        generator.generate();
    }

    public static GlobalConfig createGlobalConfigUseStyle() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        //设置代码路径和根包
        globalConfig.getPackageConfig()
                .setSourceDir(getModulePath() + "/src/main/java")
                .setBasePackage(BasePackage);
        //.setMapperXmlPath(System.getProperty("user.dir") + "/src/main/resources/mapper");

        // 设置生成 Entity 并启用 Lombok
        globalConfig.enableEntity()
                .setWithLombok(true);
        // 启用 Mapper 生成
        globalConfig.enableMapper();
        // 启用 Service 生成
        globalConfig.enableService();
        // 启用 ServiceImpl 生成
        globalConfig.enableServiceImpl();
        // 启用 Controller 生成
        globalConfig.enableController();
        // 启用 TableDef 生成
        //globalConfig.enableTableDef();
        // 启用 MapperXml 生成
        //globalConfig.enableMapperXml();

        // 注释配置 JavadocConfig
        globalConfig.getJavadocConfig()
                .setAuthor("孔余")
                .setSince("1.0.0");

        //设置项目的JDK版本，项目的JDK为14及以上时建议设置该项，小于14则可以不设置
        globalConfig.setEntityJdkVersion(21);

        // 策略配置 StrategyConfig，setGenerateTables 和 setUnGenerateTables 未配置时，生成所有表。
        globalConfig.getStrategyConfig()
                .setGenerateTable(GenerateTable.toArray(new String[0])) // 生成哪些表，白名单
                .setUnGenerateTable(UnGenerateTable.toArray(new String[0])); // 不生成哪些表，黑名单

        // Entity 生成配置 EntityConfig
        globalConfig.getEntityConfig()
                .setWithLombok(true)
                .setClassPrefix("")
                .setClassSuffix("")
                .setOverwriteEnable(false);
        // Mapper 生成配置 MapperConfig
        globalConfig.getMapperConfig()
                .setClassPrefix("")
                .setClassSuffix("Mapper")
                .setSuperClass(BaseMapper.class)
                .setMapperAnnotation(false)
                .setOverwriteEnable(false);
        // Service 生成配置 ServiceConfig
        globalConfig.getServiceConfig()
                .setClassPrefix("")
                .setClassSuffix("Service")
                .setSuperClass(IService.class)
                .setOverwriteEnable(false);
        // ServiceImpl 生成配置 ServiceImplConfig
        globalConfig.getServiceImplConfig()
                .setClassPrefix("")
                .setClassSuffix("ServiceImpl")
                .setSuperClass(ServiceImpl.class)
                .setCacheExample(false)
                .setOverwriteEnable(false);
        // Controller 生成配置 ControllerConfig
        globalConfig.getControllerConfig()
                .setClassPrefix("")
                .setClassSuffix("Controller")
                .setRestStyle(true)
                .setOverwriteEnable(false);
        // 返回配置
        return globalConfig;
    }

    public static GlobalConfig createGlobalConfigUseStyle1() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        //设置代码路径和根包
        globalConfig.getPackageConfig()
                .setSourceDir(System.getProperty("user.dir") + "\\target")
                .setBasePackage("local.kongyu.test");

        //设置表前缀和只生成哪些表
        globalConfig.setTablePrefix("tb_");
        globalConfig.setGenerateTable("books", "borrowings", "returns", "users");

        //设置生成 entity 并启用 Lombok
        globalConfig.setEntityGenerateEnable(true);
        globalConfig.setEntityWithLombok(true);
        //设置项目的JDK版本，项目的JDK为14及以上时建议设置该项，小于14则可以不设置
        //globalConfig.setJdkVersion(17);

        //设置生成 mapper
        globalConfig.setMapperGenerateEnable(true);
        globalConfig.setServiceGenerateEnable(true);
        globalConfig.setControllerGenerateEnable(true);
        globalConfig.setTableDefGenerateEnable(true);

        //可以单独配置某个列
        ColumnConfig columnConfig = new ColumnConfig();
        columnConfig.setColumnName("tenant_id");
        columnConfig.setLarge(true);
        columnConfig.setVersion(true);
        globalConfig.setColumnConfig("tb_account", columnConfig);

        return globalConfig;
    }

    public static GlobalConfig createGlobalConfigUseStyle2() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        //设置根包
        globalConfig.getPackageConfig()
                .setBasePackage("com.test");

        //设置表前缀和只生成哪些表，setGenerateTable 未配置时，生成所有表
        globalConfig.getStrategyConfig()
                .setTablePrefix("tb_")
                .setGenerateTable("tb_account", "tb_account_session");

        //设置生成 entity 并启用 Lombok
        globalConfig.enableEntity()
                .setWithLombok(true)
                .setJdkVersion(17);

        //设置生成 mapper
        globalConfig.enableMapper();

        //可以单独配置某个列
        ColumnConfig columnConfig = new ColumnConfig();
        columnConfig.setColumnName("tenant_id");
        columnConfig.setLarge(true);
        columnConfig.setVersion(true);
        globalConfig.getStrategyConfig()
                .setColumnConfig("tb_account", columnConfig);

        return globalConfig;
    }

    /**
     * 获取当前模块的路径
     *
     * @return
     */
    public static String getModulePath() {
        // 获取当前类的路径
        String path = null;
        try {
            path = MybatisFlexGenerator.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        // 获取父目录（模块目录）
        File moduleDir = new File(path).getParentFile();
        return moduleDir.getPath().replace("\\target", "");
    }
}
