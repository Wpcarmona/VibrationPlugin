// Empty constructor
function VibrationPlugin() {}

// Function to handle vibration
VibrationPlugin.prototype.vibrate = function(vibrationType, successCallback, errorCallback) {
    var options = [vibrationType];
    cordova.exec(successCallback, errorCallback, 'VibrationPlugin', 'vibrate', options);
}

// Installation constructor that binds VibrationPlugin to window
VibrationPlugin.install = function() {
    if (!window.plugins) {
        window.plugins = {};
    }
    window.plugins.vibrationPlugin = new VibrationPlugin();
    return window.plugins.vibrationPlugin;
};
cordova.addConstructor(VibrationPlugin.install);

