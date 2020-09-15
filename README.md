# HorizontalPileLayout
一个横向滑动层叠布局，左滑可以一个个层叠起来，右滑一个个平铺开显示，效果图如下
# ![效果图](https://github.com/DalesDawson/HorizontalPileLayout/blob/master/app/src/main/imgs/f403c1fcf25556830e62ff53aa182184.gif)
## 使用方法：
1.添加依赖
```
 implementation 'com.github.DalesDawson:HorizontalPileLayout:1.0.2'
```
2.在布局文件xml中使用
```
<com.daledawson.pilelayout.HorizontalPileLayout
        android:id="@+id/pileLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:paddingTop="5dp"
        android:paddingBottom="5dp"
        pile:displayCount="1.8"
        pile:interval="10dp"
        pile:scaleStep="0.32"
        pile:sizeRatio="1.12" />
```
参数说明

|变量名|类型|描述|
|---|---|---|
|displayCount|float|需要显示出的个数(可以是小数)|
|interval|dimension|每一个item之间的间隔|
|scaleStep|float|相对于原本放大的倍数(0.3就是放大到原本的1.3倍)|
|sizeRatio|float|高宽比(可以使用高除以宽得出)|

3.在代码中设置adapter
```
 pileLayout.setAdapter(adapter);
 HorizontalPileLayout.Adapter adapter = new HorizontalPileLayout.Adapter() {
        @Override
        public int getLayoutId() {
            return R.layout.item_layout;
        }

        @Override
        public void bindView(View view, int position) {
            ViewHolder viewHolder = (ViewHolder) view.getTag();
            if (viewHolder == null) {
                viewHolder = new ViewHolder();
                viewHolder.imageView = (RoundedImageView) view.findViewById(R.id.imageView);
                view.setTag(viewHolder);
            }
            Picasso.get().load(dataList.get(position)).into(viewHolder.imageView);
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        @Override
        public void displaying(int position) {

        }

        @Override
        public void onItemClick(View view, int position) {
            super.onItemClick(view, position);
        }
    };

    class ViewHolder {
        RoundedImageView imageView;
    }
```
Demo apk

[下载地址](https://github.com/DalesDawson/HorizontalPileLayout/blob/master/app/release/app-release.apk)

## 感谢及参考
[PileLayout]()
