# **Hostname**
  get the hostname of a URL

## Usage

download the JAR file from **`lib/Hostname-1.0-SNAPSHOT.jar`** and add it in your project.

```java 
String host = Hostname.getHostname("https://www.example.com");
```

###### How to add it to maven `pom.xml`?

```xml
<dependency>
    <groupId>com.github.HasanMhdAmin</groupId>
    <artifactId>Hostname</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>system</scope>
    <systemPath>${basedir}/lib/Hostname-1.0-SNAPSHOT.jar</systemPath>
</dependency>
<!--...-->
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <includeSystemScope>true</includeSystemScope>
    </configuration>
</plugin>
```
## Sample 
suppose you have these URLs:
* https://www.example.com/watch?v=TEST 
* https://en.example.org/wiki/Software 
* one.two.three.four.example.com
* https://www.example.co.uk
* example.com

The output to be only the host name, 
in the previous example the result for all domains should be **`example`**.


## Author 
Hasan Mhd Amin on GitHub [@HasanMhdAmin](https://github.com/HasanMhdAmin) 