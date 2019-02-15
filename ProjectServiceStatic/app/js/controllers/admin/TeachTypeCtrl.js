(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('AdminTeachTypeCtrl', ['$scope', '$log', 'MyDataService', 'DialogService', AdminTeachTypeCtrl]);

  function AdminTeachTypeCtrl($scope, $log, MyDataService, DialogService) {
    $log.debug('AdminTeachTypeCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('AdminTeachTypeCtrl destroy...');
    });

    $scope.tbTeachType = {};

    $scope.showAdd = function() {
      DialogService.showCustom('templates/admin/teachtype-add.html', {}, function() {
        $scope.query();
      });
    };

    $scope.showModify = function(type) {
      DialogService.showCustom('templates/admin/teachtype-modify.html', { type: type }, function() {
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
      MyDataService.send('/auth/teachtype/queryAll', { page: $scope.page, tbTeachType: $scope.tbTeachType }, function(data) {
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
