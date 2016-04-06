package com.example.chenliguan.adapter;

import android.content.Context;
import android.view.View;

import com.example.chenliguan.activity.R;
import com.example.chenliguan.bean.ChatMessage;
import com.example.chenliguan.util.MultiItemCommonAdapter;
import com.example.chenliguan.util.MultiItemTypeSupport;
import com.example.chenliguan.util.ViewHolder;

import java.util.List;

/**
 * 多项ListView适配器
 * Created by chenliguan on 16/4/5.
 */
public class MultiItemAdapter extends MultiItemCommonAdapter<ChatMessage> {

    private static final int TYPE_NORMAL_ITEM = 0;
    private static final int TYPE_NUM_ITEM = 1;
    private static final int TYPE_COUNT = 2;

    private View.OnClickListener onClickListener;

    /**
     * 普通的样式
     */
    public MultiItemAdapter(Context context, final List<ChatMessage> datas, View.OnClickListener onClickListener) {
        super(context, datas, new MultiItemTypeSupport<ChatMessage>() {
            @Override
            public int getLayoutId(int position, ChatMessage msg) {
                if (msg.isComMeg()) {
                    return R.layout.main_chat_from_msg;
                }
                return R.layout.main_chat_send_msg;
            }

            @Override
            public int getItemViewType(int position, ChatMessage msg) {
//                if (position < datas.size()) {
                if (msg.isComMeg()) {
                    return TYPE_NORMAL_ITEM;
                }
                return TYPE_NUM_ITEM;
            }

            @Override
            public int getViewTypeCount() {
                return TYPE_COUNT;
            }
        });

        this.onClickListener = onClickListener;
    }

    /**
     * 聊天的样式
     */
//    public MultiItemAdapter(Context context, List<ChatMessage> datas) {
//        super(context, datas, new MultiItemTypeSupport<ChatMessage>() {
//            @Override
//            public int getLayoutId(int position, ChatMessage msg) {
//                if (msg.isComMeg()) {
//                    return R.layout.main_chat_from_msg;
//                }
//                return R.layout.main_chat_send_msg;
//            }
//
//            @Override
//            public int getItemViewType(int postion, ChatMessage msg) {
//                if (msg.isComMeg()) {
//                    return ChatMessage.RECIEVE_MSG;
//                }
//                return ChatMessage.SEND_MSG;
//            }
//
//            @Override
//            public int getViewTypeCount() {
//                return 2;
//            }
//        });
//    }
    @Override
    public void convert(final ViewHolder holder, ChatMessage chatMessage) {

        switch (holder.getLayoutId()) {
            case R.layout.main_chat_from_msg:
                holder.setText(R.id.chat_from_content, chatMessage.getContent());
                holder.setText(R.id.chat_from_name, chatMessage.getName());
                holder.setImageResource(R.id.chat_from_icon, chatMessage.getIcon());
                //设置监听的位置Tag
                holder.setTag(R.id.chat_from_icon, holder.getPosition());
                holder.setOnClickListener(R.id.chat_from_icon, onClickListener);
                break;

            case R.layout.main_chat_send_msg:
                holder.setText(R.id.chat_send_content, chatMessage.getContent());
                holder.setText(R.id.chat_send_name, chatMessage.getName());
                holder.setImageResource(R.id.chat_send_icon, chatMessage.getIcon());
                //设置监听的位置Tag
                holder.setTag(R.id.chat_send_icon, holder.getPosition());
                holder.setOnClickListener(R.id.chat_send_icon, onClickListener);
                break;

            default:
                break;
        }
    }
}
