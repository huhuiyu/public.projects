(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('IndexCtrl', ['$scope', '$log', 'MyUtilService', IndexCtrl]);

  function IndexCtrl($scope, $log, MyUtilService) {
    $log.debug('IndexCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('IndexCtrl destroy...');
    });

    $scope.isMobile = MyUtilService.isMobile();

    $scope.toTopWeb = function() {
      location = 'http://huhuiyu.top';
    };

    $scope.toCnWeb = function() {
      location = 'http://huhuiyu.cn';
    };

    $scope.toStudy = function() {
      MyUtilService.redirect('/route/page/teach/index');
    };
  }
})();
