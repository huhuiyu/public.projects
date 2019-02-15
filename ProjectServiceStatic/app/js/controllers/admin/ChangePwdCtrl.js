(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('AdminChangePwdCtrl', ['$scope', '$log', 'MyDataService', 'DialogService', 'MyUtilService', AdminChangePwdCtrl]);

  function AdminChangePwdCtrl($scope, $log, MyDataService, DialogService, MyUtilService) {
    $log.debug('AdminChangePwdCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('AdminChangePwdCtrl destroy...');
    });

    $scope.model = {
      tbAdmin: {},
      oldPwd: '',
      pwd2: ''
    };

    $scope.closeMe = function() {
      DialogService.hideCustom();
    };

    $scope.save = function() {
      if (MyUtilService.empty($scope.model.oldPwd)) {
        DialogService.showAlert('旧必须填写');
        return;
      }
      if (MyUtilService.empty($scope.model.tbAdmin.password)) {
        DialogService.showAlert('密码必须填写');
        return;
      }
      if ($scope.model.tbAdmin.password != $scope.model.pwd2) {
        DialogService.showAlert('确认密码必须一致');
        return;
      }
      $scope.model.tbAdmin.password = MyUtilService.md5($scope.model.tbAdmin.password);
      $scope.model.oldPwd = MyUtilService.md5($scope.model.oldPwd);
      DialogService.showWait('密码修改中，请稍候...');
      MyDataService.send('/auth/admin/modifyPwd', $scope.model, function(data) {
        DialogService.hideWait();
        $scope.model.tbAdmin.password = '';
        $scope.model.oldPwd = '';
        $scope.model.pwd2 = '';
        DialogService.showAlert(data.message);
      });
    };
  }
})();
