ScormNodeNavigationCollection = NavigationNodeCollection.extend({
    findById: function(id){
        function findByIdHelper(id, collection) {
            var result = null;
            collection.each(function (elem) {
                if (elem.get('elementType') == 'directory') {
                    var subresult = findByIdHelper(id, elem.internalCollection);
                    if (subresult != null) result = subresult
                } else if (elem.get('id') == id) result = elem;
            });
            return result;
        }
        return findByIdHelper(id, this);
    },
    toggle: function(id){
        this.toggleHelper(this.findById(id));
    },
    navigate: function(model){
        this.trigger('navigate',model);
    },
    parseTree: function (tree){
        var that = this;
        return _.map(tree, function(elem){
            var isDirectory = elem.childActivities.length != 0;
            var childElements = isDirectory ? that.parseTree(elem.childActivities) : [];
            return {
                id: elem.id,
                title: elem.title,
                childElements: isDirectory ? childElements : null,
                elementType: isDirectory ? 'directory' : null
            };
        });
    }
});