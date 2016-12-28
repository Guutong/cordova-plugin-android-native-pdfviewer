var exec = require('cordova/exec');

exports.openPdfUrl = function(url, header,options,success, error) {
    exec(success, error, "AndroidNativePdfViewer", "openPdfUrl", [url,header,options]);
};
