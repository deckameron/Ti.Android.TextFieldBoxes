var TextFieldBoxes = require('ti.android.textfieldboxes');
    
var window = Titanium.UI.createWindow({
    backgroundColor : '#FFFFFF',
    layout : 'vertical'
});

var TFBoxes = TextFieldBoxes.createView({
    top : 16,
    left : 16,
    right : 16,
    theme : TextFieldBoxes.DARK_THEME,
    hintText : "Write your email",
    hasClearButton : false,
    helperText : "Must fill this",
    minCharacters : 1,
    suffixText : " @gmail.com",
    //textColor : "#212121",                //grey 900
    //counterTextColor : "#424242",         //grey 800
    //errorColor : "#f44336",               //red 500
    //primaryColor : "#673ab7",             //DeepPurple 500
    //secondaryColor : "#b39ddb",           //DeepPurple 200
    //panelBackgroundColor : "#e0e0e0",     //grey 300
    //prefixText : "R$ ",
    //iconSignifier : "baseline_search_white_24",
    //endIcon : "baseline_mic_white_24"
    //suffixTextColor : "#757575"           //grey 600
});
window.add(TFBoxes);

TFBoxes.addEventListener(TextFieldBoxes.END_ICON_CLICK, function(e){
    Ti.API.info(JSON.stringify(e));
});

TFBoxes.addEventListener(TextFieldBoxes.ICON_IMAGE_CLICK, function(e){
    Ti.API.info(JSON.stringify(e));
});

TFBoxes.addEventListener(TextFieldBoxes.ON_TEXT_CHANGE, function(e){
    Ti.API.info(JSON.stringify(e));
});

window.open();