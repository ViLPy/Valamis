describe('Package manager list', function () {
  it('has pre-required PackageModel', function () {
    expect(PackageManagerPackageModel).not.toBeUndefined();
  });

  it('has pre-required PackageModelCollection', function () {
    expect(PackageManagerPackageCollection).not.toBeUndefined();
  });

  it('has PackageManagerItemView and all item templates', function () {
    expect(PackageManagerItemView).not.toBeUndefined();
    for (var template in PACKAGE_DISPLAY_TYPE_TEMPLATES) {
      expect(jQuery(PACKAGE_DISPLAY_TYPE_TEMPLATES[template]).length).toBeGreaterThan(0);
    }
  });

  it('has PackageManagerTileListView', function () {
    expect(PackageManagerTileListView).not.toBeUndefined();
  });
});

describe('PackageManagerItemView', function () {
  it('render() should return the view object', function () {
    var model = new PackageManagerPackageModel();
    var view = new PackageManagerItemView({model: model});

    expect(view.render()).toBe(view);
  });

  it('should render into div with className "certificate"', function () {
    var model = new PackageManagerPackageModel();
    var view = new PackageManagerItemView({model: model});
    var renderResult = view.render();

    expect(renderResult.el.nodeName.toLowerCase()).toBe('div');
    expect(renderResult.$el.hasClass('certificate')).toBeTruthy();
  });

  it('should render model with custom title and description', function () {
    var title = "Test Title";
    var description = "Test Description";

    var model = new PackageManagerPackageModel({title: title, description: description});
    var view = new PackageManagerItemView({model: model});
    var renderedText = view.render().$el.text();

    expect(renderedText).toMatch(title);
    expect(renderedText).toMatch(description);
  });

  it('should render model with custom title and description with all display types templates', function () {
    var title = "Test Title";
    var description = "Test Description";

    for (var displayType in DISPLAY_TYPE) {
      var model = new PackageManagerPackageModel({title: title, description: description});
      var view = new PackageManagerItemView({model: model, displayType: displayType});
      var renderedText = view.render().$el.text();

      expect(renderedText).toMatch(title);
      expect(renderedText).toMatch(description);
    }
  });

  describe("checkbox render", function () {
    it('should render model with "visible" and "default" flags checked correctly', function () {
      var flagState = true;

      var model = new PackageManagerPackageModel({isDefault: flagState, visibility: flagState});
      var view = new PackageManagerItemView({model: model});
      var rendered = view.render().$el;

      expect(jQuery('.package-visibility-flag', rendered).is(':checked')).toBe(flagState);
      expect(jQuery('.package-default-flag', rendered).is(':checked')).toBe(flagState);
    });

    it('should render model with "visible" and "default" flags un-checked correctly', function () {
      var flagState = false;

      var model = new PackageManagerPackageModel({isDefault: flagState, visibility: flagState});
      var view = new PackageManagerItemView({model: model});
      var rendered = view.render().$el;

      expect(jQuery('.package-visibility-flag', rendered).is(':checked')).toBe(flagState);
      expect(jQuery('.package-default-flag', rendered).is(':checked')).toBe(flagState);
    });
  });

  describe("checkbox events", function () {
    beforeEach(function () {
      // create fixture to make events work
      $("<div>").attr("id", "fixture").css("display", "none").appendTo("body");

      this.model = new PackageManagerPackageModel({isDefault: false, visibility: false});
      var view = new PackageManagerItemView({model: this.model});
      this.rendered = view.render().$el;
      $("#fixture").append(this.rendered);
    });

    afterEach(function () {
      $("#fixture").remove();
    });

    it('should update model if visibility changes', function () {
      expect(this.model.get('visibility')).toBe(false);
      this.rendered.find('.package-visibility-flag').click();
      expect(this.model.get('visibility')).toBe(true);
    });

    it('should update model if default flag changes', function () {
      expect(this.model.get('isDefault')).toBe(false);
      this.rendered.find('.package-default-flag').click();
      expect(this.model.get('isDefault')).toBe(true);
    });
  });
});

describe('PackageManagerItemView', function () {
  it('render() should return the view object', function () {
    var collection = new PackageManagerPackageCollection();
    var collectionView = new PackageManagerTileListView({collection: collection});

    expect(collectionView.render()).toBe(collectionView);
  });

  it('should render empty collection into div with class "grid-view"', function () {
    var collection = new PackageManagerPackageCollection();
    var collectionView = new PackageManagerTileListView({collection: collection});

    var renderResult = collectionView.render();

    expect(renderResult.el.nodeName.toLowerCase()).toBe('div');
    expect(renderResult.$el.hasClass('grid-view')).toBeTruthy();
  });

  it('should render collection of two models', function () {
    var collection = new PackageManagerPackageCollection();
    collection.add({title: 'Package 1'});
    collection.add({title: 'Package 2'});
    var collectionView = new PackageManagerTileListView({collection: collection});

    var rendered = collectionView.render().$el;

    expect(rendered.children().length).toBe(2);
    expect(rendered.children().text()).toMatch('Package 1');
    expect(rendered.children().text()).toMatch('Package 2');
  });
});