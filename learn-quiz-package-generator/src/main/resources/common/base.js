var TinCanCourseModules = {},
    TinCanCourseHelpers = {};

function ProcessTinCan(id) {

/*  var stmt = {
    verb: "attempted",
    object: testObj,
    context: getContext(ROOT_ACTIVITY_ID)
  };
  tincan.sendStatement(stmt);*/


  if (TinCanCourseModules.hasOwnProperty(id)) {
    TinCanCourseModules[id](tincan);
  }
}

(function($){

  $.fn.shuffle = function() {

    var allElems = this.get(),
      getRandom = function(max) {
        return Math.floor(Math.random() * max);
      },
      shuffled = $.map(allElems, function(){
        var random = getRandom(allElems.length),
          randEl = $(allElems[random]).clone(true)[0];
        allElems.splice(random, 1);
        return randEl;
      });

    this.each(function(i){
      $(this).replaceWith($(shuffled[i]));
    });

    return $(shuffled);

  };

})(jQuery);


function PrepareCategorizationQuestionView(id) {
  jQuery("li.acceptable.categorization"+id).draggable({
    connectToSortable:'.answerContainer.container' + id,
    cursor:'pointer',
    revert:true,
    opacity:0.4,
    revertDuration: 0
  });
  jQuery('.answerContainer.container' + id).droppable({
    accept:'li.acceptable.categorization'+id,
    drop:function (event, ui) {
      jQuery(this).append(ui.draggable);
    }
  });
}

function PreparePositioningQuestionView(id) {
  jQuery("#sortable"+id).sortable({
    revert:true
  });
}

function shuffle(myArray) {
  var copiedArray = myArray.slice();
  var i = copiedArray.length;
  if (i == 0) return [];
  while (--i) {
    var j = Math.floor(Math.random() * ( i + 1 ));
    var n = copiedArray[i];
    var m = copiedArray[j];
    copiedArray[i] = m;
    copiedArray[j] = n;
  }
  return copiedArray;
}