(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('AdminTeachInfoAddCtrl', ['$scope', '$log', 'MyDataService', 'DialogService', AdminTeachInfoAddCtrl]);

  function AdminTeachInfoAddCtrl($scope, $log, MyDataService, DialogService) {
    $log.debug('AdminTeachInfoAddCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('AdminTeachInfoAddCtrl destroy...');
    });

    $scope.model = { tbTeachInfo: {} };

    $scope.closeMe = function() {
      DialogService.hideCustom();
    };

    //表单信息查询
    $scope.queryAddBaseInfo = function() {
      MyDataService.send('/auth/teachinfo/queryAddBaseInfo', {}, function(data) {
        if (data.success) {
          $scope.infotypes = data.datas.infotypes;
          $scope.types = data.datas.types;
          $scope.model.ttid = $scope.types[0].ttid;
          $scope.model.tbTeachInfo.scid = $scope.infotypes[0].scid;
          $scope.querySubtype();
          return;
        }
        DialogService.showAlert(data.message);
      });
    };

    $scope.queryAddBaseInfo();

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

    //添加
    $scope.add = function() {
      DialogService.showWait('数据添加中，请稍候...');
      MyDataService.send('/auth/teachinfo/add', $scope.model, function(data) {
        DialogService.hideWait();
        if (data.success) {
          $scope.model.tbTeachInfo.info = '';
          $scope.model.tbTeachInfo.link = '';
        }
        DialogService.showAlert(data.message);
      });
    };
  }
})();
