/*
 * SPDX-FileCopyrightText: Copyright (c) 2012-2025 Yegor Bugayenko
 * SPDX-License-Identifier: MIT
 */
package com.jcabi.velocity;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

/**
 * Test case for {@link VelocityPage}.
 *
 * @since 0.0.1
 */
final class VelocityPageTest {

    @Test
    void formatsVelocityTemplate() {
        MatcherAssert.assertThat(
            new VelocityPage("com/jcabi/velocity/text.vm")
                .set("xname", "\u0412\u0430\u0441\u044F")
                .toString(),
            Matchers.containsString(
                "\u043F\u0440\u0438\u0432\u0435\u0442, \u0412\u0430\u0441\u044F"
            )
        );
    }

}
