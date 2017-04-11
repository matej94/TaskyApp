package com.example.matej.tasky;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Matej on 11.4.2017..
 */

public class TaskAdapter extends BaseAdapter {
    private ArrayList<Task> mTasks;
    public TaskAdapter(ArrayList<Task> tasks) { mTasks = tasks; }
    @Override
    public int getCount() { return this.mTasks.size(); }
    @Override
    public Object getItem(int position) { return this.mTasks.get(position); }
    @Override
    public long getItemId(int position) { return position; }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder taskViewHolder;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_task, parent, false);
            taskViewHolder = new ViewHolder(convertView);
            convertView.setTag(taskViewHolder);
        }
        else{
            taskViewHolder = (ViewHolder) convertView.getTag();
        }
        Task task = this.mTasks.get(position);
        taskViewHolder.tvTaskTitle.setText(task.getTitle());
        return convertView;
    }
    public static class ViewHolder {
        public TextView tvTaskTitle;
        public ViewHolder(View bookView) {
            tvTaskTitle = (TextView) bookView.findViewById(R.id.tvTaskTitle);

        }
    }
}

