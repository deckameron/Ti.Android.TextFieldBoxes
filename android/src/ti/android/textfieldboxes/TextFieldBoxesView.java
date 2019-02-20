
package ti.android.textfieldboxes;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

import studio.carbonylgroup.textfieldboxes.ExtendedEditText;
import studio.carbonylgroup.textfieldboxes.TextFieldBoxes;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class TextFieldBoxesView extends TiUIView {
	
	private static final String LCAT = "TextFieldBoxesView";

	public TextFieldBoxesView(TiViewProxy proxy) {
		
		super(proxy);
		
		Context appContext = proxy.getActivity();
		
		final TextFieldBoxes textFieldBoxes = new TextFieldBoxes(appContext);
		
		textFieldBoxes.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		textFieldBoxes.setLabelText("Hint Text");
		textFieldBoxes.setEnabled(true);
		textFieldBoxes.setHelperText("Helper is here");
		textFieldBoxes.setMaxCharacters(10);
		textFieldBoxes.setMinCharacters(3);
		
		ExtendedEditText extendedEditText = new ExtendedEditText(appContext);
		extendedEditText.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		extendedEditText.setPrefix("$ ");
		
		textFieldBoxes.addView(extendedEditText);
		
		textFieldBoxes.getEndIconImageButton().setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View view) {
		        // What you want to do when it's clicked
		    	Log.d(LCAT, "onClick");
		    }
		});
		
		setNativeView( (View) textFieldBoxes);
	}
	
	@Override
	public void processProperties(KrollDict d)
	{
		super.processProperties(d);
		
		if (d.containsKey("message")) {
			Log.d(LCAT, "example created with message: " + d.get("message"));
		}
	}
}