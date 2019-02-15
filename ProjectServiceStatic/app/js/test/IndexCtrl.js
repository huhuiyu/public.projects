(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('TestIndexCtrl', ['$scope', '$log', 'MyDataService', 'DialogService', 'MyUtilService', 'ToolService', TestIndexCtrl]);

  function TestIndexCtrl($scope, $log, MyDataService, DialogService, MyUtilService, ToolService) {
    $log.debug('TestIndexCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('TestIndexCtrl destroy...');
    });

    $scope.icons = ['&#xe613;', '&#xe851;', '&#xe64a;', '&#xe606;', '&#xe60a;', '&#xe664;', '&#xe625;', '&#xe601;', '&#xe619;', '&#xe608;', '&#xe61b;', '&#xe683;', '&#xe600;', '&#xe602;', '&#xe860;', '&#xe65a;', '&#xe6c9;', '&#xe63f;', '&#xe658;', '&#xe611;', '&#xeeb6;', '&#xe630;', '&#xe65b;', '&#xe607;', '&#xe637;', '&#xe669;', '&#xe609;', '&#xe612;'];

    $scope.auth = function() {
      DialogService.showWait('授权测试中...');
      MyDataService.send('/auth/getAdmin', {}, function(data) {
        DialogService.hideWait();
        $log.debug(data);
        $scope.data = MyUtilService.trustAsHtml(MyUtilService.formatJson(data, true));
        $log.debug(ToolService.getServerToken());
      });
    };
  }
})();
