$(function(){
     var global = window.frames.top,
        clockElem = $("#clock"),
        second = 1000;
     if(global.ValamisTick == null) global.ValamisTick = "{{maxDuration}}";

    function timeIsOut(){
        window.frames.top.jQuery("#SCORMNavigationExit").click();
    }
    function timeIsLow(){
        window.frames.top.toastr.error("You have 10 seconds left!");
    }
    function displayTime(){
        if(global.ValamisTick == 0){ timeIsOut() }
        if(global.ValamisTick == 10){ timeIsLow() }
        else {
            var seconds = global.ValamisTick % 60;
            var minutes = Math.floor(global.ValamisTick % 3600 / 60);
            var hours = Math.floor(global.ValamisTick / 3600);

            if (seconds < 10) seconds = "0" + seconds;
            if (minutes < 10) minutes = "0" + minutes;
            if (hours < 10) hours = "0" + hours;

            clockElem.html(hours + ":" + minutes + ":" + seconds)
        }
    }
    function counter(){
        if(global.ValamisTick != null) //Clicking on exit nulls ValamisTick.
            global.ValamisTick -= 1;
        displayTime();
        setTimeout(function(){counter()},second);
    }
    if(global.ValamisTick != 0) counter(); //0 - maxDuration is not set(None in scala)
});