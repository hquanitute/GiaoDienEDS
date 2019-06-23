package com.test.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.myapplication.R;
import com.test.myapplication.objects.resulttest;

import java.util.List;

public class test extends BaseAdapter {
    private Context context;
    private int layout;
    private List<resulttest> results;

    public test(Context context, int layout, List<resulttest> results) {
        this.context = context;
        this.layout = layout;
        this.results = results;
    }

    @Override
    public int getCount() {
        return results.size();
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
        convertView = LayoutInflater.from(context).inflate(R.layout.rowlist_chart,parent,false);
        ImageView img = convertView.findViewById(R.id.profile_image);
        TextView tvName = convertView.findViewById(R.id.name);
        TextView tvPositon= convertView.findViewById(R.id.position);
        TextView tvYourPoint = convertView.findViewById(R.id.Score);
        //TextView tvEnemyPoint = convertView.findViewById(R.id.enemy_point_row_challenge);

        resulttest result  = results.get(position);
        tvName.setText(result.getEmail());
        // tvText.setText(result.getIdTopic());
        tvPositon.setText(String.valueOf(position+1));
        tvYourPoint.setText(String.valueOf(result.getScore()));
        int ImageID = getMipmapResIdByName(result.getImg());
        img.setImageResource(ImageID);
        return convertView;
    }
    public int getMipmapResIdByName(String resName) {
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        return resID;
    }
}
