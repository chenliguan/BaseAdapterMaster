package com.example.chenliguan.adapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;

import com.example.chenliguan.activity.R;
import com.example.chenliguan.bean.Bean;
import com.example.chenliguan.util.CommonAdapter;
import com.example.chenliguan.util.ViewHolder;

import java.util.List;

/**
 * 单项ListView适配器
 * Created by chenliguan on 16/4/5.
 */
public class SingleItemAdapter extends CommonAdapter<Bean> {

    private View.OnClickListener onClickListener;

    public SingleItemAdapter(Context context, List datas, View.OnClickListener onClickListener) {
        super(context, datas, R.layout.item_single_listview);
        this.onClickListener = onClickListener;
    }

    @Override
    public void convert(ViewHolder holder, final Bean bean) {
        holder.setText(R.id.id_title, bean.getTitle())
                .setText(R.id.id_desc, bean.getDesc())
                .setText(R.id.id_time, bean.getTime())
                .setText(R.id.id_phone, bean.getPhone());

        //设置监听的位置Tag
        holder.setTag(R.id.id_title, holder.getPosition());
        holder.setOnClickListener(R.id.id_title, onClickListener);
        //处理ListView复用内容错乱问题
        final CheckBox cb = holder.getView(R.id.id_check);
        cb.setChecked(bean.isChecked());
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bean.setChecked(cb.isChecked());
            }
        });
    }
}
