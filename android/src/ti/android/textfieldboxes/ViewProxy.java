/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2017 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package ti.android.textfieldboxes;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

import android.app.Activity;
import android.graphics.Color;
import android.text.Editable;


// This proxy can be created by calling Textfieldboxes.createView({message: "hello world"})
@Kroll.proxy(creatableInModule=TextfieldboxesModule.class)
public class ViewProxy extends TiViewProxy
{
	// Standard Debugging variables
	private static final String LCAT = "ExampleProxy";
	private static final boolean DBG = TiConfig.LOGD;
	
	private TextFieldBoxesView textFieldBoxesView;
	
	// Constructor
	public ViewProxy()
	{
		super();
	}

	@Override
	public TiUIView createView(Activity activity)
	{
		textFieldBoxesView = new TextFieldBoxesView(this);
		return textFieldBoxesView;
	}

	// Handle creation options
	@Override
	public void handleCreationDict(KrollDict options)
	{
		super.handleCreationDict(options);
	}

	// Methods
	@Kroll.setProperty @Kroll.method
	public void setHintText(String hintText)
	{
		if(hintText instanceof String){
			textFieldBoxesView.textFieldBoxes.setLabelText(hintText);
		} else {
			Log.e(LCAT, "setHintText should receive strings");
		}
	}
	
	// Methods
	@Kroll.setProperty @Kroll.method
	public void setAlwaysShowHint(Boolean alwaysShowHint)
	{
		if(alwaysShowHint instanceof Boolean){
			textFieldBoxesView.textFieldBoxes.setAlwaysShowHint(alwaysShowHint);
		} else {
			Log.e(LCAT, "setAlwaysShowHint should receive Boolean");
		}
	}
	
	@Kroll.setProperty @Kroll.method
	public void setHasFocus(Boolean hasFocus)
	{
		if(hasFocus instanceof Boolean){
			textFieldBoxesView.textFieldBoxes.setHasFocus(hasFocus);
		} else {
			Log.e(LCAT, "setHasFocus should receive Boolean");
		}
	}
	
	@Kroll.setProperty @Kroll.method
	public void setTextColor(String textColor)
	{
		if(textColor instanceof String){
			textFieldBoxesView.extendedEditText.setTextColor(Color.parseColor(textColor));
		} else {
			Log.e(LCAT, "setTextColor should receive color strings. Ex: \"#212121\"");
		}
	}
	
	@Kroll.setProperty @Kroll.method
	public void setCounterTextColor(String counterTextColor)
	{
		if(counterTextColor instanceof String){
			textFieldBoxesView.textFieldBoxes.setCounterTextColor(Color.parseColor(counterTextColor));
		} else {
			Log.e(LCAT, "setCounterTextColor should receive color strings. Ex: \"#424242\"");
		}
	}
	
	@Kroll.method
	public void setError(String errorMessage, Boolean giveFocus)
	{
		if(errorMessage instanceof String){
			textFieldBoxesView.textFieldBoxes.setError(errorMessage, giveFocus);
		} else {
			Log.e(LCAT, "setError should receive strings for errorMessage and Boolean for giveFocus");
		}
	}
	
	@Kroll.setProperty @Kroll.method
	public void setErrorColor(String errorColor)
	{
		if(errorColor instanceof String){
			textFieldBoxesView.textFieldBoxes.setErrorColor(Color.parseColor(errorColor));
		} else {
			Log.e(LCAT, "setErrorColor should receive color strings. Ex: \"#F44336\"");
		}
	}
	
	@Kroll.setProperty @Kroll.method
	public void setPrimaryColor(String primaryColor)
	{
		if(primaryColor instanceof String){
			textFieldBoxesView.textFieldBoxes.setPrimaryColor(Color.parseColor(primaryColor));
		} else {
			Log.e(LCAT, "setPrimaryColor should receive color strings. Ex: \"#673AB7\"");
		}
	}
	
	@Kroll.setProperty @Kroll.method
	public void setSecondaryColor(String secondaryColor)
	{
		if(secondaryColor instanceof String){
			textFieldBoxesView.textFieldBoxes.setSecondaryColor(Color.parseColor(secondaryColor));
		} else {
			Log.e(LCAT, "setSecondaryColor should receive color strings. Ex: \"#B39DDB\"");
		}
	}
	
	@Kroll.setProperty @Kroll.method
	public void setPanelBackgroundColor(String panelBackgroundColor)
	{
		if(panelBackgroundColor instanceof String){
			textFieldBoxesView.textFieldBoxes.setPanelBackgroundColor(Color.parseColor(panelBackgroundColor));
		} else {
			Log.e(LCAT, "setPanelBackgroundColor should receive color strings. Ex: \"#E0E0E0\"");
		}
	}
	
	@Kroll.setProperty @Kroll.method
	public void setUseDenseSpacing(Boolean useDenseSpacing)
	{
		if(useDenseSpacing instanceof Boolean){
			textFieldBoxesView.textFieldBoxes.setUseDenseSpacing(useDenseSpacing);
		} else {
			Log.e(LCAT, "setUseDenseSpacing should receive booleans");
		}
	}
	
	@Kroll.setProperty @Kroll.method
	public void setHasClearButton(Boolean hasClearButton)
	{
		if(hasClearButton instanceof Boolean){
			textFieldBoxesView.textFieldBoxes.setHasClearButton(hasClearButton);
		} else {
			Log.e(LCAT, "setHasClearButton should receive booleans");
		}
	}
	
	@Kroll.setProperty @Kroll.method
	public void setHelperText(String helperText)
	{
		if(helperText instanceof String){
			textFieldBoxesView.textFieldBoxes.setHelperText(helperText);
		} else {
			Log.e(LCAT, "setHelperText should receive strings");
		}
	}
	
	@Kroll.setProperty @Kroll.method
	public void setMinCharacters(int minCharacters)
	{
		if(minCharacters == (int) minCharacters){
			textFieldBoxesView.textFieldBoxes.setMinCharacters(minCharacters);
		} else {
			Log.e(LCAT, "setMinCharacters should receive int");
		}
	}
	
	@Kroll.setProperty @Kroll.method
	public void setMaxCharacters(int maxCharacters)
	{
		if(maxCharacters == (int) maxCharacters){
			textFieldBoxesView.textFieldBoxes.setMaxCharacters(maxCharacters);
		} else {
			Log.e(LCAT, "setMaxCharacters should receive int");
		}
	}
	
	@Kroll.method
	public void removeMinCharacters()
	{
		textFieldBoxesView.textFieldBoxes.removeMinCharacters();
	}
	
	@Kroll.method
	public void removeMaxCharacters()
	{
		textFieldBoxesView.textFieldBoxes.removeMaxCharacters();
	}
	
	@Kroll.setProperty @Kroll.method
	public void setSuffixText(String suffixText)
	{
		if(suffixText instanceof String){
			textFieldBoxesView.extendedEditText.setSuffix(suffixText);
		} else {
			Log.e(LCAT, "setSuffixText should receive string");
		}
	}
	
	@Kroll.setProperty @Kroll.method
	public void setSuffixTextColor(String suffixTextColor)
	{
		if(suffixTextColor instanceof String){
			textFieldBoxesView.extendedEditText.setSuffixTextColor(Color.parseColor(suffixTextColor));
		} else {
			Log.e(LCAT, "setSuffixTextColor should receive color strings. Ex: \"#757575\"");
		}
	}
	
	@Kroll.setProperty @Kroll.method
	public void setPrefixText(String prefixText)
	{
		if(prefixText instanceof String){
			textFieldBoxesView.extendedEditText.setPrefix(prefixText);
		} else {
			Log.e(LCAT, "setPrefixText should receive int");
		}
	}
	
	@Kroll.setProperty @Kroll.method
	public void setPrefixTextColor(String prefixTextColor)
	{
		if(prefixTextColor instanceof String){
			textFieldBoxesView.extendedEditText.setPrefixTextColor(Color.parseColor(prefixTextColor));
		} else {
			Log.e(LCAT, "setPrefixTextColor should receive color strings. Ex: \"#757575\"");
		}
	}
	
	@Kroll.setProperty @Kroll.method
	public void setText(String text)
	{
		if(text instanceof String){
			if (!TextFieldBoxesView.isTextFieldUpdating) {
				textFieldBoxesView.extendedEditText.setText(text);
				textFieldBoxesView.extendedEditText.setSelection(text.length());
			}
		} else {
			Log.e(LCAT, "setText should receive strings.");
		}
	}
	
	@Kroll.method
	public void setSelection(int selection)
	{
		if(selection == (int) selection){
			textFieldBoxesView.extendedEditText.setSelection(selection);
		} else {
			Log.e(LCAT, "setSelection should receive int");
		}
	}
	
	@Kroll.getProperty @Kroll.method
	public String getText()
	{
		return textFieldBoxesView.extendedEditText.getText().toString();
	}
	
	@Kroll.setProperty @Kroll.method
	public void setTheme(int theme)
	{
		textFieldBoxesView.setTheme(theme);
	}
	
	@Kroll.setProperty @Kroll.method
	public void setIconSignifier(String iconSignifier)
	{
		textFieldBoxesView.setIconSignifier(iconSignifier);
	}
	
	@Kroll.setProperty @Kroll.method
	public void setIsResponsiveIconColor(Boolean isResponsiveIconColor)
	{
		textFieldBoxesView.setIsResponsiveIconColor(isResponsiveIconColor);
	}
	
	@Kroll.setProperty @Kroll.method
	public void setEndIcon(String endIcon)
	{
		textFieldBoxesView.setEndIcon(endIcon);
	}
	
	@Kroll.setProperty @Kroll.method
	public void setMaxLength(int length)
	{
		if(length == (int) length){
			textFieldBoxesView.setMaxLength(length);
		} else {
			Log.e(LCAT, "setSelection should receive int");
		}
	}
	
	@Kroll.setProperty @Kroll.method
	public void setKeyboardType(int keyboardType)
	{
		if(keyboardType == (int) keyboardType){
			textFieldBoxesView.extendedEditText.setInputType(keyboardType);
		} else {
			Log.e(LCAT, "keyboardType should receive int");
		}
	}
}
