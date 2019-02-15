(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('AdminTeachSubtypeAddCtrl', ['$scope', '$log', 'MyDataService', 'DialogService', AdminTeachSubtypeAddCtrl]);

  function AdminTeachSubtypeAddCtrl($scope, $log, MyDataService, DialogService) {
    $log.debug('AdminTeachSubtypeAddCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('AdminTeachSubtypeAddCtrl destroy...');
    });

    $scope.types = DialogService.getCustomData().types;
    if (!$scope.types || $scope.types.length <= 0) {
      DialogService.showAlert('请先添加大类信息！', function() {
        DialogService.hideCustom();
      });
      return;
    }
    $scope.model = { tbTeachSubtype: { ttid: $scope.types[0].ttid } };

    $scope.closeMe = function() {
      DialogService.hideCustom();
    };

    $scope.add = function() {
      DialogService.showWait('添加中，请稍候...');
      MyDataService.send('/auth/teachsubtype/add', $scope.model, function(data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message);
        if (data.success) {
          $scope.model.tbTeachType = {};
        }
      });
    };
  }
})();
