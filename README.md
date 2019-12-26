# fho-sdk-test
fho sdk 测试

fho sdk放在github 上的maven个人仓库上，应用的POM 里面增加仓库地址：
```xml
    <repositories>
        <repository>
            <id>gvr-mvn-repo</id>
            <url>https://raw.githubusercontent.com/jianhong2014/mvn-repo/master</url>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>always</updatePolicy>
            </snapshots>
        </repository>
    </repositories>
```

dependency增加如下内容：
```xml
        <dependency>
            <groupId>com.gvr.datahub.sdk</groupId>
            <artifactId>orpak-fho-sdk</artifactId>
            <version>1.0-RELEASE</version>
        </dependency>
```
