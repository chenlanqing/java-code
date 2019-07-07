Netty学习代码
---

- 包结构
    - codec：编解码
    - demo：一般案例
    - frame：粘包、拆包
    - heartbeat：心跳检测
    - protocol
        - http协议
        - websocket协议
    - reconnect：重连机制
    - zerocopy：零拷贝

- 依赖
    ```xml
    <dependencies>
        <dependency>
            <groupId>io.netty</groupId>
            <artifactId>netty-all</artifactId>
            <version>4.1.15.Final</version>
        </dependency>
    
        <dependency>
            <groupId>com.google.protobuf</groupId>
            <artifactId>protobuf-java</artifactId>
            <version>2.5.0</version>
        </dependency>
    
        <dependency>
            <groupId>org.jboss.marshalling</groupId>
            <artifactId>jboss-marshalling</artifactId>
            <version>1.4.10.Final</version>
        </dependency>
        <dependency>
            <groupId>org.jboss.marshalling</groupId>
            <artifactId>jboss-marshalling-serial</artifactId>
            <version>1.4.10.Final</version>
        </dependency>
        <dependency>
            <groupId>org.msgpack</groupId>
            <artifactId>msgpack</artifactId>
            <version>0.6.7</version>
        </dependency>
    </dependencies>
    ```