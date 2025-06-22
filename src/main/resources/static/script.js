createMap();

async function createMap() {
    //Obtener la informacion del Rover
    refreshRover();

    //Obtener la informacion de los obstaculos
    let obstacleReponse = await fetch('/api/obstacle/', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    });
    let obstaclesJson = await obstacleReponse.json();
    obstaclesJson.forEach(obstacleJson => {
        createRock(obstacleJson.x, obstacleJson.y);
    });

}

async function refreshRover() {
    let roverReponse = await fetch('/api/rover/', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    });
    let roverJson = await roverReponse.json();
    moveRover(roverJson.x, roverJson.y);
}


function moveRover(x, y) {
    document.getElementById("rover").style.left = (x * 100) + 'px'
    document.getElementById("rover").style.top = (y * 100) + 'px'
}

function createRock(x, y) {
    var rock = document.createElement("img");
    rock.setAttribute("src", "images/piedra.png");
    rock.setAttribute("class", "rock");
    var container = document.getElementById("container");
    container.appendChild(rock);
    rock.style.left = (x * 100) + 'px'
    rock.style.top = (y * 100) + 'px';
}

var posX = 0;
var posY = 0;

async function clickBtnRotateLeft() {
   sendCommand("L");
}

async function clickBtnRotateRight() {
   sendCommand("R");
}

async function moveForward() {
    sendCommand("F");
};

async function moveBack() {
    sendCommand("B");
}


async function sendCommand(command) {
    let requestBody = {
        "comands": [command]
    };
    await fetch('/api/rover/command/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestBody)
    });
    await refreshRover();
    playMoveSound();
}


function playMoveSound() {
    var audioElement = document.createElement("audio");
    audioElement.src = "sounds/move.wav";
    audioElement.controls = true;
    audioElement.autoplay = true;
    document.getElementById("container").appendChild(audioElement);
}