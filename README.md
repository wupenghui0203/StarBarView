# StarBarView
## 显示星星评论数控件
```
<www.ycode.xiaowu.com.starbarview.StarBarView
        android:layout_marginLeft="22dp"
        android:layout_marginTop="22dp"
        android:id="@+id/rating_bar2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
		<!--设置星星间的间隔-->
        app:space_width="1dp"
		   <!--星星间高度-->
        app:star_height="24dp"
		 <!--未选中图片-->
        app:star_hollow="@mipmap/rb_gray"
		 <!--是否可以滑动改变选中数量-->
       app:star_isIndicator="false"
		  <!--最大数量-->
        app:star_max="5"
		<!--排列方向-->
        app:star_orientation="horizontal"
		  <!--选中数量-->
        app:star_rating="3"
		 <!--选中图片-->
        app:star_solid="@mipmap/rb_yellow"
		  <!--星星间宽度-->
        app:star_width="24dp"></www.ycode.xiaowu.com.starbarview.StarBarView>
```