var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);

app.get('/', function(req, res){
  res.send('<h1>LibGDX SocketIO client to NodeJS server test, up and running!</h1>');
});

io.on('connection', function(socket)
{
    console.log('a user connected');
    console.log('Socket Object: ' + socket);

    socket.on('test', function(msg)
    {
        console.log(msg);
    });


    socket.on('disconnect', function(msg)
    {
        console.log('Client disconnected with message: ' + msg);
    });

});

http.listen(3001, function(){
  console.log('listening on *:3001');
});
