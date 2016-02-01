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

        LinearLayout layoutButtons = (LinearLayout) layout.getChildAt(4);
        layoutButtons.setVisibility(VISIBLE);
        handleCardViewNormalButton(layoutButtons, 0);
        handleCardViewHighlightButton(layoutButtons, 1);
    }

    private void handleCardViewHighlightButton(ViewGroup layout, int position) {
        mHighlightButton = (Button) layout.getChildAt(position);
        if (!TextUtils.isEmpty(mHighlightButtonText)) {
            mHighlightButton.setText(mHighlightButtonText);
            mHighlightButton.setVisibility(VISIBLE);
            mHighlightButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnHighlightButtonClickListener != null) {
                        mOnHighlightButtonClickListener.onClick(view);
                    }
                }

            });
        } else{
            mHighlightButton.setVisibility(GONE);
        }
    }

    private void handleCardViewNormalButton(ViewGroup layout, int position) {
        mNormalButton = (Button) layout.getChildAt(position);
        if (!TextUtils.isEmpty(mNormalButtonText)) {
            mNormalButton.setText(mNormalButtonText);
            mNormalButton.setVisibility(VISIBLE);
            mNormalButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnNormalButtonClickListener != null) {
                        mOnNormalButtonClickListener.onClick(view);
                    }
                }
            });
        } else{
            mNormalButton.setVisibility(GONE);
        }
    }

    private void handleDescription(ViewGroup layout, int position) {
        TextView description = (TextView) layout.getChildAt(position);
        if (!TextUtils.isEmpty(mDescriptionText)) {
            description.setText(mDescriptionText);
            description.setVisibility(VISIBLE);
        } else description.setVisibility(GONE);
    }

    private void handleTitle(ViewGroup layout, int position) {
        TextView title = (TextView) layout.getChildAt(position);
        if (!TextUtils.isEmpty(mTitleText)) {
            title.setText(mTitleText);
            title.setVisibility(VISIBLE);
        } else title.setVisibility(GONE);
    }

    private void handleImage(ViewGroup layout, int position) {
        ImageView imageView = (ImageView) layout.getChildAt(position);
        if(mImage != null)
            imageView.setImageDrawable(mImage);
    }

    private void handleSpacing(ViewGroup layout, int position) {
        View spacingView = layout.getChildAt(position);
        int spacingViewHeight = 0;
        if(!TextUtils.isEmpty(mTitleText)&&
                TextUtils.isEmpty(mDescriptionText)&&
                TextUtils.isEmpty(mNormalButtonText)&&
                TextUtils.isEmpty(mHighlightButtonText)){
            spacingViewHeight = 6;
        }else if(!TextUtils.isEmpty(mTitleText) &&
                TextUtils.isEmpty(mDescriptionText)&&
                (!TextUtils.isEmpty(mNormalButtonText) || !TextUtils.isEmpty(mHighlightButtonText))){
            spacingViewHeight = 10;
        }else if(TextUtils.isEmpty(mTitleText) &&
                TextUtils.isEmpty(mDescriptionText) &&
                TextUtils.isEmpty(mNormalButtonText) &&
                TextUtils.isEmpty(mHighlightButtonText)){
            spacingViewHeight = 2;
        }else if(!TextUtils.isEmpty(mDescriptionText) &&
                (!TextUtils.isEmpty(mNormalButtonText) || !TextUtils.isEmpty(mHighlightButtonText))){
            spacingViewHeight = 4;
        }

        int spacingViewHeightPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, spacingViewHeight, getResources().getDisplayMetrics());
        spacingView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, spacingViewHeightPx));
    }

}
