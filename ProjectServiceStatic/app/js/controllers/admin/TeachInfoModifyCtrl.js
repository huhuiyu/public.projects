(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('AdminTeachInfoModifyCtrl', ['$scope', '$log', 'MyDataService', 'DialogService', AdminTeachInfoModifyCtrl]);

  function AdminTeachInfoModifyCtrl($scope, $log, MyDataService, DialogService) {
    $log.debug('AdminTeachInfoModifyCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('AdminTeachInfoModifyCtrl destroy...');
    });

    var customData = DialogService.getCustomData();

    $scope.model = {};

    $scope.closeMe = function() {
      DialogService.hideCustom();
    };

    //表单信息查询
    $scope.queryModifyBaseInfo = function() {
      MyDataService.send('/auth/teachinfo/queryModifyBaseInfo', { tbTeachInfo: angular.copy(customData.teachInfo) }, function(data) {
        if (data.success) {
          $scope.infotypes = data.datas.infotypes;
          $scope.types = data.datas.types;
          $scope.subtypes = data.datas.subtypes;
          $scope.model = { tbTeachInfo: angular.copy(customData.teachInfo), ttid: $scope.subtypes[0].ttid };
          return;
        }
        DialogService.showAlert(data.message);
      });
    };

    $scope.queryModifyBaseInfo();

    $scope.querySubtype = function() {
      MyDataService.send('/teachsubtype/queryByType', { tbTeachSubtype: { ttid: $scope.model.ttid } }, function(data) {
        if (data.success) {
          $scope.subtypes = data.datas.list;
          $scope.model.tbTeachInfo.tstid = $scope.subtypes[0].tstid;
          return;
        }
        DialogService.showAlert(data.message);
      });
    };

    //修改
    $scope.save = function() {
      DialogService.showWait('数据修改中，请稍候...');
      MyDataService.send('/auth/teachinfo/update', $scope.model, function(data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message);
      });
    };
  }
})();
