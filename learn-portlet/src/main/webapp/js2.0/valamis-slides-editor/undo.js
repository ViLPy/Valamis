function undoAction() {
    if(!slidesApp.actionStack || slidesApp.actionStack.length === 0 || slidesApp.isSaved) {
        console.log('Nothing to undo.');
        return;
    }

    var action = slidesApp.actionStack.pop();
    if(!slidesApp.actionStack || slidesApp.actionStack.length === 0 && !slidesApp.isSaved) {
        toggleSavedState();
    }

    if(action.viewId)
        var view = Marionette.ItemView.Registry.getByViewId(action.viewId);

    switch(action.type) {
        case 'itemMoved':
        case 'itemResized':
            if(slidesApp.isSaved) {
                slidesApp.oldValue = {'top': view.model.get('top'), 'left': view.model.get('left')};
                slidesApp.newValue = action.oldValue;
            }
            view.model.set(action.oldValue);
            view.content.find('div[class*="content-icon-"]').first().css('font-size', Math.min(view.model.get('width') / 2, view.model.get('height') / 2) + 'px');
            break;
        case 'itemCreated':
            Marionette.ItemView.Registry.remove(view.cid);
            if(JSON.stringify(Reveal.getIndices()) !== JSON.stringify(action.newValue.indices)) {
                Reveal.slide(action.newValue.indices.h, action.newValue.indices.v, action.newValue.indices.f);
                window.setTimeout(function () {
                    view.deleteEl();
                }, 1000 * parseFloat(jQueryValamis('.slides').css('transition-duration').slice(0, -1)));
            }
            else {
                view.deleteEl();
            }
            break;
        case 'itemRemoved':
            Marionette.ItemView.Registry.register(action.oldValue.view.cid, action.oldValue.view);
            Reveal.slide(action.oldValue.indices.h, action.oldValue.indices.v, action.oldValue.indices.f);
            action.oldValue.view.model.unset('toBeRemoved');
            action.oldValue.view.$el.show();
            break;
        case 'itemContentChanged':
            view.model.set('content', action.oldValue.content);
            view.model.set('width', action.oldValue.width);
            view.model.set('height', action.oldValue.height);
            switch(action.oldValue.contentType) {
                case 'text':
                    view.content.html(action.oldValue.content);
                    break;
                case 'image':
                    view.updateUrl(action.oldValue.content);
                    slidesApp.actionStack.pop();
                    break;
                case 'url':
                    view.$('iframe').attr('src', action.oldValue.content);
                    break;
                case 'questionId':
                    view.updateQuestion(action.oldValue.content);
                    slidesApp.actionStack.pop();
                    break;
                case 'video':
                    view.updateUrl(action.oldValue.content);
                    slidesApp.actionStack.pop();
                    break;
            }
            break;
        case 'correctAnswerNotificationChanged':
            view.toggleNotifyCorrectAnswer();
            slidesApp.actionStack.pop();
            toggleSavedState();
            break;
        case 'slideBackgroundChanged':
            Reveal.slide(action.oldValue.indices.h, action.oldValue.indices.v, action.oldValue.indices.f);
            switch(action.oldValue.backgroundType) {
                case 'color':
                    slidesApp.commands.execute('reveal:page:changeBackground', action.oldValue.background);
                    break;
                case 'image':
                    slidesApp.commands.execute('reveal:page:changeBackgroundImage', action.oldValue.background);
                    break;
            }
            slidesApp.actionStack.pop();
            break;
        case 'slideAdded':
            Reveal.slide(action.newValue.h, action.newValue.v, action.newValue.f);
            slidesApp.commands.execute('reveal:page:delete');
            Reveal.slide(action.oldValue.h, action.oldValue.v, action.oldValue.f);
            if(slidesApp.activeSlideModel.id && action.oldValue.type !== 'pptx')
                slidesApp.actionStack.pop();
            break;
        case 'slideRemoved':
            var slideModel = action.oldValue.slideModel;
            slideModel.unset('toBeRemoved');
            var slideEntities = action.oldValue.slideEntities;
            for(var i in slideEntities) {
                slideEntities[i].unset('id');
                slideEntities[i].unset('toBeRemoved');
                slideEntities[i].set('tempId', slidesApp.newSlideElementId--);
                slideEntities[i].set('slideId', slideModel.get('tempId'));
            }

            switch(slidesApp.mode) {
                case 'edit':
                    Reveal.slide(action.oldValue.indices.h, action.oldValue.indices.v, action.oldValue.indices.f);
                    switch (action.oldValue.direction) {
                        case 'right':
                            slidesApp.commands.execute('reveal:page:addRight', slideModel);
                            break;
                        case 'down':
                            slidesApp.commands.execute('reveal:page:addDown', slideModel);
                            break;
                    }
                    slidesApp.RevealModule.forEachSlideElement(new window.collection(slideEntities));
                    break;
                case 'arrange':
                    slideModel.unset('leftSlideId');
                    slideModel.unset('topSlideId');
                    if(action.oldValue.bottomSlideId) {
                        slidesApp.getSlideModel(action.oldValue.bottomSlideId).unset('leftSlideId');
                        arrangeModule.slideTargetList = jQueryValamis('#slidesArrangeTile_' + action.oldValue.bottomSlideId);
                        action.oldValue.slideThumbnail.insertBefore(arrangeModule.slideTargetList);
                    }
                    else if(action.oldValue.rightSlideId) {
                        slidesApp.getSlideModel(action.oldValue.rightSlideId).unset('topSlideId');
                        arrangeModule.slideTargetList = jQueryValamis('#slidesArrangeTile_' + action.oldValue.rightSlideId).parent().prev()
                        action.oldValue.slideThumbnail.prependTo(arrangeModule.slideTargetList);
                    }
                    arrangeModule.manageSortableLists();
                    arrangeModule.updateSlideRefs();
                    break;
            }
            break;
        case 'slideOrderChanged':
            var slideModel = slidesApp.getSlideModel(action.oldValue.slideAttrs.slideId);
            slideModel.set({
                leftSlideId: action.oldValue.slideAttrs.leftSlideId,
                topSlideId: action.oldValue.slideAttrs.topSlideId
            });
            if(action.oldValue.rightSlideId) {
                slidesApp.getSlideModel(action.oldValue.rightSlideId).set('leftSlideId', action.newValue.slideModel.id || action.newValue.slideModel.get('tempId'));
            }
            if(action.oldValue.bottomSlideId) {
                slidesApp.getSlideModel(action.oldValue.bottomSlideId).set('topSlideId', action.newValue.slideModel.id || action.newValue.slideModel.get('tempId'));
            }
            break;
        case 'slideTitleChanged':
            Reveal.slide(action.oldValue.indices.h, action.oldValue.indices.v, action.oldValue.indices.f);
            slidesApp.activeSlideModel.set('title', action.oldValue.title);
            break;
        case 'PPTXAdded':
            for(var i = 0; i < 2 * action.newValue.slideCount - 1; i++)
                undoAction();
            if(!slidesApp.isSaved)
                toggleSavedState();
            break;
        case 'slideStatementChanged':
            Reveal.slide(action.oldValue.indices.h, action.oldValue.indices.v, action.oldValue.indices.f);
            slidesApp.activeSlideModel.set({
                'statementVerb': action.oldValue.statementVerb,
                'statementObject': action.oldValue.statementObject,
                'statementCategoryId': action.oldValue.statementCategoryId
            });
            slidesApp.selectizeVerb[0].selectize.removeItem(action.newValue.statementVerb, true);
            slidesApp.selectizeCategory[0].selectize.removeItem(action.newValue.statementCategoryId, true);
            break;
    }
}