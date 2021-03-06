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

package com.jtconnors.scoreboard.fx2.networking;

import javafx.application.Platform;
import com.jtconnors.socket.MulticastConnection;
import com.jtconnors.scoreboard.common.Globals;
import com.jtconnors.socket.DebugFlags;
import com.jtconnors.socket.Constants;

public class FxMulticastReader extends MulticastConnection {
    
    /**
     * Called whenever a message is read from the socket.
     * In JavaFX 2.0, this method must be run on the
     * main thread.  This is accomplished by the Platform.runLater() call
     * which utilizes the {@code Runnable} interface, simplified by the
     * lambda expression used in this method.
     * Failure to do so *will* result in strange errors and exceptions.
     * @param line Line of text read from the socket.
     */
    @Override
    public void onMessage(final String line) {
        Platform.runLater(() -> {
            Globals.instance().hockeyScoreboardRef.handleUpdate(line);
        });
    }

    /**
     * Called whenever the open/closed status of the Socket
     * changes.  In JavaFX 2.0, this method must be run on the
     * main thread.  This is accomplished by the Platform.runLater() call
     * which utilizes the {@code Runnable} interface, simplified by the
     * lambda expression used in this method.
     * Failure to do so *will* result in strange errors and exceptions.
     * @param isClosed true if the socket is closed
     */
    @Override
    public void onClosedStatus(final boolean isClosed) {
        Platform.runLater(() -> {
            Globals.instance()
                    .hockeyScoreboardRef.updateStatusRow(isClosed ? 0 : 1);
        });
    }
    
    public FxMulticastReader() {
        super(Constants.instance().DEFAULT_SESSION_ADDR,
                Constants.instance().DEFAULT_PORT,
                DebugFlags.instance().DEBUG_NONE);
    }

    public FxMulticastReader(int portNum) {
        super(Constants.instance().DEFAULT_SESSION_ADDR, portNum,
                DebugFlags.instance().DEBUG_NONE);
    }

    public FxMulticastReader(String addr, int portNum, int debugFlags) {
        super(addr, portNum, debugFlags);
    }
}
