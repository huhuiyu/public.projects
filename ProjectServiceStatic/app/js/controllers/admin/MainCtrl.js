(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('AdminMainCtrl', ['$scope', '$log', '$location', '$timeout', 'MyDataService', 'DialogService', 'MyUtilService', AdminMainCtrl]);

  function AdminMainCtrl($scope, $log, $location, $timeout, MyDataService, DialogService, MyUtilService) {
    $log.debug('AdminMainCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('AdminMainCtrl destroy...');
    });
    //用户信息=====================================================================================
    $scope.model = {
      tbAdmin: {}
    };

    $scope.getAdminInfo = function() {
      MyDataService.send('/TbAdmin/getAdminInfo', {}, function(data) {
        if (data.datas && data.datas.admin) {
          $scope.userinfo = data.datas.admin;
          return;
        }
        DialogService.showAlert('用户信息不存在', function() {
          MyUtilService.redirect('/route/page/admin/index');
        });
      });
    };

    $scope.getAdminInfo();

    $scope.changePwd = function() {
      DialogService.showCustom('templates/admin/changepwd.html');
    };

    $scope.logout = function() {
      DialogService.showWait('安全退出中，请稍候...');
      MyDataService.send('/TbAdmin/logout', {}, function(data) {
        DialogService.hideWait();
        if (data.success) {
          MyUtilService.redirect('/route/page/admin/index');
          return;
        }
        DialogService.showAlert(data.message);
      });
    };
    //菜单管理=====================================================================================
    var menuBasePath = 'templates/admin/';
    $scope.menus = [{ key: 'teachtype.html', text: '教学网站类型管理' }, { key: 'teachsubtype.html', text: '教学网站小类管理' }, { key: 'teachinfo.html', text: '教学信息管理' }];

    $scope.changePage = function(index) {
      MyUtilService.redirect('/route/page/admin/main', { menuid: index });
    };

    $scope.menuid = 0;
    $scope.changeInc = function() {
      $scope.menuid = 0;
      if (isNaN($location.search().menuid)) {
        $scope.menuid = 0;
      } else {
        $scope.menuid = parseInt($location.search().menuid);
      }
      if ($scope.menuid < 0 || $scope.menuid >= $scope.menus.length) {
        $scope.menuid = 0;
      }
      $timeout(function() {
        $scope.menu = menuBasePath + $scope.menus[$scope.menuid].key;
      }, 1);
    };

    $scope.changeInc();
  }
})();
