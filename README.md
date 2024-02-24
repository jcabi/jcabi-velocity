<img src="https://www.jcabi.com/logo-square.svg" width="64px" height="64px" />

[![EO principles respected here](https://www.elegantobjects.org/badge.svg)](https://www.elegantobjects.org)
[![Managed by Zerocracy](https://www.0crat.com/badge/C3RUBL5H9.svg)](https://www.0crat.com/p/C3RUBL5H9)
[![DevOps By Rultor.com](https://www.rultor.com/b/jcabi/jcabi-velocity)](https://www.rultor.com/p/jcabi/jcabi-velocity)

[![mvn](https://github.com/jcabi/jcabi-velocity/actions/workflows/mvn.yml/badge.svg)](https://github.com/jcabi/jcabi-velocity/actions/workflows/mvn.yml)
[![PDD status](https://www.0pdd.com/svg?name=jcabi/jcabi-velocity)](https://www.0pdd.com/p?name=jcabi/jcabi-velocity)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.jcabi/jcabi-velocity/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.jcabi/jcabi-velocity)
[![Javadoc](https://javadoc.io/badge/com.jcabi/jcabi-velocity.svg)](https://www.javadoc.io/doc/com.jcabi/jcabi-velocity)

More details are here: [velocity.jcabi.com](https://velocity.jcabi.com/index.html)

`VelocityPage` is a convenient builder/wrapper around [Apache Velocity](https://velocity.apache.org/):

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

## How to contribute?

Fork the repository, make changes, submit a pull request.
We promise to review your changes same day and apply to
the `master` branch, if they look correct.

Please run Maven build before submitting a pull request:

```
$ mvn clean install -Pqulice
```
