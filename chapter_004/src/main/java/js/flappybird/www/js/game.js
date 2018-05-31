var cvs = document.getElementById("canvas"); //в этой перменной лежит объект канвас
var ctx = cvs.getContext("2d"); //переменная context отвечает за вид игры

//download images
var bird = new Image();
var bg = new Image(); //задний фон
var fg = new Image(); // передний фон
var pipeUp = new Image(); // препятствие сверху
var pipeBottom = new Image(); //препятвтие снизу

bird.src = "img/flappy_bird_bird.png";
bg.src = "img/flappy_bird_bg.png";
fg.src = "img/flappy_bird_fg.png";
pipeUp.src = "img/flappy_bird_pipeUp.png";
pipeBottom.src = "img/flappy_bird_pipeBottom.png";

//sound files
var fly = new Audio();
var score_audio = new Audio();

fly.src = "audio/fly.mp3";
score_audio = "audio/score.mpe"

var gap = 90; //gap for bird, where she can fly between pipes
document.addEventListener("keydown", moveUp);

function moveUp() {
    yPos -= 20;
    fly.play();
}
//создание блоков
var pipe = [];
//создаем объект (в 0й ячейке массива, поэтому используем фиг.скобки {}
pipe[0] = { //координата по х , у для каждого блока
    x : cvs.width,
    y : 0
}
var score = 0;
//bird`s position
var xPos = 10;
var yPos = 150;
var grav = 1.5;

//нарисуем объекты в canvas `E
function draw() {
    ctx.drawImage(bg, 0, 0);
    for (var i = 0; i < pipe.length; i++) {
        ctx.drawImage(pipeUp, pipe[i].x, pipe[i].y);
        ctx.drawImage(pipeBottom, pipe[i].x,pipe[i].y + pipeUp.height + gap );
        pipe[i].x--;

    if (pipe[i].x == 125) {
        pipe.push(  //каждый раз добавляем новый элемент в массив pipe
            {x : cvs.width,
                y : Math.floor(Math.random() * pipeUp.height) -
                    pipeUp.height}
        )
    }

    if (xPos + bird.width >= pipe[i].x
        && xPos <= pipe[i].x + pipeUp.width
        && (yPos <= pipe[i].y + pipeUp.height
        || yPos + bird.height >= pipe[i].y + pipeUp.height +
        gap) || yPos + bird.height >= cvs.height - fg.height) {
        location.reload(); //перезагрузка
    }


    if (pipe[i].x == 5) {
        score++;
       // score_audio.play();
    }

    }

    ctx.drawImage(fg, 0, cvs.height - fg.height);
    ctx.drawImage(bird, xPos, yPos);

    yPos += grav;

    ctx.fillStyle = "#000";
    ctx.font = "24px Verdana";
    ctx.fillText("Счет: " + score, 10, cvs.height - 20);


    requestAnimationFrame(draw);
}
//необходимо, чтобы все изображения были загружены,а только
//потом вызывать функцию, которая из прорисует
pipeBottom.onload = draw;

