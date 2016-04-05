package com.example.chenliguan.util;

/**
 * Created by chenliguan on 16/4/5.
 *
 */
public interface MultiItemTypeSupport<T>
{
	int getLayoutId(int position, T t);

	int getItemViewType(int postion, T t);

	int getViewTypeCount();
}