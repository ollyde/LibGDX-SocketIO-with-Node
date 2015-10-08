var engine = require('engine.io');
var server = engine.listen(3001);
 
server.on('connection', function(socket)
{
  console.log('Test');
  socket.send('utf 8 string');
  socket.send("Hello"); // binary data 
});