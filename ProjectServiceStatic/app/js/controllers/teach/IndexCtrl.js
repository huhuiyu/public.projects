(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('TeachIndexCtrl', ['$scope', '$log', 'MyDataService', 'DialogService', 'MyUtilService', TeachIndexCtrl]);

  function TeachIndexCtrl($scope, $log, MyDataService, DialogService, MyUtilService) {
    $log.debug('TeachIndexCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('TeachIndexCtrl destroy...');
    });

    $scope.toSub = function(type) {
      MyUtilService.redirect('/route/page/teach/subtype', { ttid: type.ttid });
    };

    $scope.tbTeachType = {};

    $scope.query = function() {
      DialogService.showWait('信息查询中，请稍候');
      MyDataService.send('/teachtype/queryAll', { tbTeachType: $scope.tbTeachType }, function(data) {
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
