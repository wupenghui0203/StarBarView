package www.ycode.xiaowu.com.starbarview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wupenghui
 * data: 2017/11/28.
 * qq:415551493
 * des:
 */

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView StarBarView,StatusBarColor,LookBigImage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        StarBarView = (TextView) findViewById(R.id.star_bar_view);
        StarBarView.setOnClickListener(this);
        StatusBarColor = (TextView) findViewById(R.id.status_bar_colors);
        StatusBarColor.setOnClickListener(this);
        LookBigImage = (TextView) findViewById(R.id.look_big_image);
        LookBigImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.star_bar_view:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.status_bar_colors:
                startActivity(new Intent(this,StatusBarColorActivity.class));
                break;
            case R.id.look_big_image:
                ArrayList<String> license_image = new ArrayList<String>();
                    license_image.add("http://a.hiphotos.baidu.com/image/pic/item/adaf2edda3cc7cd9fdf5fea23301213fb90e91f5.jpg");
                    license_image.add("http://f.hiphotos.baidu.com/image/pic/item/902397dda144ad34ec061d4dd9a20cf430ad85bb.jpg");
                    license_image.add("http://f.hiphotos.baidu.com/image/pic/item/4bed2e738bd4b31c521895718ed6277f9f2ff8d0.jpg");
                    license_image.add("http://h.hiphotos.baidu.com/image/pic/item/35a85edf8db1cb13a657aed9d454564e92584b3a.jpg");
                    Intent intents = new Intent(this, BigImageMoreYcodeActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("postion", 2);
                    bundle.putStringArrayList("piclist", license_image);
                    intents.putExtras(bundle);
                    startActivity(intents);
                break;
        }
    }
}
