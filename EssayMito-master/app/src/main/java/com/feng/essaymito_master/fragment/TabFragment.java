package com.feng.essaymito_master.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.feng.essaymito_master.R;

/**
 * author：feng
 * createTime: 2015/12/3
 */
public class TabFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    RecyclerView recyclerView;
    SwipeRefreshLayout refreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void initView() {
        mContext = getActivity();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RcyclerViewAdapter adapter = new RcyclerViewAdapter();
        recyclerView.setAdapter(adapter);

        initRefreshLayout();
    }

    @Override
    protected void findViewById() {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srLayout);
    }

    private void initRefreshLayout() {
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeColors(Color.GRAY);
        refreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
        refreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        refreshLayout.setDistanceToTriggerSync(50);
    }

    @Override
    protected int getContentView() {
        return R.layout.fra_main_content;
    }

    @Override
    public void onRefresh() {
        handler.sendEmptyMessageDelayed(0, 1500);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                refreshLayout.setRefreshing(false);
                displaySToast(getActivity(), "无新消息");
            }
        }
    };

    @Override
    public void onClick(View v) {

    }

    class RcyclerViewAdapter extends RecyclerView.Adapter<RcyclerViewAdapter.Holder> {

        @Override
        public int getItemCount() {
            return 20;
        }

        @Override
        public void onBindViewHolder(Holder holder, final int position) {
            holder.imageView.setImageResource(R.mipmap.img1);
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(getActivity()).inflate(R.layout.item_fra_main_content, null));
        }

        class Holder extends RecyclerView.ViewHolder {
            ImageView imageView;

            public Holder(View itemView) {
                super(itemView);
                imageView = (ImageView) itemView.findViewById(R.id.myiamge);
            }
        }

    }
}
