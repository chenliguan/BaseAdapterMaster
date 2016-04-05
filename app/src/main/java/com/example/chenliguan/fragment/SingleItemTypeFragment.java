package com.example.chenliguan.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.Toast;

import com.example.chenliguan.adapter.SingleItemAdapter;
import com.example.chenliguan.bean.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 单项Fragment
 * Created by chenliguan on 16/4/5.
 */
public class SingleItemTypeFragment extends ListFragment {

    private List<Bean> mDatas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDatas();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //设置适配器
        setListAdapter(new SingleItemAdapter(getActivity(), mDatas, onClickListener));
    }

    /**
     * 监听
     */
    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            int position = Integer.parseInt(view.getTag().toString());
            Toast.makeText(getActivity(), "title:" + mDatas.get(position).getTitle(), Toast.LENGTH_SHORT).show();
        }
    };

    /**
     * 初始化数据
     */
    private void initDatas() {
        mDatas = new ArrayList<>();
        Bean bean = new Bean("Android新技能Get 1",
                "Android打造万能的ListView和GridView适配器", "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 2", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 3", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 4", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 5", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 6", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 7", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 8", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 9", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
    }
}
