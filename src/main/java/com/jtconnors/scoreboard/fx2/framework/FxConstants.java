/*
 * Copyright (c) 2019, Jim Connors
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   * Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above
 *     copyright notice, this list of conditions and the following
 *     disclaimer in the documentation and/or other materials provided
 *     with the distribution.
 *   * Neither the name of this project nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.jtconnors.scoreboard.fx2.framework;

import javafx.scene.paint.Color;
import javafx.util.Duration;

/*
 * This class contains constants that are particular to the JavaFX 2.0
 * platform.
 *
 * It follows the Singleton design pattern and takes advantage of the 
 * properties of the Java Virtual Machine such that initialiazion of the
 * class instance will be done in a thread safe manner.
 */

public class FxConstants {
    private FxConstants() {}
    
    private static class LazyHolder {
        private static final FxConstants INSTANCE = new FxConstants();
    }
    
    public static FxConstants instance() {
        return LazyHolder.INSTANCE;
    }
    
    public final Color DEFAULT_DIGIT_COLOR = Color.RED;
    public final Color DEFAULT_SECONDARY_COLOR = Color.GOLDENROD;
    public final Color DEFAULT_TEXT_COLOR = Color.WHITE;
    public final Color DEFAULT_BACKGROUND_COLOR = Color.BLACK;
    /*
     * Timer constants
     */
    public final Duration ONE_TENTH_SECOND = Duration.millis(100);
    public final Duration ONE_SECOND = Duration.millis(1000);
    // 9 minutes 59 seconds in second increments
    public final int MAX_PENALTY_TIME = 599;
    // 99 minutes, 59.9 seconds in tenth of second increments
    public final int MAX_CLOCK_TIME = 59999;
}
