(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('AdminTeachSubtypeModifyCtrl', ['$scope', '$log', 'MyDataService', 'DialogService', AdminTeachSubtypeModifyCtrl]);

  function AdminTeachSubtypeModifyCtrl($scope, $log, MyDataService, DialogService) {
    $log.debug('AdminTeachSubtypeModifyCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('AdminTeachSubtypeModifyCtrl destroy...');
    });
    var customData = DialogService.getCustomData();

    $scope.types = customData.types;

    if (!$scope.types || $scope.types.length <= 0) {
      DialogService.showAlert('请先添加大类信息！', function() {
        DialogService.hideCustom();
      });
      return;
    }

    $scope.model = { tbTeachSubtype: angular.copy(customData.subtype) };

    $scope.closeMe = function() {
      DialogService.hideCustom();
    };

    $scope.save = function() {
      DialogService.showWait('修改中，请稍候...');
      MyDataService.send('/auth/teachsubtype/update', $scope.model, function(data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message);
      });
    };
  }
})();
