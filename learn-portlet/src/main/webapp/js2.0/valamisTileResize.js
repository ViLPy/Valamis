function valamisTileResize(element) {

  var grid = element.find('.grid-view');
  var viewportWidth = jQuery(grid).width();

  if (viewportWidth >= 1680) {
    this.setWidthClass(grid, 0);
  }
  else if (viewportWidth >= 1250 && viewportWidth < 1680) {
    this.setWidthClass(grid, 1);
  }
  else if (viewportWidth >= 1000 && viewportWidth < 1250) {
    this.setWidthClass(grid, 2);
  }
  else if (viewportWidth >= 750 && viewportWidth < 1000) {
    this.setWidthClass(grid, 3);
  }
  else if (viewportWidth >= 400 && viewportWidth < 750) {
    this.setWidthClass(grid, 4);
  }
  else {
    this.setWidthClass(grid, 5);
  }
}

function setWidthClass(element, width) {
  element.removeClass('width0');
  element.removeClass('width1');
  element.removeClass('width2');
  element.removeClass('width3');
  element.removeClass('width4');
  element.removeClass('width5');

  var className = 'width' + width;
  element.addClass(className);
}