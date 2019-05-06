package com.test.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.test.myapplication.R;
import com.test.myapplication.objects.Result;
import com.test.myapplication.objects.Topic;

import java.util.List;

public class ChallengeAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Result> results;

    public ChallengeAdapter(Context context, int layout, List<Result> results) {
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);
        TextView tvName = convertView.findViewById(R.id.name_row_challenge);
        TextView tvText= convertView.findViewById(R.id.text_row_challenge);
        TextView tvYourPoint = convertView.findViewById(R.id.your_point_row_challenge);
        //TextView tvEnemyPoint = convertView.findViewById(R.id.enemy_point_row_challenge);

        Result result = results.get(position);
        tvName.setText(result.getIdEnemy());
        tvText.setText(result.getIdTopic());
        if(result.getIdUser().equals("hung@gmail.com")){
            tvYourPoint.setText("Hung "+result.getPointUser()+" - "+result.getPointEnemy()+" Quan");
        }

        return convertView;
    }
}
