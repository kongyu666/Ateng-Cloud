package io.github.kongyu666.common.core.utils;

import io.github.kongyu666.common.core.enums.DeviceType;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 关于Http相关的工具类
 *
 * @author 孔余
 * @since 2024-05-24 10:45
 */

public class HttpUtils {
    /**
     * 获取当前的 HttpServletRequest 对象
     *
     * @return 当前的 HttpServletRequest 对象，如果不存在则返回 null
     */
    public static HttpServletRequest getCurrentHttpRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            return ((ServletRequestAttributes) requestAttributes).getRequest();
        }
        return null;
    }

    /**
     * 识别客户端类型
     *
     * @return 客户端类型的字符串表示：PC、App、WeChat Mini Program、Alipay Mini Program 或 Unknown
     */
    public static String getClientType() {
        HttpServletRequest request = getCurrentHttpRequest();
        if (request == null) {
            return "Unknown";
        }

        String userAgent = request.getHeader("User-Agent");
        String clientType = request.getHeader("X-Client-Type");

        if (clientType != null) {
            return clientType;
        } else if (userAgent != null) {
            if (userAgent.contains("MicroMessenger")) {
                return DeviceType.WXXCX.getDevice();
            } else if (userAgent.contains("AlipayClient")) {
                return DeviceType.ZFBXCX.getDevice();
            } else if (userAgent.contains("Mobile") || userAgent.contains("Android") || userAgent.contains("iPhone")) {
                return DeviceType.APP.getDevice();
            } else {
                return DeviceType.PC.getDevice();
            }
        }
        return "Unknown";
    }
}

