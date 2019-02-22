
package ti.android.textfieldboxes;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.util.TiRHelper;
import org.appcelerator.titanium.util.TiRHelper.ResourceNotFoundException;
import org.appcelerator.titanium.view.TiUIView;

import studio.carbonylgroup.textfieldboxes.ExtendedEditText;
import studio.carbonylgroup.textfieldboxes.SimpleTextChangedWatcher;
import studio.carbonylgroup.textfieldboxes.TextFieldBoxes;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

public class TextFieldBoxesView extends TiUIView {
	
	private static final String LCAT = "TextFieldBoxesView";
	
	public TextFieldBoxes textFieldBoxes;
	public ExtendedEditText extendedEditText;
	private TiViewProxy _proxy;
	static Context appContext;

	public TextFieldBoxesView(TiViewProxy proxy) {
		
		super(proxy);
		
		_proxy = this.proxy;
		appContext = _proxy.getActivity();
		
		int module_layout_id = 0;
		int extended_edit_text_id = 0;
		int text_field_box_id = 0;
		
		try {
			module_layout_id = TiRHelper.getApplicationResource("layout.module_layout");
			text_field_box_id = TiRHelper.getApplicationResource("id.text_field_box");
			extended_edit_text_id = TiRHelper.getApplicationResource("id.extended_edit_text");
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		
		LayoutInflater inflater = LayoutInflater.from(appContext);
		RelativeLayout moduleWrapper = (RelativeLayout) inflater.inflate(module_layout_id, null);
		textFieldBoxes = (TextFieldBoxes) moduleWrapper.findViewById(text_field_box_id);
		extendedEditText = (ExtendedEditText) textFieldBoxes.findViewById(extended_edit_text_id);
		
		textFieldBoxes.getEndIconImageButton().setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View view) {
		        // What you want to do when it's clicked
		    	Log.d(LCAT, "EndIcon Click");
		    	_proxy.fireEvent(TextfieldboxesModule.END_ICON_CLICK, new KrollDict());
		    }
		});
		
		textFieldBoxes.getIconImageButton().setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View view) {
		        // What you want to do when it's clicked
		    	Log.d(LCAT, "IconImage onClick");
		    	_proxy.fireEvent(TextfieldboxesModule.ICON_IMAGE_CLICK, new KrollDict());
		    }
		});
		
		textFieldBoxes.setSimpleTextChangeWatcher(new SimpleTextChangedWatcher() {
		    @Override
		    public void onTextChanged(String theNewText, boolean isError) {
		        // What you want to do when text changes
		    	KrollDict props = new KrollDict();
		    	props.put("text", theNewText);
		    	_proxy.fireEvent(TextfieldboxesModule.ON_TEXT_CHANGE, props);
		    }
		});

		setNativeView(moduleWrapper);
	}
	
	@Override
	public void processProperties(KrollDict options)
	{
		super.processProperties(options);
		
		textFieldBoxes.setLabelText("Hint text");
		textFieldBoxes.setEnabled(true);
		textFieldBoxes.setHasClearButton(false);
		textFieldBoxes.setHelperText("Helper Text");
		textFieldBoxes.setMaxCharacters(0);
		textFieldBoxes.setMinCharacters(0);
		textFieldBoxes.setHasClearButton(false);
		
		if (options.containsKey("theme")) {
			setTheme(options.getInt("theme"));
		} else {
			setTheme(TextfieldboxesModule.LIGHT_THEME);
		}
		
		if (options.containsKey("hintText")) {
			textFieldBoxes.setLabelText(options.getString("hintText"));
		}
		
		if(options.containsKey("counterTextColor")){
			textFieldBoxes.setCounterTextColor(Color.parseColor(options.getString("counterTextColor")));
		}
		
		if(options.containsKey("enabled")){
			textFieldBoxes.setEnabled(options.getBoolean("enabled"));
		}
		
		if(options.containsKey("errorColor")){
			textFieldBoxes.setErrorColor(Color.parseColor(options.getString("errorColor")));
		}
		
		if(options.containsKey("primaryColor")){
			textFieldBoxes.setPrimaryColor(Color.parseColor(options.getString("primaryColor")));
		}
		
		if(options.containsKey("secondaryColor")){
			textFieldBoxes.setSecondaryColor(Color.parseColor(options.getString("secondaryColor")));
		}
		
		if(options.containsKey("panelBackgroundColor")){
			textFieldBoxes.setPanelBackgroundColor(Color.parseColor(options.getString("panelBackgroundColor")));
		}
		
		if(options.containsKey("hasClearButton")){
			Log.d(LCAT, "If you set hasClearButton to true, Suffix and Prefix will be ignored");
			textFieldBoxes.setHasClearButton(options.getBoolean("hasClearButton"));
		}
		
		if(options.containsKey("helperText")){
			textFieldBoxes.setHelperText(options.getString("helperText"));
		}
		
		if(options.containsKey("maxCharacters")){
			textFieldBoxes.setMaxCharacters(options.getInt("maxCharacters"));
		}
		
		if(options.containsKey("minCharacters")){
			textFieldBoxes.setMinCharacters(options.getInt("minCharacters"));
		}
		
		if(options.containsKey("alwaysShowHint")){
			textFieldBoxes.setHasClearButton(options.getBoolean("alwaysShowHint"));
		}
		
		if(options.containsKey("suffixText")){
			extendedEditText.setSuffix(options.getString("suffixText"));
		}
		
		if(options.containsKey("suffixTextColor")){
			extendedEditText.setSuffixTextColor(Color.parseColor(options.getString("suffixTextColor")));
		}
		
		if(options.containsKey("prefixText")){
			extendedEditText.setPrefix(options.getString("prefixText"));
		} 
		
		if(options.containsKey("prefixTextColor")){
			extendedEditText.setPrefixTextColor(Color.parseColor(options.getString("prefixTextColor")));
		}
		
		if(options.containsKey("textColor")){
			extendedEditText.setTextColor(Color.parseColor(options.getString("textColor")));
		}
		
		if(options.containsKey("iconSignifier")){
			setIconSignifier(options.getString("iconSignifier"));
		}
		
		if(options.containsKey("endIcon")){
			setEndIcon(options.getString("endIcon"));
		}
		
		if(options.containsKey("isResponsiveIconColor")){
			textFieldBoxes.setIsResponsiveIconColor(options.getBoolean("isResponsiveIconColor"));
		}
	}
	
	public void setTheme(int theme){
		
		if (theme == TextfieldboxesModule.LIGHT_THEME) {
			
			textFieldBoxes.setCounterTextColor(Color.parseColor("#424242"));
			textFieldBoxes.setErrorColor(Color.parseColor("#f44336"));
			textFieldBoxes.setPrimaryColor(Color.parseColor("#673ab7"));
			textFieldBoxes.setSecondaryColor(Color.parseColor("#b39ddb"));
			textFieldBoxes.setPanelBackgroundColor(Color.parseColor("#e0e0e0"));
			extendedEditText.setSuffixTextColor(Color.parseColor("#757575"));
			extendedEditText.setPrefixTextColor(Color.parseColor("#757575"));
			extendedEditText.setTextColor(Color.parseColor("#212121"));
			
		} else if (theme == TextfieldboxesModule.DARK_THEME) {
			
			textFieldBoxes.setCounterTextColor(Color.parseColor("#BBBBBB"));
			textFieldBoxes.setErrorColor(Color.parseColor("#f44336"));
			textFieldBoxes.setPrimaryColor(Color.parseColor("#b39ddb"));
			textFieldBoxes.setSecondaryColor(Color.parseColor("#bdbdbd"));
			textFieldBoxes.setPanelBackgroundColor(Color.parseColor("#3b3b3b"));
			extendedEditText.setSuffixTextColor(Color.parseColor("#bdbdbd"));
			extendedEditText.setPrefixTextColor(Color.parseColor("#bdbdbd"));
			extendedEditText.setTextColor(Color.parseColor("#fafafa"));
			
		}
	}

	public void setIconSignifier(String iconSignifier) {
		int endIconId = appContext.getResources().getIdentifier(iconSignifier, "drawable", appContext.getPackageName());
		textFieldBoxes.setEndIcon(endIconId);
	}

	public void setEndIcon(String endIcon) {
		Log.d(LCAT, "If you set a endIcon, Suffix and Prefix will be ignored");
		int endIconId = appContext.getResources().getIdentifier(endIcon, "drawable", appContext.getPackageName());
		textFieldBoxes.setEndIcon(endIconId);
	}
}