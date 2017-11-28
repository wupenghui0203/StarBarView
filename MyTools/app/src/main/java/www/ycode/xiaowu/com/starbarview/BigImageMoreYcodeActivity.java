package www.ycode.xiaowu.com.starbarview;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import www.ycode.xiaowu.com.starbarview.lookbigimage.PicPagerYcodeAdapter;


/**
 * 项目名称：MeijuApp
 * Created by Dr. Zhu on 2017/7/30.
 */

public class BigImageMoreYcodeActivity extends AppCompatActivity {
	@BindView(R.id.back)
	ImageView back;
	@BindView(R.id.starts)
	ImageView starts;
	@BindView(R.id.share)
	ImageView share;
	@BindView(R.id.pager)
	ViewPager pager;
	@BindView(R.id.icon)
	ImageView icon;
	@BindView(R.id.buttom)
	RelativeLayout buttom;
	@BindView(R.id.num)
	TextView num;
	@BindView(R.id.img_head)
	RelativeLayout imgHead;
	@BindView(R.id.rl_title)
	RelativeLayout rlTitle;
	@BindView(R.id.touch_bg)
	RelativeLayout touchBg;
	@BindView(R.id.tv_title)
	TextView title;

	private EdgeEffectCompat leftEdge;
	private EdgeEffectCompat rightEdge;
	private boolean isLastPage = false;
	private boolean isDragPage = false;
	private boolean canJumpPage = true;
	private boolean showflag = true;
	private  int index=0;
	private int i=0;
	private int sumpic=0;
	private ArrayList<String> data;
	private PicPagerYcodeAdapter picPagerAdapter;
	private boolean flag=false;
	private boolean isScrolled;
	private boolean isstars=true;

	private void showPic(ArrayList<String> data) {
		num.setText(1+index+"/"+(data.size())+"");
		picPagerAdapter=new PicPagerYcodeAdapter(BigImageMoreYcodeActivity.this,data);
			/*		pager.setCurrentItem(20);*/
		pager.setAdapter(picPagerAdapter);
		pager.setCurrentItem(index);
		picPagerAdapter.setOnSingleCLickLister(new PicPagerYcodeAdapter.OnSingleCLickLister() {
			@Override
			public void onSingleClick() {
				finish();
			}
		});
	}



	@OnClick({R.id.touch_bg,R.id.back,R.id.starts,R.id.share})
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.back:
				finish();
				break;
			case R.id.touch_bg:
				if(showflag){
					imgHead.setVisibility(View.INVISIBLE);
					showflag=false;
				}else {
					imgHead.setVisibility(View.VISIBLE);
					showflag=true;
				}

				break;
			case R.id.starts:
					break;
		}

	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.big_imgmore_activity_ycode);
		getSupportActionBar().hide();//(如果是继承自AppCompatActivity，去掉标题栏需要这一行)
		ButterKnife.bind(this);
		buttom.setVisibility(View.GONE);
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		if(bundle!=null&&bundle.containsKey("piclist")){
			data = bundle.getStringArrayList("piclist");
			index=bundle.getInt("postion");
		}
		data = bundle.getStringArrayList("piclist");
		index=bundle.getInt("postion");
		pager.setPageMargin((int) (getResources().getDisplayMetrics().density * 15));
		showPic(data);
		pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				//	num.setText(position+1+""+"/"+(p1.getData().getContent().size())+"");
				//if (isLastPage && isDragPage&& positionOffsetPixels == 0){   //当前页是最后一页，并且是拖动状态，并且像素偏移量为0
				if(isLastPage &&rightEdge!=null&&!rightEdge.isFinished()&& positionOffsetPixels == 0){
				}
			}

			@Override
			public void onPageSelected(int position) {
				num.setText(1+position+""+"/"+(data.size())+"");
				//	num.setText(position+1+""+"/"+(data.getList().size())+"");
				isLastPage = position ==sumpic-1;
			}

			@Override
			public void onPageScrollStateChanged(int state) {
				switch (state) {
					case ViewPager.SCROLL_STATE_DRAGGING:
						isScrolled = false;
						break;
					case ViewPager.SCROLL_STATE_SETTLING:
						isScrolled = true;
						break;
					case ViewPager.SCROLL_STATE_IDLE:
						if (pager.getCurrentItem() == pager.getAdapter().getCount() - 1 && !isScrolled) {
							if(index<data.size()-1){
								index++;
								//getPicDetails(data.get(index));
							}else {
								//ToastUtil.showToast("已经到底啦");
							}
						}
						if(pager.getCurrentItem() ==0 && !isScrolled){
							/*ToastUtil.showToast("fuckthis");*/
							/*if(index<data.getList().size()&&index>0){
								index--;
								getPicDetails(data.getList().get(index).getPicture_id());

							}else {
								ToastUtil.showToast("已经到头啦");
							}*/
						}
						isScrolled = true;
						break;
				}
			}
		});
		pager.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
