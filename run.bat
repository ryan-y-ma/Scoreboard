

REM
REM Edit this variable
REM
SET REPO=C:\Users\jtconnor\.m2\repository\

SET TARGET=target\classes
SET MAINMODULE=scoreboard
SET MAINCLASS=com.jtconnors.scoreboard.fx2.Main

SET MODPATH=%TARGET%;%REPO%com\jtconnors\com.jtconnors.socket\11.0.3\com.jtconnors.socket-11.0.3.jar;%REPO%org\openjfx\javafx-base\11.0.1\javafx-base-11.0.1.jar;%REPO%org\openjfx\javafx-controls\11.0.1\javafx-controls-11.0.1.jar;%REPO%org\openjfx\javafx-fxml\11.0.1\javafx-fxml-11.0.1.jar;%REPO%org\openjfx\javafx-graphics\11.0.1\javafx-graphics-11.0.1.jar;%REPO%org\openjfx\javafx-media\11.0.2\javafx-media-11.0.2.jar;%REPO%org\openjfx\javafx-base\11.0.1\javafx-base-11.0.1-win.jar;%REPO%org\openjfx\javafx-controls\11.0.1\javafx-controls-11.0.1-win.jar;%REPO%org\openjfx\javafx-fxml\11.0.1\javafx-fxml-11.0.1-win.jar;%REPO%org\openjfx\javafx-graphics\11.0.1\javafx-graphics-11.0.1-win.jar;%REPO%org\openjfx\javafx-media\11.0.2\javafx-media-11.0.2-win.jar

java --module-path %MODPATH% -m %MAINMODULE%/%MAINCLASS%