_(aop).forEach(function(tpe){
    /* Here we alter render function for all leaf prototypes
    *
    * The disadvantage of this approach is that child shouldn't
    * contain a call to parent render function inside it's own render
    * call, for example:
    * this.__proto__.__proto__.render() or Object.getPrototypeOf(Object.getPrototypeOf(this))
    * */
    if(tpe.render != Object.getPrototypeOf(tpe).render) { // If prototype rewrites render function of it parent
        // Otherwise we will get multiple call of afterRender, because:
        // Parent's render would be: newRender(){ oldRender(); afterRender();}
        // And child render would be: newRender(){ oldRender()*which expands to parent.render()*; afterRender(); }
        var oldRender = tpe.render;
        var newRender = function () {
            var result = oldRender.apply(this, arguments);
            this.afterRender();
            return result;
        };
        tpe.render = newRender;
    }
});