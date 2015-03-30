package com.eb.ecshop;


import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.webkit.WebView;

public class MainWindow extends Activity {
	
	public static MainWindow instance = null;

	private ViewPager mTabPager;	
	private ImageView mTabImg;
	private ImageView mTab1,mTab2,mTab3,mTab4;
	private int zero = 0;
	private int currIndex = 0;
	private int one;
	private int two;
	private int three;
	private LinearLayout mClose;
    private LinearLayout mCloseBtn;
    private View layout;	
	private boolean menu_display = false;
	private PopupWindow menuWindow;
	private LayoutInflater inflater;


    private WebView topWebView;
    private WebView eventWebView;
    private WebView personWebView;
    private WebView shopWebView;
    private WebView categoryWebView;
    View view1;
    View view2;
    View view3;
    View view4;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_window);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN); 
        instance = this;
        
        mTabPager = (ViewPager)findViewById(R.id.tabpager);
        mTabPager.setOnPageChangeListener(new MyOnPageChangeListener());
        
        mTab1 = (ImageView) findViewById(R.id.img_weixin);
        mTab2 = (ImageView) findViewById(R.id.img_address);
        mTab3 = (ImageView) findViewById(R.id.img_friends);
        mTab4 = (ImageView) findViewById(R.id.img_settings);
        mTabImg = (ImageView) findViewById(R.id.img_tab_now);
        mTab1.setOnClickListener(new MyOnClickListener(0));
        mTab2.setOnClickListener(new MyOnClickListener(1));
        mTab3.setOnClickListener(new MyOnClickListener(2));
        mTab4.setOnClickListener(new MyOnClickListener(3));
        Display currDisplay = getWindowManager().getDefaultDisplay();
        int displayWidth = currDisplay.getWidth();
        int displayHeight = currDisplay.getHeight();
        one = displayWidth/4;
        two = one*2;
        three = one*3;

        
        //InitImageView();
        LayoutInflater mLi = LayoutInflater.from(this);
        view1 = mLi.inflate(R.layout.main_tab_top, null);
        view2 = mLi.inflate(R.layout.main_tab_event, null);
        view3 = mLi.inflate(R.layout.main_tab_person, null);
        view4 = mLi.inflate(R.layout.main_tab_shop, null);

        final ArrayList<View> views = new ArrayList<View>();
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);

        PagerAdapter mPagerAdapter = new PagerAdapter() {
			
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}
			
			@Override
			public int getCount() {
				return views.size();
			}

			@Override
			public void destroyItem(View container, int position, Object object) {
				((ViewPager)container).removeView(views.get(position));
			}

			//@Override
			//public CharSequence getPageTitle(int position) {
				//return titles.get(position);
			//}
			
			@Override
			public Object instantiateItem(View container, int position) {
				((ViewPager)container).addView(views.get(position));
				return views.get(position);
			}
		};



        topWebView = (WebView) view1.findViewById(R.id.topWebView);
        topWebView.getSettings().setJavaScriptEnabled(true);
        topWebView.getSettings().setUseWideViewPort(true);
        topWebView.getSettings().setLoadWithOverviewMode(true);
        topWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        topWebView.setWebViewClient(new WebViewClient());
        topWebView.loadUrl(getResources().getString(R.string.url_top));




        mTabPager.setAdapter(mPagerAdapter);
    }
    /**
	 *
	 */
	public class MyOnClickListener implements View.OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;
		}
		@Override
		public void onClick(View v) {
			mTabPager.setCurrentItem(index);
		}
	};
    
	 /*
	 */
	public class MyOnPageChangeListener implements OnPageChangeListener {
		@Override
		public void onPageSelected(int arg0) {
			Animation animation = null;
			switch (arg0) {
			case 0:
				mTab1.setImageDrawable(getResources().getDrawable(R.drawable.tab_top_pressed));
				if (currIndex == 1) {
					animation = new TranslateAnimation(one, 0, 0, 0);
					mTab2.setImageDrawable(getResources().getDrawable(R.drawable.tab_event_normal));
				} else if (currIndex == 2) {
					animation = new TranslateAnimation(two, 0, 0, 0);
					mTab3.setImageDrawable(getResources().getDrawable(R.drawable.tab_find_person_normal));
				}
				else if (currIndex == 3) {
					animation = new TranslateAnimation(three, 0, 0, 0);
					mTab4.setImageDrawable(getResources().getDrawable(R.drawable.tab_shop_normal));
				}

                topWebView = (WebView) view1.findViewById(R.id.topWebView);
                topWebView.getSettings().setJavaScriptEnabled(true);
                topWebView.getSettings().setUseWideViewPort(true);
                topWebView.getSettings().setLoadWithOverviewMode(true);
                topWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                topWebView.setWebViewClient(new WebViewClient());
                topWebView.loadUrl(getResources().getString(R.string.url_top));

				break;
			case 1:
				mTab2.setImageDrawable(getResources().getDrawable(R.drawable.tab_event_pressed));
				if (currIndex == 0) {
					animation = new TranslateAnimation(zero, one, 0, 0);
					mTab1.setImageDrawable(getResources().getDrawable(R.drawable.tab_top_normal));
				} else if (currIndex == 2) {
					animation = new TranslateAnimation(two, one, 0, 0);
					mTab3.setImageDrawable(getResources().getDrawable(R.drawable.tab_find_person_normal));
				}
				else if (currIndex == 3) {
					animation = new TranslateAnimation(three, one, 0, 0);
					mTab4.setImageDrawable(getResources().getDrawable(R.drawable.tab_shop_normal));
				}

                eventWebView = (WebView) view2.findViewById(R.id.eventWebView);
                eventWebView.getSettings().setJavaScriptEnabled(true);
                eventWebView.getSettings().setUseWideViewPort(true);
                eventWebView.getSettings().setLoadWithOverviewMode(true);
                eventWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                eventWebView.setWebViewClient(new WebViewClient());
                eventWebView.loadUrl(getResources().getString(R.string.url_event));

				break;
			case 2:
				mTab3.setImageDrawable(getResources().getDrawable(R.drawable.tab_find_person_pressed));
				if (currIndex == 0) {
					animation = new TranslateAnimation(zero, two, 0, 0);
					mTab1.setImageDrawable(getResources().getDrawable(R.drawable.tab_top_normal));
				} else if (currIndex == 1) {
					animation = new TranslateAnimation(one, two, 0, 0);
					mTab2.setImageDrawable(getResources().getDrawable(R.drawable.tab_event_normal));
				}
				else if (currIndex == 3) {
					animation = new TranslateAnimation(three, two, 0, 0);
					mTab4.setImageDrawable(getResources().getDrawable(R.drawable.tab_shop_normal));
				}

                personWebView = (WebView) view3.findViewById(R.id.personWebView);
                personWebView.getSettings().setJavaScriptEnabled(true);
                personWebView.getSettings().setUseWideViewPort(true);
                personWebView.getSettings().setLoadWithOverviewMode(true);
                personWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                personWebView.setWebViewClient(new WebViewClient());
                personWebView.loadUrl(getResources().getString(R.string.url_person));



				break;
			case 3:
				mTab4.setImageDrawable(getResources().getDrawable(R.drawable.tab_shop_pressed));
				if (currIndex == 0) {
					animation = new TranslateAnimation(zero, three, 0, 0);
					mTab1.setImageDrawable(getResources().getDrawable(R.drawable.tab_top_normal));
				} else if (currIndex == 1) {
					animation = new TranslateAnimation(one, three, 0, 0);
					mTab2.setImageDrawable(getResources().getDrawable(R.drawable.tab_event_normal));
				}
				else if (currIndex == 2) {
					animation = new TranslateAnimation(two, three, 0, 0);
					mTab3.setImageDrawable(getResources().getDrawable(R.drawable.tab_find_person_normal));
				}

                shopWebView = (WebView) view4.findViewById(R.id.shopWebView);
                shopWebView.getSettings().setJavaScriptEnabled(true);
                shopWebView.getSettings().setUseWideViewPort(true);
                shopWebView.getSettings().setLoadWithOverviewMode(true);
                shopWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                shopWebView.setWebViewClient(new WebViewClient());
                shopWebView.loadUrl(getResources().getString(R.string.url_shop));

				break;
			}
			currIndex = arg0;
			animation.setFillAfter(true);
			animation.setDuration(150);
			mTabImg.startAnimation(animation);
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}
	
	@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
    		
        	if(menu_display){
        		menuWindow.dismiss();
        		menu_display = false;
        		}
        	else {
        		Intent intent = new Intent();
            	intent.setClass(MainWindow.this,Exit.class);
            	startActivity(intent);
        	}
    	}
    	
    	else if(keyCode == KeyEvent.KEYCODE_MENU){
			if(!menu_display){
				inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
				layout = inflater.inflate(R.layout.main_menu, null);
				menuWindow = new PopupWindow(layout,LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
				menuWindow.showAtLocation(this.findViewById(R.id.mainWindow), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
				mClose = (LinearLayout)layout.findViewById(R.id.menu_close);
				mCloseBtn = (LinearLayout)layout.findViewById(R.id.menu_close_btn);
				

				mCloseBtn.setOnClickListener (new View.OnClickListener() {					
					@Override
					public void onClick(View arg0) {
						Intent intent = new Intent();
			        	intent.setClass(MainWindow.this,Exit.class);
			        	startActivity(intent);
			        	menuWindow.dismiss();
					}
				});				
				menu_display = true;				
			}else{
				menuWindow.dismiss();
				menu_display = false;
				}
			
			return false;
		}
    	return false;
    }

	public void btnmainright(View v) {  
		Intent intent = new Intent (MainWindow.this,MainTopRightDialog.class);
		startActivity(intent);
     }

    public void scanView(View v) {
        Intent intent = new Intent (MainWindow.this,Scan.class);
        startActivity(intent);
    }

}
    
    

