/*
 * SPDX-FileCopyrightText: Copyright (c) 2012-2025 Yegor Bugayenko
 * SPDX-License-Identifier: MIT
 */
package com.jcabi.velocity;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * Velocity page, builder/wrapper around Apache Velocity template.
 *
 * <p>The template should be in classpath:
 *
 * <pre> String text = new VelocityPage("com/foo/my-template.vm")
 *   .set("name", "John Doe")
 *   .toString();</pre>
 *
 * <p>At the moment all logging is forwarded to LOG4J. In Velocity 2.0 there
 * will be an adapter for SLF4J and we'll use it: {@code Slf4jLogChute}.
 *
 * <p>The class is mutable and thread-safe.
 *
 * @see <a href="http://velocity.apache.org/engine/releases/velocity-1.7/user-guide.html">Velocity User Guide</a>
 * @see <a href="http://velocity.apache.org/engine/releases/velocity-1.7/developer-guide.html">Velocity Developer Guide</a>
 * @see <a href="http://velocity.apache.org/engine/devel/apidocs/org/apache/velocity/slf4j/Slf4jLogChute.html">Slf4jLogChute</a>
 * @since 0.1.6
 */
public final class VelocityPage {

    /**
     * The engine to use.
     */
    private static final VelocityEngine ENGINE = VelocityPage.init();

    /**
     * Name of resource.
     */
    private final transient String name;

    /**
     * The context.
     */
    private final transient VelocityContext context;

    /**
     * Public ctor, with absolute resource name in classpath.
     * @param res Name of resource with template (absolute resource name in
     *  classpath)
     */
    public VelocityPage(final String res) {
        this.name = res;
        this.context = new VelocityContext();
    }

    /**
     * Set the name to the value specified.
     * @param prop Name of the property to set
     * @param value The value to use
     * @return This object
     */
    public VelocityPage set(final String prop, final Object value) {
        synchronized (this.context) {
            this.context.put(prop, value);
        }
        return this;
    }

    /**
     * Set all names in one go.
     * @param args Map of arguments
     * @return This object
     * @since 0.8
     */
    public VelocityPage set(final Map<String, Object> args) {
        synchronized (this.context) {
            for (final Map.Entry<String, Object> entry : args.entrySet()) {
                this.context.put(entry.getKey(), entry.getValue());
            }
        }
        return this;
    }

    @Override
    public String toString() {
        final Template template =
            VelocityPage.ENGINE.getTemplate(this.name, "UTF-8");
        final StringWriter writer = new StringWriter();
        template.merge(this.context, new PrintWriter(writer));
        return writer.toString();
    }

    /**
     * Create and initialize Velocity engine.
     * @return The engine to use
     */
    private static VelocityEngine init() {
        final VelocityEngine engine = new VelocityEngine();
        engine.setProperty("resource.loader", "cp");
        engine.setProperty(
            "cp.resource.loader.class",
            ClasspathResourceLoader.class.getName()
        );
        engine.setProperty(
            RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS,
            "org.apache.velocity.runtime.log.Log4JLogChute"
        );
        engine.setProperty(
            "runtime.log.logsystem.log4j.logger",
            "org.apache.velocity"
        );
        engine.init();
        return engine;
    }

}
