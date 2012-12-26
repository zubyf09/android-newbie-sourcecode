package pete.apps.study.droid05;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewPagerAdapter extends PagerAdapter {
	
	private static String[] titles = new String[] {
		"Girl",
		"Dog",
		"Cat"
	};	

	private static int[] images = new int[] {
		R.drawable.girl,
		R.drawable.dog,
		R.drawable.cat
	};

	private final Context context;

	public ViewPagerAdapter(Context context) {
		this.context = context;
	}

	@Override
	public String getPageTitle(int position) {
		return titles[position];
	}

	@Override 
	public int getCount() {
		return titles.length;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		ImageView view = new ImageView(this.context);
		view.setImageResource(images[position]);
		((ViewPager) container).addView(view, 0);
		return view;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView((ImageView) object);
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view.equals(object);
	}

}
