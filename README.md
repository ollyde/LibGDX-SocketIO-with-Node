# LibGDX-SocketIO-with-Node

## To install and run node.
1. Change directoy to the server folder.
2. Make sure you have Node JS installed.
3. Terminal, 'npm install'
4. Terminal, node server.js
5. Success.

## App setup
1. In 'sockettest/core/src/com/mygdx/game/SocketTest.java' change the direction the socket points to, so point it to you're local
IP from you're router, ie **192.168.1.11 << YOU'RE IP**
2. Setup as applicaiton for desktop, make sure assets points towards 'android/assets'. Then select desktop module.

Android should just run if you're using Android Studio.

For iOS type: ``` ./gradlew launchIOSDevice --stacktrace --debug ```

In the app simple tap the screen and it will make a conneciton, you'll be able to see froms logs on all devices.
If you navigate to the node server you'll see the connection message.
On iOS you'll see the error that needs fixing.

The is an example of the JAVA node ClientIO module failing for iOS under RoboVM.
Desktop works perfect.
Android works perfect.
