package com.test.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.myapplication.R;
import com.test.myapplication.objects.Topic;

import java.util.List;

public class TopicAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Topic> topics;

    public TopicAdapter(Context context, int layout, List<Topic> topics) {
        this.context = context;
        this.layout = layout;
        this.topics = topics;
    }

    @Override
    public int getCount() {
        return topics.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = LayoutInflater.from(context).inflate(R.layout.rowlistview, parent, false);
        TextView tvName = convertView.findViewById(R.id.tvLession);
        TextView tvText = convertView.findViewById(R.id.tvTittle);
        ImageView tvAvatar =convertView.findViewById(R.id.tvAvatar);
        Topic topic = topics.get(position);
        tvName.setText(topic.getName());
        tvText.setText(topic.getText());
        int ImageID = getMipmapResIdByName(topic.getImage());
        tvAvatar.setImageResource(ImageID);
        return convertView;
    }
    public int getMipmapResIdByName(String resName) {
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        return resID;
    }
}
