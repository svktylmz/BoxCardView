package tr.com.hacktusdynamics.android.boxcardview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()));
        setPreventCornerOverlap(false);
        setCardBackgroundColor(context.getResources().getColor(R.color.box_cardview_background));

        inflate();
    }

    private void inflate() {
        removeAllViews();
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.box_card_view, this, true);

        refresh();
    }

    private void refresh() {
        LinearLayout layoutAll = (LinearLayout) getChildAt(0);
        handleImage(layoutAll, 0);

        LinearLayout layout = (LinearLayout) layoutAll.getChildAt(1);
        handleTitle(layout, 0);
        handleDescription(layout, 1);
        handleSpacing(layout, 2);
        handleCardViewNormalButtons(layout, 3);
    }

}
