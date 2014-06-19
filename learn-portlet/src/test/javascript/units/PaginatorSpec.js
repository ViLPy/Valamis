describe("Paginator", function () {

    var container = null;

    beforeEach(function () {
        container = $("<div></div>").appendTo("body");

        var templateContainer = $('#paginatorTemplate');
        if (templateContainer.length == 0) {
            $.ajax({
               url: "src/main/webapp/templates/2.0/paginator.html",
               async:false,
            }).done(function(response) {
                $("<div></div>").appendTo("body").html(response)
            });
        }
    })

    afterEach(function () {
        container.remove();
    });

    it("should be defined", function(){
        expect(ValamisPaginator).not.toBeUndefined();
    });

    it("model should be defined", function(){
        expect(PageModel).not.toBeUndefined();
    });

    it("should create html elements", function() {
        var paginator = new ValamisPaginator({el: container});

        expect(container.children().length).not.toBe(0);
    });

    it("should be on page 1 after start", function() {
        var paginator = new ValamisPaginator({el: container});
        paginator.updateItems(100);

        expect(paginator.currentPage()).toBe(1);
    });

    it("should react on next click", function() {
        var paginator = new ValamisPaginator({el: container});
        paginator.updateItems(140);

        var spy = sinon.spy();
        paginator.on("pageChanged", spy);
        container.find(".paginator-next-page").trigger("click");
        expect(spy.called).toBe(true);
        expect(paginator.currentPage()).toBe(2);
    })

    it("should react on prev click", function() {
        var pageModel = new PageModel({totalElements:100, currentPage: 5});
        var paginator = new ValamisPaginator({el: container, model: pageModel});

        var spy = sinon.spy();
        pageModel.on("pageChanged", spy);
        container.find(".paginator-previous-page").trigger("click" );
        expect(paginator.currentPage()).toBe(4);
        expect(spy.called).toBe(true);
    })

    it("should not react on prev from first page", function() {
        var paginator = new ValamisPaginator({el: container});
        paginator.updateItems(1000);

        var spy = sinon.spy();
        paginator.on("pageChanged", spy);
        container.find(".paginator-previous-page").trigger("click" );
        expect(spy.called).toBe(false);
        expect(paginator.currentPage()).toBe(1);
    })

    it("should not react on next from last page", function() {
        var pageModel = new PageModel({totalElements:100, currentPage: 10});
        var paginator = new ValamisPaginator({el: container, model: pageModel});

        var spy = sinon.spy();
        pageModel.on("pageChanged", spy);
        container.find(".paginator-next-page").trigger("click" );
        expect(spy.called).toBe(false);
        expect(paginator.currentPage()).toBe(10);
    })

    it("should react on changing the model", function(){
        var pageModel = new PageModel({});
        var paginator = new ValamisPaginator({el: container, model: pageModel});
        paginator.updateItems(1000);

        pageModel.set({itemsOnPage: 25});
        expect(container.find(".paginator-items-per-page").val()).toBe('25');
    })

    it("should react on changing items per page value", function(){
        var paginator = new ValamisPaginator({el: container});
        paginator.updateItems(30);

        var spy = sinon.spy();
        paginator.on("pageChanged", spy);

        container.find(".paginator-items-per-page").val(25)
        container.find(".paginator-items-per-page").trigger("change")

        expect(paginator.currentPage()).toBe(1);
        expect(spy.called).toBe(true);
        expect(paginator.itemsOnPage()).toBe('25');
    })

    it("should go to first page on changing items per page value", function(){
        var paginator = new ValamisPaginator({el: container});
        paginator.updateItems(1000);
        container.find(".paginator-next-page").trigger("click" );
        expect(paginator.currentPage()).toBe(2);

        var spy = sinon.spy();
        paginator.on("pageChanged", spy);

        container.find(".paginator-items-per-page").val(25)
        container.find(".paginator-items-per-page").trigger("change")

        expect(spy.called).toBe(true);
        expect(paginator.currentPage()).toBe(1);
    })

    it("should not raise pageChanged on changing the model", function(){
        var pageModel = new PageModel({});
        var paginator = new ValamisPaginator({el: container, model: pageModel});
        paginator.updateItems(1000);

        var spy = sinon.spy();
        paginator.on("pageChanged", spy);

        pageModel.set({currentPage: 2});
        pageModel.set({itemsOnPage: 25});

        expect(spy.called).toBe(false);
        expect(container.find(".paginator-items-per-page").val()).toBe('25');
    })
})