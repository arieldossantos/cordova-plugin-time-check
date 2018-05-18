function CordovaTimeChecks() {}


CordovaTimeChecks.prototype.isAutomaticTimeZone = function(success, fail) {
  return cordova.exec(success, fail, 'CordovaTimeChecks', 'isAutomaticTimeZone', []);
}

CordovaTimeChecks.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.cordovaTimeChecks = new CordovaTimeChecks();
  return window.plugins.cordovaTimeChecks;
};

cordova.addConstructor(CordovaTimeChecks.install);