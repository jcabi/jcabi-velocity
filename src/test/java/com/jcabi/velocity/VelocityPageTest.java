/*
 * SPDX-FileCopyrightText: Copyright (c) 2012-2026 Yegor Bugayenko
 * SPDX-License-Identifier: MIT
 */
package com.jcabi.velocity;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

/**
 * Test case for {@link VelocityPage}.
 * @since 0.0.1
 */
final class VelocityPageTest {

    @Test
    void formatsVelocityTemplate() {
        MatcherAssert.assertThat(
            new VelocityPage("com/jcabi/velocity/text.vm")
                .set("xname", "Вася")
                .toString(),
            Matchers.containsString(
                "привет, Вася"
            )
        );
    }
}
