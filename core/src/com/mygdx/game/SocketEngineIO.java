package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

import io.socket.emitter.Emitter;
import io.socket.engineio.client.Socket;

public class SocketEngineIO extends ApplicationAdapter
{
	private SpriteBatch batch;
    private int sentItems = 0;
    private Socket socket;

	@Override
	public void create ()
    {
		batch = new SpriteBatch();

        Gdx.input.setInputProcessor(new GestureDetector(new GestureDetector.GestureListener() {
            @Override
            public boolean touchDown(float x, float y, int pointer, int button) {
                return false;
            }

            @Override
            public boolean tap(float x, float y, int count, int button)
            {
                //Tap the screen to send messages.

                if(socket == null)
                {
                    try
                    {
                        log("Beginning connection with SocketIO server.");

                        //TODO Replace with you're local host IP on the router.
                        //socket = IO.socket("http://127.0.0.1:3001");
                        socket = new Socket("http://127.0.0.1:3001");

                        socket = new Socket("ws://localhost");
                        socket.on(Socket.EVENT_OPEN, new Emitter.Listener() {
                            @Override
                            public void call(Object... args) {
                                socket.send("hi");
                                socket.close();
                            }
                        });
                        socket.open();

                    }
                    catch (Exception exception)
                    {
                        log("Disconnected with server.");
                        exception.printStackTrace();
                    }
                }
                else
                {
                    socket.emit("test", "Test message: " + String.valueOf(sentItems));
                    sentItems++;
                }



                return true;
            }

            @Override
            public boolean longPress(float x, float y) {
                return false;
            }

            @Override
            public boolean fling(float velocityX, float velocityY, int button) {
                return false;
            }

            @Override
            public boolean pan(float x, float y, float deltaX, float deltaY) {
                return false;
            }

            @Override
            public boolean panStop(float x, float y, int pointer, int button) {
                return false;
            }

            @Override
            public boolean zoom(float initialDistance, float distance) {
                return false;
            }

            @Override
            public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
                return false;
            }
        }));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.end();
	}

    static void log(Object object)
    {
        System.out.println("LOG_LIBGDX: " + object);
    }
}
