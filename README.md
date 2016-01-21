<img src="http://img.jcabi.com/logo-square.svg" width="64px" height="64px" />

[![Made By Teamed.io](http://img.teamed.io/btn.svg)](http://www.teamed.io)
[![DevOps By Rultor.com](http://www.rultor.com/b/jcabi/jcabi-velocity)](http://www.rultor.com/p/jcabi/jcabi-velocity)

[![Build Status](https://travis-ci.org/jcabi/jcabi-velocity.svg?branch=master)](https://travis-ci.org/jcabi/jcabi-velocity)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.jcabi/jcabi-velocity/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.jcabi/jcabi-velocity)
[![Javadoc](https://javadoc-emblem.rhcloud.com/doc/com.jcabi/jcabi-velocity/badge.svg)](http://www.javadoc.io/doc/com.jcabi/jcabi-velocity)

More details are here: [velocity.jcabi.com](http://velocity.jcabi.com/index.html)

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

## Questions?

If you have any questions about the framework, or something doesn't work as expected,
please [submit an issue here](https://github.com/yegor256/jcabi/issues/new).

## How to contribute?

Fork the repository, make changes, submit a pull request.
We promise to review your changes same day and apply to
the `master` branch, if they look correct.

Please run Maven build before submitting a pull request:

```
$ mvn clean install -Pqulice
```
