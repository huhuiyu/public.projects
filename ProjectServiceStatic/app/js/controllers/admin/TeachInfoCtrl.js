(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('AdminTeachInfoCtrl', ['$scope', '$log', 'MyDataService', 'DialogService', AdminTeachInfoCtrl]);

  function AdminTeachInfoCtrl($scope, $log, MyDataService, DialogService) {
    $log.debug('AdminTeachInfoCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('AdminTeachInfoCtrl destroy...');
    });

    $scope.tbTeachInfo = {};

    $scope.showAdd = function() {
      DialogService.showCustom('templates/admin/teachinfo-add.html', {}, function() {
        $scope.query();
      });
    };

    $scope.showModify = function(teachInfo) {
      DialogService.showCustom('templates/admin/teachinfo-modify.html', { teachInfo: teachInfo }, function() {
        $scope.query();
      });
    };

    //查询==================================================================
    $scope.page = {
      pageNumber: 1,
      pageSize: 10
    };

    $scope.toPage = function(pn) {
      //不能超出范围
      if (pn <= 0 || pn > $scope.page.pageCount || pn == $scope.page.pageNumber) {
        return;
      }
      //分页查询
      $scope.page.pageNumber = pn;
      $scope.query();
    };

    $scope.query = function() {
      DialogService.showWait('信息查询中，请稍候');
      MyDataService.send('/auth/teachinfo/queryAll', { page: $scope.page, tbTeachInfo: $scope.tbTeachInfo }, function(data) {
        DialogService.hideWait();
        if (data.success) {
          $scope.list = data.datas.list;
          $scope.page = data.datas.page;
          return;
        }
        DialogService.showAlert(data.message);
      });
    };

    $scope.query();
  }
})();
