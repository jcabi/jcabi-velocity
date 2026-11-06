/*
 * SPDX-FileCopyrightText: Copyright (c) 2012-2026 Yegor Bugayenko
 * SPDX-License-Identifier: MIT
 */
package com.jcabi.velocity;

import java.util.concurrent.TimeUnit;

/**
 * Template helper that tries to write to a page from another thread.
 *
 * @since 0.1.6
 */
public final class VelocityProbe {

    /**
     * The page to write to.
     */
    private final VelocityPage page;

    /**
     * Ctor.
     *
     * @param pge The page
     */
    VelocityProbe(final VelocityPage pge) {
        this.page = pge;
    }

    /**
     * Is a concurrent writer blocked right now?
     *
     * @return TRUE if it is
     * @throws InterruptedException If interrupted
     */
    public boolean blocked() throws InterruptedException {
        final Thread writer = new Thread(
            () -> this.page.set("other", "value")
        );
        writer.start();
        writer.join(TimeUnit.SECONDS.toMillis(1L));
        final boolean alive = writer.isAlive();
        if (alive) {
            writer.interrupt();
        }
        return alive;
    }
}
