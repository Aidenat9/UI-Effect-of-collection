package com.github.tianmu19.rolllayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ViewFlipper;

/**
 * @author sunwei
 * 邮箱：tianmu19@gmail.com
 * 时间：2019/2/21 9:42
 * 包名：com.github.tianmu19.rolllayout
 * <p>description:            </p>
 */
public class RollTitleLayout extends FrameLayout {

    private ViewFlipper viewFlipper;

    public RollTitleLayout(@NonNull Context context) {
        super(context);
        initView(context);
    }


    public RollTitleLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public RollTitleLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        viewFlipper = new ViewFlipper(context);
        LayoutParams params = generateDefaultLayoutParams();
        viewFlipper.setLayoutParams(params);
        addView(viewFlipper);
    }

    public RollTitleLayout addViews(View... child) {
        if (child == null) {
            throw new IllegalArgumentException("Cannot add a null child view to a ViewGroup");
        }
        for (View v :
                child) {
            viewFlipper.addView(v);
        }
        viewFlipper.setAutoStart(false);
        return this;
    }

    public void showPrevious() {
        viewFlipper.setInAnimation(this.getContext(), R.anim.flipper_bottom_in);
        viewFlipper.setOutAnimation(this.getContext(), R.anim.flipper_bottom_out);
        viewFlipper.showPrevious();
    }

    public void showNext() {
        viewFlipper.setInAnimation(this.getContext(), R.anim.flipper_top_in);
        viewFlipper.setOutAnimation(this.getContext(), R.anim.flipper_top_out);
        viewFlipper.showNext();
    }


}
