package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.SocketEngineIO;
import com.mygdx.game.SocketIOJavaTest;

public class DesktopLauncher {
	public static void main (String[] arg) {

        final boolean USE_ENGINE_IO = true;

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication((USE_ENGINE_IO) ? new SocketEngineIO() : new SocketIOJavaTest(), config);
	}
}
