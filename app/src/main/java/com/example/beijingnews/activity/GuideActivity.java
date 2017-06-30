package com.example.beijingnews.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.beijingnews.R;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends Activity {
    private ViewPager viewPager;
    private Button btn_start_main;
    private LinearLayout ll_point_group;
    private ImageView redPoint;

    private List<ImageView> imageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        btn_start_main = (Button) findViewById(R.id.btn_start_main);
        ll_point_group = (LinearLayout) findViewById(R.id.ll_point_group);
        redPoint = (ImageView) findViewById(R.id.red_point);

        int[] ids = new int[]{
                R.drawable.guide1,
                R.drawable.guide2,
                R.drawable.guide3
        };
        imageViews = new ArrayList<>();
        for(int i = 0 ; i < ids.length ; i++){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(ids[i]);
            imageViews.add(imageView);
            //创建点
            ImageView normalPoint = new ImageView(this);
            normalPoint.setBackgroundResource(R.drawable.normal_point);
            /**
             * 显示像素
             */
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10,10);
            if(i != 0){
                //不包括第0个点,剩下的都相对于左边有10个像素的距离
                params.leftMargin = 10;
            }
            normalPoint.setLayoutParams(params);
            //将点添加到布局里
            ll_point_group.addView(normalPoint);
        }


        viewPager.setAdapter(new MyPagerAdapter());
    }

    class MyPagerAdapter extends PagerAdapter{
        /**
         * 返回数据的总个数
         * @return
         */
        @Override
        public int getCount() {
            return imageViews.size();
        }

        /**
         * 作用 相当于listview的适配器中的getView
         * @param container viewPager
         * @param position 要创建页面的位置
         * @return 返回与当前页面有关系的值
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = imageViews.get(position);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == (View) object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            container.removeView((View) object);
        }

    }
}
