describe('Package manager list search', function () {
  it('has PackageManagerItemView and item template', function () {
    expect(PackageManagerSearchView).not.toBeUndefined();
    expect(jQuery(PackageManagerSearchView.prototype.template).length).toBeGreaterThan(0);
  });
});

describe('PackageManagerSearchView', function () {
  it('render() should return the view object', function () {
    var view = new PackageManagerSearchView();
    expect(view.render()).toBe(view);
  });

  it('should render into div with className "search-wrapper"', function () {
    var view = new PackageManagerSearchView();
    var renderResult = view.render();

    expect(renderResult.el.nodeName.toLowerCase()).toBe('div');
    expect(renderResult.$el.hasClass('search-wrapper')).toBeTruthy();
  });

  describe("async search events", function () {
    var searchFilters = {};
    var testInput = 'Test';
    beforeEach(function (done) {
      // create fixture to make events work
      $("<div>").attr("id", "fixture").css("display", "none").appendTo("body");

      var view = new PackageManagerSearchView();
      this.rendered = view.render().$el;
      $("#fixture").append(this.rendered);

      view.on('filter', function (result) {
        searchFilters = result;
        done();
      });

      jQuery('.search', this.rendered).val(testInput);
      jQuery('.search', this.rendered).trigger(jQuery.Event('keyup'));// emulate keyup
    });

    afterEach(function (done) {
      $("#fixture").remove();
      done();
    });

    it('should fire event asynchronously on keyup inside search box', function (done) {
      expect(searchFilters.enteredFilter).not.toBeUndefined();
      expect(searchFilters.enteredFilter).toBe(testInput);
      done();
    });
  });

  describe("async search events", function () {
    var searchFilters = {};
    beforeEach(function (done) {
      // create fixture to make events work
      $("<div>").attr("id", "fixture").css("display", "none").appendTo("body");

      var view = new PackageManagerSearchView();
      this.rendered = view.render().$el;
      $("#fixture").append(this.rendered);

      view.on('filter', function (result) {
        searchFilters = result;
        done();
      });

      jQuery('.sorting', this.rendered).val(jQuery('.sorting option:eq(1)', this.rendered).val());
      jQuery('.sorting', this.rendered).trigger(jQuery.Event('change'));// emulate change event
    });

    afterEach(function (done) {
      $("#fixture").remove();
      done();
    });

    it('should fire event asynchronously on sorting combobox change', function (done) {
      expect(searchFilters.sort).not.toBeUndefined();
      expect(searchFilters.sort).toBe(jQuery('.sorting option:eq(1)', this.rendered).val());
      done();
    });
  });

  describe("async search events", function () {
    var searchFilters = {};
    beforeEach(function (done) {
      // create fixture to make events work
      $("<div>").attr("id", "fixture").css("display", "none").appendTo("body");

      var view = new PackageManagerSearchView();
      this.rendered = view.render().$el;
      $("#fixture").append(this.rendered);

      view.on('filter', function (result) {
        searchFilters = result;
        done();
      });

      jQuery('.display', this.rendered).val(jQuery('.display option:eq(1)', this.rendered).val());
      jQuery('.display', this.rendered).trigger(jQuery.Event('change'));// emulate change event
    });

    afterEach(function (done) {
      $("#fixture").remove();
      done();
    });

    it('should fire event asynchronously on display combobox change', function (done) {
      expect(searchFilters.display).not.toBeUndefined();
      expect(searchFilters.display).toBe(jQuery('.display option:eq(1)', this.rendered).val());
      done();
    });
  });
});