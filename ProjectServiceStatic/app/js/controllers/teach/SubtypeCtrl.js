(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('TeachSubtypeCtrl', ['$scope', '$log', '$location', 'MyDataService', 'DialogService', 'MyUtilService', TeachSubtypeCtrl]);

  function TeachSubtypeCtrl($scope, $log, $location, MyDataService, DialogService, MyUtilService) {
    $log.debug('TeachSubtypeCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('TeachSubtypeCtrl destroy...');
    });

    $scope.toIndex = function() {
      MyUtilService.redirect('/route/page/teach/index');
    };

    $scope.tbTeachSubtype = { ttid: $location.search().ttid };

    $scope.toInfo = function(type) {
      MyUtilService.redirect('/route/page/teach/info', { tstid: type.tstid, ttid: $scope.tbTeachSubtype.ttid });
    };

    $scope.query = function() {
      DialogService.showWait('信息查询中，请稍候');
      MyDataService.send('/teachsubtype/queryByType', { tbTeachSubtype: $scope.tbTeachSubtype }, function(data) {
        DialogService.hideWait();
        if (data.success) {
          $scope.list = data.datas.list;
          return;
        }
        DialogService.showAlert(data.message);
      });
    };

    $scope.query();
  }
})();
