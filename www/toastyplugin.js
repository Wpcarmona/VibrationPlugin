// Empty constructor
function ToastyPlugin() {}

// Function to show toast
ToastyPlugin.prototype.showToast = function(message, duration, successCallback, errorCallback) {
    var options = [message, duration];
    cordova.exec(successCallback, errorCallback, 'ToastyPlugin', 'showToast', options);
}

// Function to handle vibration
ToastyPlugin.prototype.vibrate = function(vibrationType, successCallback, errorCallback) {
    var options = [vibrationType];
    cordova.exec(successCallback, errorCallback, 'ToastyPlugin', 'vibrate', options);
}

// Installation constructor that binds ToastyPlugin to window
ToastyPlugin.install = function() {
    if (!window.plugins) {
        window.plugins = {};
    }
    window.plugins.toastyPlugin = new ToastyPlugin();
    return window.plugins.toastyPlugin;
};
cordova.addConstructor(ToastyPlugin.install);
