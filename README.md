# cordova-plugin-android-native-pdfviewer


### Installation ionic plugin 

```
ionic plugin add cordova-plugin-android-native-pdfviewer
```

### Supported Platforms
- Android

### Example

```
var options = { 
                headerColor:"#000000",
                showScroll:true, 
                showShareButton:true, 
                showCloseButton:true, 
                swipeHorizontal:false 
              };
              
AndroidNativePdfViewer.openPdfUrl(url, title, options, 
                        function(success){
                        // success callback
                        },function(error){
                        // error callback
                        });
```
