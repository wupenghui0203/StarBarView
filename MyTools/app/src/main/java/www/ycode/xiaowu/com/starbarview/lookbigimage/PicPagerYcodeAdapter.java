package www.ycode.xiaowu.com.starbarview.lookbigimage;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * 项目名称：MeijuApp
 * Created by Dr. Zhu on 2017/8/7.
 */

public class PicPagerYcodeAdapter extends PagerAdapter {
	private Context mcontext;
	private LayoutInflater mlayoutInflater;
	private int mflag;
	private ArrayList<String>  mdata;
	public PicPagerYcodeAdapter(Context context, ArrayList<String>  data) {
		this.mcontext = context;
		this.mdata = data;
		mlayoutInflater = LayoutInflater.from(mcontext);
	}
	@Override
	public int getCount() {
		return mdata.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		PhotoView view = new PhotoView(mcontext);
		view.enable();
		view.setScaleType(ImageView.ScaleType.FIT_CENTER);
		Glide.with(mcontext).load(mdata.get(position)).into(view);
		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(onSingleCLickLister!=null){
					onSingleCLickLister.onSingleClick();
				}
			}
		});
		container.addView(view);
		return view;
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}
	public interface OnSingleCLickLister{
		void onSingleClick();
	}
	private OnSingleCLickLister onSingleCLickLister;
	public void setOnSingleCLickLister(OnSingleCLickLister onSingleCLickLister){
		this.onSingleCLickLister =onSingleCLickLister;
	}
}
