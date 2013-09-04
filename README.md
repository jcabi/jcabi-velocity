<img src="http://img.jcabi.com/logo.png" width="200px" height="48px" />

More details are here: [www.jcabi.com/jcabi-velocity](http://www.jcabi.com/jcabi-velocity/index.html)

`VelocityPage` is a convenient builder/wrapper around [Apache Velocity](http://velocity.apache.org/):

```java
import com.jcabi.velocity.VelocityPage;
public class Main {
  public static void main(String[] args) {
    String text = new VelocityPage("/com/foo/template.vm")
      .set("name", "John Doe")
      .set("file", file)
      .set("document", doc)
      .toString();
  }
}
```

You need just this dependency:

```xml
<dependency>
  <groupId>com.jcabi</groupId>
  <artifactId>jcabi-velocity</artifactId>
  <version>0.8</version>
</dependency>
```

## Questions?

If you have any questions about the framework, or something doesn't work as expected,
please [submit an issue here](https://github.com/yegor256/jcabi/issues/new).
If you want to discuss, please use our [Google Group](https://groups.google.com/forum/#!forum/jcabi).

## How to contribute?

Fork the repository, make changes, submit a pull request.
We promise to review your changes same day and apply to
the `master` branch, if they look correct.

Please run Maven build before submitting a pull request:

```
$ mvn clean install -Pqulice
```
