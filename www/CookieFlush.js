var exec = require('cordova/exec');

exports.flush = function(arg0, success, error) {
  exec(success, error, 'CookieFlush', 'flush', [arg0]);
}
