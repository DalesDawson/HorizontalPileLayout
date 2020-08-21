package com.widget.horizontalpilelayout.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.daledawson.pilelayout.HorizontalPileLayout;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;
import com.widget.horizontalpilelayout.R;
import com.widget.horizontalpilelayout.entity.ItemEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 创 建 人：zhengquan
 * 创建日期：2020/8/21
 * 修改时间：
 * 修改备注：
 */
public class TestActivity extends AppCompatActivity {
    private HorizontalPileLayout pileLayout;
    private List<String> dataList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        pileLayout = findViewById(R.id.pileLayout);
        initData();
        pileLayout.setAdapter(adapter);
    }

    private void initData() {
        dataList.add("http://img.hb.aicdn.com/10dd7b6eb9ca02a55e915a068924058e72f7b3353a40d-ZkO3ko_fw658");
        dataList.add("http://img.hb.aicdn.com/a3a995b26bd7d58ccc164eafc6ab902601984728a3101-S2H0lQ_fw658");
        dataList.add("http://pic4.nipic.com/20091124/3789537_153149003980_2.jpg");
        dataList.add("http://img.hb.aicdn.com/4ba573e93c6fe178db6730ba05f0176466056dbe14905-ly0Z43_fw658");
        dataList.add("http://img.hb.aicdn.com/4bc60d00aa3184f1f98e418df6fb6abc447dc814226ef-ZtS8hB_fw658");
        dataList.add("http://img.hb.aicdn.com/d9a48c272914c5253eceac26c51a56a26f4e50d048ba7-IJsbou_fw658");
        dataList.add("http://img.hb.aicdn.com/03d474bbe20efb7df9aed4541ace70b53b53c70bdfe3-8djYVv_fw658");
        dataList.add("http://img.hb.aicdn.com/004cddd40519846281526b4b25fbdea36b31d01e190dd-7zlmuG_fw658");
        dataList.add("http://img.hb.aicdn.com/a58eda8a9a2a3f30f0a694c2702e1aba71d97d616d34f-rqv6FA_fw658");
        dataList.add("http://img.hb.aicdn.com/41ff5110b4ecdec24e14f767e83c1659c2e8a180f3df-QqUAgk_fw658");
    }

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
}