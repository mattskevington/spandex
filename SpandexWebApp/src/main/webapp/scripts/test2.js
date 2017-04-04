(function(angular) {
  'use strict';
angular.module('mattSimpleDirective', [])
  .directive('myHello', function() {
    return {
      template: "<h1>Hello Matt</h1>"
    };
  });
})(window.angular);