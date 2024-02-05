var ws;

window.onload = connection();

function connection(){
    ws = new WebSocket("ws://localhost:8080/provaws/ws"); //nuovo protocollo ws
    ws.onmessage = function(event){
        document.getElementById("log").innerHTML += (event.data+ "<br>" );
    }
}

function invia(){
    var nome = prompt("dammi il nome");
    ws.send(nome);
}
    
    
