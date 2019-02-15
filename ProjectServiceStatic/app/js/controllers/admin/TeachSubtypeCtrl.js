(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('AdminTeachSubtypeCtrl', ['$scope', '$log', 'MyDataService', 'DialogService', AdminTeachSubtypeCtrl]);

  function AdminTeachSubtypeCtrl($scope, $log, MyDataService, DialogService) {
    $log.debug('AdminTeachSubtypeCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('AdminTeachSubtypeCtrl destroy...');
    });

    $scope.tbTeachSubtype = {};
    $scope.types = [];

    $scope.showAdd = function() {
      DialogService.showCustom('templates/admin/teachsubtype-add.html', { types: $scope.types }, function() {
        $scope.query();
      });
    };

    $scope.showModify = function(subtype) {
      DialogService.showCustom('templates/admin/teachsubtype-modify.html', { subtype: subtype, types: $scope.types }, function() {
        $scope.query();
      });
    };

    $scope.showTypeName = function(subType) {
      for (var i = 0; i < $scope.types.length; i++) {
        var type = $scope.types[i];
        if (type.ttid == subType.ttid) {
          return type.typeName;
        }
      }
      return '';
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
      MyDataService.send('/auth/teachsubtype/queryAll', { page: $scope.page, tbTeachSubtype: $scope.tbTeachSubtype }, function(data) {
        DialogService.hideWait();
        if (data.success) {
          $scope.types = data.datas.types;
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
