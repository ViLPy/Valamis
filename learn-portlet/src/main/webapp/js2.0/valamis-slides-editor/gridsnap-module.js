/**
 *  GridSnapModule
 *
 */

slidesApp.module("GridSnapModule", function (GridSnapModule, MyApp, Backbone, Marionette, $, _) {
    this.startWithParent = true;

    var gridOpts = {
        vertical: [],
        horizontal: [],
        offset: 2,
        incidence: 6,
        itemsPos: {}
    };

    var generateGrid = function (size,lines,posName) {
        for( var i = 0; i <= lines; i++ ){
            gridOpts[posName].push(i*size);
        }
    };

    var findNear = function(pos,posName){
        var posValues = _.range(Math.round(pos)-gridOpts.incidence+gridOpts.offset,Math.round(pos)+gridOpts.incidence+gridOpts.offset);
        var near = _.intersection(gridOpts[posName],posValues);
        if(near.length == 0){
            for(var i in gridOpts.itemsPos){
                near = _.intersection(gridOpts.itemsPos[i][posName],posValues);
                if(near.length > 0){
                    break;
                }
            }
        }
        return near;
    }

    GridSnapModule.onStart = function () {
        generateGrid(70,10,'vertical');
        generateGrid(80,12,'horizontal');
    };

    GridSnapModule.prepareItemsSnap = function () {
        if(!slidesApp.activeElement.view) { return; }
        gridOpts.itemsPos = {};
        var currentSlideId = slidesApp.activeSlideModel.get('id');
        var entireId = slidesApp.activeElement.view.model.get('id');
        _.each(slidesApp.slideElementCollection.where({slideId:currentSlideId}),function(item){
            if(item.get('id') != entireId){
                gridOpts.itemsPos['item_'+item.get('id')] = {
                    vertical: [ parseInt(item.get('top')) + gridOpts.offset, parseInt(item.get('top')) + parseInt(item.get('height')) + gridOpts.offset ],
                    horizontal: [ parseInt(item.get('left')) + gridOpts.offset, parseInt(item.get('left')) + parseInt(item.get('width')) + gridOpts.offset ]
                };
            }
        });
    };

    GridSnapModule.findNearPos = function (pos,posName,sideName,returnCurrent) {
        var near = findNear(pos,posName);
        if( near.length > 0 ){
            this.addLine(near[0],posName,sideName);
            near[0] -= gridOpts.offset;
            return near[0];
        }else{
            this.removeLines(posName,sideName);
            return returnCurrent ? pos : null;
        }
    };

    GridSnapModule.findNearPosDelta = function (pos,posName,sideName) {
        var newPos = this.findNearPos(pos,posName,sideName,false);
        return newPos ? newPos - pos : 0;
    };

    GridSnapModule.findNearWidth = function (pos,width,returnCurrent) {
        var posSideRight = this.findNearPos(pos + width,'horizontal','right',false);
        if(posSideRight){
            return posSideRight - pos;
        }else{
            return returnCurrent ? width : null;
        }
    };

    GridSnapModule.findNearHeight = function (pos,height,returnCurrent) {
        var posSideBottom = this.findNearPos(pos + height,'vertical','bottom',false);
        if(posSideBottom){
            return posSideBottom - pos;
        }else{
            return returnCurrent ? height : null;
        }
    };

    GridSnapModule.findNearPosRatio = function (pos,posName,sideName) {
        var newPos = this.findNearPos(pos,posName,sideName,true);
        return newPos / pos;
    };

    GridSnapModule.getPosSideTop = function (posSideTop) {
        posSideTop = this.findNearPos(posSideTop,'vertical','top',true);
        var posSideBottom = this.findNearPos(posSideTop + parseInt(slidesApp.activeElement.view.model.get('height')),'vertical','bottom',false);
        if( posSideBottom ){
            posSideTop = posSideBottom - parseInt(slidesApp.activeElement.view.model.get('height'));
        }
        return posSideTop;
    };

    GridSnapModule.getPosSideLeft = function (posSideLeft) {
        posSideLeft = this.findNearPos(posSideLeft,'horizontal','left',true);
        var posSideRight = this.findNearPos(posSideLeft + parseInt(slidesApp.activeElement.view.model.get('width')),'horizontal','right',false);
        if( posSideRight ){
            posSideLeft = posSideRight - parseInt(slidesApp.activeElement.view.model.get('width'));
        }
        return posSideLeft;
    };

    GridSnapModule.snapSize = function (direction,size,pos,aspectRatio) {
        // width
        if(_.indexOf(['e','se','ne'],direction) > -1){
            var new_width = this.findNearWidth(pos.left,size.width,false);
            if(new_width){
                size.width = new_width;
                if(aspectRatio)
                    size.height = slidesApp.activeElement.view.model.get('height');
            }
        }
        // height
        if(_.indexOf(['s','se','sw'],direction) > -1){
            var new_height = this.findNearHeight(pos.top,size.height,false);
            if(new_height){
                size.height = new_height;
                if(aspectRatio)
                    size.width = slidesApp.activeElement.view.model.get('width');
            }
        }
        return size;
    };

    GridSnapModule.snapTopResize = function(posSideTop,currentTop,size){
        var posSideTopDelta = this.findNearPosDelta(posSideTop,'vertical','top');
        if(posSideTopDelta){
            if(currentTop != posSideTop + posSideTopDelta){
                slidesApp.activeElement.view.model.set('height',size.height - posSideTopDelta);
            }
            size.height = slidesApp.activeElement.view.model.get('height');
        }
        return posSideTop + posSideTopDelta;
    };

    GridSnapModule.snapLeftResize = function(posSideLeft,currentLeft,size) {
        var posSideLeftDelta = this.findNearPosDelta(posSideLeft,'horizontal','left');
        if(posSideLeftDelta){
            if(currentLeft != posSideLeft + posSideLeftDelta){
                slidesApp.activeElement.view.model.set('width',size.width - posSideLeftDelta);
            }
            size.width = slidesApp.activeElement.view.model.get('width');
        }
        return posSideLeft + posSideLeftDelta;
    };

    GridSnapModule.addLine = function (pos,posName,sideName) {

        var parent = jQueryValamis('.slides'),
            leftPos = posName == 'vertical' ? '0' : pos+'px',
            topPos = posName == 'vertical' ? pos+'px' : '0',
            height = posName == 'vertical' ? '0' : '100%',
            width = posName == 'vertical' ? '100%' : '0';

        if( jQueryValamis('#gridLine'+posName+sideName+pos).size() == 0 ){
            jQueryValamis('<div/>',{
                id: 'gridLine'+posName+sideName+pos,
                class: 'grid-line grid-line-' + posName + '-' + sideName,
            })
            .css({
                width: width,
                height: height,
                position: 'absolute',
                left: leftPos,
                top: topPos,
                borderTop: posName == 'vertical' ? '1px solid #E0CC1A' : '0',
                borderLeft: posName == 'horizontal' ? '1px solid #E0CC1A' : '0'
            })
            .appendTo(parent);
        }

    };

    GridSnapModule.removeLines = function (posName,sideName) {
        if( typeof posName != 'undefined' ){
            jQueryValamis('.grid-line-' + posName + '-' + sideName,'.slides').remove();
        }else{
            jQueryValamis('.grid-line','.slides').remove();
        }
    };

});
