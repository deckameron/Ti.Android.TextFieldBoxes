# Ti.Android.TextFieldBoxes

![Animation](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/tfb1.gif)

Titanium Android library that provides access to [HITGIF](https://github.com/HITGIF) awesome [TextFieldBoxes](https://github.com/HITGIF/TextFieldBoxes). 
A new Material Design text field that comes in a box, based on [Google Material Design guidelines](https://material.io/guidelines/components/text-fields.html#text-fields-text-field-boxes).
​
## Getting Started

View the [Using Titanium Modules](http://docs.appcelerator.com/titanium/latest/#!/guide/Using_Titanium_Modules) document for instructions on getting started with using this module in your application.

## Requirements

- [x] Titanium SDK 7.0.0+
 
### Download

Download the Ti.Android.TextFieldBoxes module  [here](https://github.com/deckameron/Ti.Android.TextFieldBoxes/tree/master/android/dist).
​
## Usage

#### Table of Contents
1. [Basic](#basic)
2. [Enable / Disable](#enable)
3. [Helper Text & Error Text](#helper)
4. [Prefix & Suffix](#prefix)
5. [Max & Min Characters](#max)
6. [Icon Signifier](#icon)
7. [End Icon](#end)
8. [Clear Button](#clear)
9. [Custom Colors](#color)
10. [Dense Spacing](#dense)
11. [Always Show Hint](#hint)
12. [Text Change Watcher](#watcher)
13. [Dark Theme](#dark)
14. [Masks](#masks)

#### <a id="basic"/>  1. Basic

Add `studio.carbonylgroup.textfieldboxes.TextFieldBoxes` that contains a `studio.carbonylgroup.textfieldboxes.ExtendedEditText` to your layout:

```javascript
...
var TextFieldBoxes = require('ti.android.textfieldboxes');

var TFBoxes = TextFieldBoxes.createView({
    top : 16,
    left : 16,
    right : 16,
    hintText : "Label"
});
masterView.add(TFBoxes);
...
```

*NOTE that `hintText` is optional

![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/label.png)![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/input.png)

#### <a id="enable"/>  2. Enable / Disable

`enabled` on creation or `setEnabled(boolean enabled)`

```javascript
var TFBoxes = TextFieldBoxes.createView({
    ...
    enabled : false
});
```

![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/basic_disabled.png)

#### <a id="helper"/>  3. Helper Text & Error Text

_**NOTE:** setting helper or error text to anything **not empty** will make the bottom view (which contains the helper label) visible and increase the height of the TextFieldBoxes. So if you want to always keep the bottom view visible (height increased), set the helper text to `" "` when there should be nothing._

helper text: `helperText` on creation or `setHelperText(String helperText)`


```javascript
var TFBoxes = TextFieldBoxes.createView({
    ...
    helperText : "Helper is here"
});
```

![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/helper.png)

error text: `setError(String errorText, boolean giveFocus)`

 Param `giveFocus` determines whether the field will gain focus when set error on. If `true`, the field gains focus immediately.

*NOTE: Error will be removed when the text changes (input or delete).*

```javascript
setError("Error message", true);
```

![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/error.png)

#### <a id="prefix"/>  4. Prefix & Suffix

Use `prefix` on creation or `setPrefix(String prefix)` to set the unselectable prefix text at the start of the field.

Use `suffix` in on creation or `setSuffix(String suffix)` to set the unselectable suffix text at the end of the field.

```javascript
var TFBoxes = TextFieldBoxes.createView({
    ...
    prefix : "$ "
});
```

![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/prefix.png)


```javascript
var TFBoxes = TextFieldBoxes.createView({
    ...
    suffix : "@gmail.com"
});
```

![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/suffix.png)

#### <a id="max"/>  5. Max & Min Characters

_**NOTE:** setting max or min character will make the bottom view (which contains the counter label) visible and increase the height of the TextFieldBoxes._

Use `maxCharacters` on creation or `setMaxCharacters(int maxCharacters)` to set the max characters count. Use `removeMaxCharacters()` to remove the limit.

Use `minCharacters` on creation or `setMinCharacters(int minCharacters)` to set the min characters count. Use `removeMinCharacters()` to remove the limit.

The color of the bottom line will turn to `errorColor` (red by default) when exceeding max or min characters limit. `0`, as default, means no max or min characters limit.

*NOTE: Space and line feed will NOT count.*

```javascript
var TFBoxes = TextFieldBoxes.createView({
    ...
    maxCharacters : "10",
    minCharacters : "5"
});
```

![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/maxMinChar.gif)

```javascript
var TFBoxes = TextFieldBoxes.createView({
    ...
    maxCharacters : "5"
});
```

![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/maxChar.gif)

#### <a id="icon"/>  6. Icon Signifier

Use `iconSignifier` on creation or `setIconSignifier(String resourceName)` to set the icon that is shown in front of the TextFieldBoxes if you want there to be one.
**NOTE  that the image resources  should be in `/platform/android/res/drawable-{density}` folders**

You can use`isResponsiveIconColor` on creation or `setIsResponsiveIconColor(boolean isResponsiveIconColor)` in Java code to set whether the icon will change its color when gaining or losing focus as the label text and the bottomLine do.
**NOTE that if `true`, the icon's color will always be `HighlightColor` (the same as the bottomLine) that will turn gray when losing focus. If `false`, the icon will always be in `primaryColor`.**

```javascript
var TFBoxes = TextFieldBoxes.createView({
    ...
    iconSignifier : "baseline_vpn_key_black_24dp"
});
```

![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/icon1.png)![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/icon2.png)

You can create the `TextFieldBoxes.END_ICON_CLICK` event to define what will happen when it's clicked.

```javascript
TFBoxes.addEventListener(TextFieldBoxes.ICON_IMAGE_CLICK, function(e){
    // What you want to do when it's clicked
});
```

#### <a id="end"/>  7. End Icon

Use `endIcon` in xml or `setEndIcon(String resourceName)` to set the icon of the ImageButton that is shown at the end of the field if you want there to be one.
**NOTE  that the image resources  should be in `/platform/android/res/drawable-{density}` folders**

```javascript
var TFBoxes = TextFieldBoxes.createView({
    ...
    endIcon : "ic_mic_black_24dp"
});
```

![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/mic.png)

To make it useful (trigger voice input, dropdown event), you would like to add the  `TextFieldBoxes.END_ICON_CLICK` event to set, for example, what will happen when it's clicked, or anything else you want.

```javascript
TFBoxes.addEventListener(TextFieldBoxes.END_ICON_CLICK, function(e){
    // What you want to do when it's clicked
});
```

#### <a id="clear"/>  8. Clear Button

Use `hasClearButton` on creation or `setHasClearButton(boolean hasClearButton)` to set whether to show the clear button.

If `true`, a clear button will be shown at the end when there are characters (**ANY** character) entered in the field.

```javascript
var TFBoxes = TextFieldBoxes.createView({
    ...
    hasClearButton : true
});
```

![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/clearButton.png)

#### <a id="color"/>  9. Custom Colors

*Primary Color* will be used for the color of the underline, the floating label text and the icon signifier **when HAVING focus**. You can use `primaryColor` on creation or `setPrimaryColor(String color)`. It is set <font color="#673ab7">**`#673AB7`**</font> by default.

*Secondary Color* will be used for the color of the underline, the floating label text and the icon signifier **when NOT HAVING focus**. You can use `secondaryColor` on creation or `setSecondaryColor(String color)`. It is set <font color="#b39ddb">**`#B39DDB`**</font> by default.

*Error Color* will be used for the color that indicates error (e.g. exceeding max characters, `setError()`). You can use `errorColor` on creation or `setErrorColor(String color)`. It is set <font color="#f44336">**`#F44336`**</font> by default.

*Helper Text Color* will be used for the color of the helper text. You can use `helperTextColor` in xml or `setHelperTextColor(String color)` . It is set <font color="#757575">**`#757575`**</font> by default.

*Panel Background Color* will be used for the color of panel at the back. You can use `panelBackgroundColor` on creation or `setPanelBackgroundColor(String color)`. It is set <font color="#E0E0E0">**`#E0E0E0`**</font> by default.

```xml
<studio.carbonylgroup.textfieldboxes.TextFieldBoxes
    ...
    app:primaryColor="#1B5E20"
    app:errorColor="#ddaa00"
    app:helperTextColor="#795548"
    app:panelBackgroundColor="#ffe8e8"
    >
```
```javascript
var TFBoxes = TextFieldBoxes.createView({
    ...
    primaryColor : "#1B5E20",
    errorColor : "#ddaa00",
    helperTextColor : "#795548",
    panelBackgroundColor : "#ffe8e8"
});
```

![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/customColor1.png) ![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/customColor2.png)


#### <a id="dense"/>  10. Dense Spacing

You can make the layout compact by using a dense verticle spacing to improve user experience in some cases.

![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/denseSpacing.png)

Use `app:useDenseSpacing` in xml or `setUseDenseSpacing(boolean useDenseSpacing)` to set whether the field uses a dense spacing between its elements.

```javascript
var TFBoxes = TextFieldBoxes.createView({
    ...
    useDenseSpacing : true
});
```

![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/dense.png)

#### <a id="hint"/>  11. Always Show Hint

Sometimes you may want the label and the hint to show different messages, but need the hint to always be shown (instead being blocked by the label when losing focus).

Use `alwaysShowHint` on creation or `setAlwaysShowHint(boolean alwaysShowHint)` to set whether the label is fixed at top when there's a hint in the EditText.

```javascript
var TFBoxes = TextFieldBoxes.createView({
    ...
    alwaysShowHint : true
});
```

![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/alwaysHint.png)

#### <a id="watcher"/>  12. Text Change

Another event you can monitor is the `ON_TEXT_CHANGE`. This is good event to apply masks, for example: Money, ZIP code and phone numbers.

```javascript
TFBoxes.addEventListener(TextFieldBoxes.ON_TEXT_CHANGE, function(e){
    // What you want to do when it's clicked
});
```

#### <a id="dark"/>  13. Theme

TextFieldBoxes use the color attributes within the current theme, but you can also choose if you want `LIGHT_THEME` or `DARK_THEME`.

```javascript
var TFBoxes = TextFieldBoxes.createView({
    ...
    theme : TextFieldBoxes.LIGHT_THEME
});
```
![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/lightTheme.gif)

```javascript
var TFBoxes = TextFieldBoxes.createView({
    ...
    theme : TextFieldBoxes.DARK_THEME
});
```
![](https://raw.githubusercontent.com/HITGIF/TextFieldBoxes/master/images/darkTheme.gif)

​
## All Attributes

##### Texts

| Attribute | Description |
| --- | --- |
| `labelText` | Floating label text at the top |
| `helperText` | Helper text at the bottom |
| `prefix` | Prefix Text |
| `suffix` | Suffix Text |

##### Colors

| Attribute | Description | Default |
| --- | --- | --- |
| `helperTextColor` | Helper text color | <font color="#757575">**#757575**</font> |
| `counterTextColor` | Counter text color | <font color="#424242">**#424242**</font> |
| `errorColor` | The color that is used to indicate error (e.g. exceeding max characters, `setError()`) | <font color="#f44336">**#F44336**</font> |
| `primaryColor` | The color for the underline, the floating label text and the icon signifier **when HAVING FOCUS** | <font color="#673ab7">**#673AB7**</font> |
| `secondaryColor` | The color for the underline, the floating label text and the icon signifier **when NOT HAVING FOCUS** | <font color="#b39ddb">**#B39DDB**</font> |
| `panelBackgroundColor` | The color for the panel at the back | <font color="#E0E0E0">**#E0E0E0**</font> |
| `prefixTextColor` | Prefix text color | <font color="#757575">**#757575**</font> |
| `suffixTextColor` | Suffix text color | <font color="#757575">**#757575**</font> |

##### Icons
***NOTE  that the image resources  should be in `/platform/android/res/drawable-{density}` folders***

| Attribute | Description | Default |
| --- | --- | --- |
| `iconSignifier` | The string ID of the icon before the TextFieldBoxes | `0` |
| `endIcon` | The string ID of the icon at the end of the field | `0` |
| `isResponsiveIconColor` | whether the icon signifier will change its color when gaining or losing focus as the label and the bottomLine do | `True` |

##### Characters counter

| Attribute | Description | Default |
| --- | --- | --- |
| `maxCharacters` | Max characters count limit. `0` means no limit | `0` |
| `minCharacters` | Min characters count limit. `0` means no limit | `0` |

##### Others

| Attribute | Description | Default |
| --- | --- | --- |
| `enabled` | Whether the text field is enabled | `True` |
| `hasClearButton` | Whether to show the clear button at the end of the EditText | `False` |
| `hasFocus` | Whether the EditText is having the focus | `False` |
| `alwaysShowHint` | Whether the label is fixed at top when there's a hint in the EditText | `False` |
| `useDenseSpacing` | Whether the field uses a dense spacing between its elements | `False` |
| `manualValidateError` | Whether to validate error state only when `validate()` is called | `False` |

#### <a id="masks"/>  14. Masks

You can apply masks to your code in javascript like this:
```javascript
var TFBoxes = TextFieldBoxes.createView({
    ...
});

TFBoxes.addEventListener(TextFieldBoxes.ON_TEXT_CHANGE, function(e){
    TFBoxes.setText(MaskCpf(e.text));
});

var MaskCpf = function(v){
    v=v.replace(/\D/g,"");
    v=v.replace(/(\d{3})(\d)/,"$1.$2");
    v=v.replace(/(\d{3})(\d)/,"$1.$2");
    v=v.replace(/(\d{3})(\d{1,2})$/,"$1-$2");
    return v;
};
```

You can find more masks [here](https://gist.github.com/deckameron/786100e3bd43394d24b64a86451b0d57)
