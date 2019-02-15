(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('AdminTeachTypeAddCtrl', ['$scope', '$log', 'MyDataService', 'DialogService', AdminTeachTypeAddCtrl]);

  function AdminTeachTypeAddCtrl($scope, $log, MyDataService, DialogService) {
    $log.debug('AdminTeachTypeAddCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('AdminTeachTypeAddCtrl destroy...');
    });

    $scope.model = { tbTeachType: {} };

    $scope.closeMe = function() {
      DialogService.hideCustom();
    };

    $scope.add = function() {
      DialogService.showWait('添加中，请稍候...');
      MyDataService.send('/auth/teachtype/add', $scope.model, function(data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message);
        if (data.success) {
          $scope.model.tbTeachType = {};
        }
      });
    };
  }
})();
