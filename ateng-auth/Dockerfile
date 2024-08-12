# 环境
FROM registry.lingo.local/service/java:debian12_temurin_openjdk-jdk-21-jre_dev

# 定义变量
ARG JAR_FILE=ateng-auth-1.0.0.jar

# 设置工作目录并拷贝数据
WORKDIR /opt
COPY --chown=1001:1001 target/${JAR_FILE} ${JAR_FILE}
COPY --chown=1001:1001 docker-entrypoint.sh docker-entrypoint.sh

# 设置环境变量
ENV JAVA_OPTS="-Xms128m -Xmx1024m" \
    JAR_FILE=${JAR_FILE}

# 设置暴露的端口号
EXPOSE 20521

# 执行命令
ENTRYPOINT ["./docker-entrypoint.sh"]
