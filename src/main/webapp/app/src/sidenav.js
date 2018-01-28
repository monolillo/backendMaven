'use strict';

angular.module('app')
  .controller('SidenavCtrl', ['$location', 'AuthService', function ($location, AuthService) {
    var self = this;

    self.menuItems = [
      { name: 'Proveedores', url: '/proveedores', icon: 'work', private: true },
      { name: 'Descuentos', url: '/descuentos', icon: 'loyalty', private: false }
    ];

    self.go = function (route) {
      $location.url(route);
    }

    self.isSelected = function (route) {
      return route == $location.url();
    }

    self.canUse = function (item) {
      return item.private ? AuthService.guard() : true;
    }

  }]);