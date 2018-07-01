
var name =  prompt("Insira seu nome");

var path = window.location.pathname;
var contextoWeb = path.substring(0, path.indexOf('/', 1));
var endPointURL = "ws://" + window.location.host + contextoWeb + "/chat";

var messageTextArea = document.getElementById('messageTextArea');
var textMessage = document.getElementById('textMessage');

var webSocket = new WebSocket(endPointURL);
var input = document.getElementById("textMessage");

//Execute a function when the user releases a key on the keyboard
input.addEventListener("keyup", function(event) {
// Cancel the default action, if needed
event.preventDefault();
// Number 13 is the "Enter" key on the keyboard
if (event.keyCode === 13) {
 // Trigger the button element with a click
 document.getElementById("button01").click();
}
});

webSocket.onopen = function(message) {
	onOpen(message);
};

webSocket.onclose = function(message) {
	onClose(message);
};

webSocket.onerror = function(message) {
	onError(message);
};

webSocket.onmessage = function(message) {
	onMessage(message);
};

function onOpen(message) {
	messageTextArea.value += 'Server Connect...' + '\n';
};

function onClose(message) {
	webSocket.send('Client disconnected...');
	messageTextArea.value += 'Server disconect...' + '\n';
};

function onError(message) {
	messageTextArea.value += 'Something went wrong...' + '\n';
};

function onMessage(message) {
	messageTextArea.value += message.data + '\n';
	messageTextArea.scrollTop = messageTextArea.scrollHeight;
	
};

function sendMessage() {
	if (textMessage.value == '/close') {
		webSocket.close();
	} else {
		webSocket.send(name+" : "+textMessage.value);
		textMessage.value = '';
		
	}
};

//function sendMessage(){
//	
//	webSocket.send(textMessage.value);
//}
//
//
//webSocket.onopen = function(evt) {
//	console.log("Opening WebSocket");
//	// var things = webSocket.send(evt, "to passando a sessao carai");
//	// console.log("(" + things + ") <- [teste]");
//};
//
//webSocket.onmessage = function(e) {
//	console.log(e.data);
//};
//
//webSocket.onclose = function(e) {
//	console.log("WebSocket is closed");
//};
//
//webSocket.onerror = function(e) {
//	console.log("Error");
//};

