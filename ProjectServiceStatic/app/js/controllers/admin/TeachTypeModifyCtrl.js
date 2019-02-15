(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('AdminTeachTypeModifyCtrl', ['$scope', '$log', 'MyDataService', 'DialogService', AdminTeachTypeModifyCtrl]);

  function AdminTeachTypeModifyCtrl($scope, $log, MyDataService, DialogService) {
    $log.debug('AdminTeachTypeModifyCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('AdminTeachTypeModifyCtrl destroy...');
    });

    $scope.model = { tbTeachType: angular.copy(DialogService.getCustomData().type) };

    $scope.closeMe = function() {
      DialogService.hideCustom();
    };

    $scope.save = function() {
      DialogService.showWait('修改中，请稍候...');
      MyDataService.send('/auth/teachtype/update', $scope.model, function(data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message);
      });
    };
  }
})();
