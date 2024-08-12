package io.github.kongyu666.common.core.enums;

/**
 * 业务操作类型
 *
 * @author ruoyi
 */
public interface BusinessType {
    /**
     * 其它
     */
    String OTHER = "其它";

    /**
     * 查询
     */
    String GET = "查询";

    /**
     * 新增
     */
    String ADD = "新增";

    /**
     * 修改
     */
    String UPDATE = "修改";

    /**
     * 删除
     */
    String DELETE = "删除";

    /**
     * 授权
     */
    String GRANT = "授权";

    /**
     * 导出
     */
    String EXPORT = "导出";

    /**
     * 导入
     */
    String IMPORT = "导入";

    /**
     * 强退
     */
    String FORCE = "强退";

    /**
     * 生成代码
     */
    String GENCODE = "生成代码";

    /**
     * 清空数据
     */
    String CLEAN = "清空数据";
}
