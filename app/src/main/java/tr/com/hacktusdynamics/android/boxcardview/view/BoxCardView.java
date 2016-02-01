package tr.com.hacktusdynamics.android.boxcardview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.Button;

import tr.com.hacktusdynamics.android.boxcardview.R;

public class BoxCardView extends CardView{

    // Variables
    private Drawable mImage;
    private String mTitleText;
    private String mDescriptionText;
    private String mNormalButtonText;
    private String mHighlightButtonText;
    private Button mNormalButton;
    private Button mHighlightButton;

    // Listeners
    private OnClickListener mOnNormalButtonClickListener;
    private OnClickListener mOnHighlightButtonClickListener;

    public BoxCardView(Context context) {
        this(context, null);
    }

    public BoxCardView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.BoxCardViewSTYLEABLE, 0, 0);

        try {
            mImage = a.getDrawable(R.styleable.BoxCardViewSTYLEABLE_box_image);
            mTitleText = a.getString(R.styleable.BoxCardViewSTYLEABLE_box_title);
            mDescriptionText = a.getString(R.styleable.BoxCardViewSTYLEABLE_box_description);
            mNormalButtonText = a.getString(R.styleable.BoxCardViewSTYLEABLE_box_normalButton_text);
            mHighlightButtonText = a.getString(R.styleable.BoxCardViewSTYLEABLE_box_highlightButton_text);
        }finally {
            a.recycle();
        }


    }
}
