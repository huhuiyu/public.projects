(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('TeachInfoCtrl', ['$scope', '$log', '$location', 'MyDataService', 'DialogService', 'MyUtilService', TeachInfoCtrl]);

  function TeachInfoCtrl($scope, $log, $location, MyDataService, DialogService, MyUtilService) {
    $log.debug('TeachInfoCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('TeachInfoCtrl destroy...');
    });

    var ttid = $location.search().ttid;
    var ossurl = '';

    $scope.tbTeachInfo = { tstid: $location.search().tstid };

    $scope.toSub = function() {
      MyUtilService.redirect('/route/page/teach/subtype', { ttid: ttid });
    };

    $scope.openLink = function(info) {
      if (info.linktype && info.linktype.infoCode && info.linktype.infoCode == 't01') {
        window.open(ossurl + info.link + '&ts=' + new Date().getTime());
      } else {
        window.open(info.link);
      }
    };

    $scope.query = function() {
      DialogService.showWait('信息查询中，请稍候');
      MyDataService.send('/teachinfo/queryBySubtype', { tbTeachInfo: $scope.tbTeachInfo }, function(data) {
        DialogService.hideWait();
        if (data.success) {
          $scope.list = data.datas.list;
          ossurl = data.datas.config.infoValue;
          return;
        }
        DialogService.showAlert(data.message);
      });
    };

    $scope.query();
  }
})();
