package www.ycode.xiaowu.com.starbarview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import www.ycode.xiaowu.com.starbarview.statusColor.StatusBarCompat;
import www.ycode.xiaowu.com.starbarview.utils.QMUIStatusBarHelper;

/**
 * Created by wupenghui
 * data: 2017/11/28.
 * qq:415551493
 * des:
 */

public class StatusBarColorActivity extends AppCompatActivity {
    @BindView(R.id.white)
    TextView white;
    @BindView(R.id.black)
    TextView black;
    @BindView(R.id.green)
    TextView green;
    @BindView(R.id.red)
    TextView red;
    @BindView(R.id.blue)
    TextView blue;
    @BindView(R.id.orange)
    TextView orange;
    @BindView(R.id.style1)
    TextView style1;
    @BindView(R.id.style2)
    TextView style2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QMUIStatusBarHelper.translucent(this); // 沉浸式状态栏
        setContentView(R.layout.activity_status_bar_color);
        ButterKnife.bind(this);
    }
    @Nullable
    @OnClick({R.id.white, R.id.black, R.id.green, R.id.red, R.id.blue, R.id.orange,R.id.style1,R.id.style2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.white:
                StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.white), true);//true，状态栏栏上文字的颜色为黑色
                break;
            case R.id.black:
                StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.black), false);//false，状态栏上的文字的颜色为白色
                break;
            case R.id.green:
                StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.green), true);
                break;
            case R.id.red:
                StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.red), true);
                break;
            case R.id.blue:
                StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.blue), true);
                break;
            case R.id.orange:
                StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.orange), true);
                break;
            case R.id.style1:
                QMUIStatusBarHelper.setStatusBarLightMode(this);
                break;
            case R.id.style2:
                QMUIStatusBarHelper.setStatusBarDarkMode(this);
                break;
        }
    }
}
