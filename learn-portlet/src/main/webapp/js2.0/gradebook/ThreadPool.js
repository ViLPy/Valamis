/*
Simple thread pool class.
Add task to the queue (addTask method) and when it completed call taskCompleted method
 */

var ThreadPool = function (size) {
    var queueSize = size;
    var current   = 0;
    var taskQueue = [];
    var intervalId = -1;

    var runner = function () {
        if(current < queueSize) {
            var task = taskQueue.shift();
            if(task) {
                current++;
                task.call();
            }
        }
    };

    var start = function () {
        if(intervalId == -1)
            intervalId = window.setInterval(runner, 500);
    };

    this.addTask = function(task) {
        taskQueue.push(task);
        start();
    };

    this.taskCompleted = function() {
        current--;
        if(current == 0 && taskQueue.length == 0)
            dispose();
    };

    var dispose = function() {
        window.clearInterval(intervalId);
        intervalId = -1;
    };
};