package com.haoyd.learn;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listView;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.rv_main);
        listView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter(this);
        listView.setAdapter(adapter);
    }
}

class MainAdapter extends RecyclerView.Adapter<MyHolder> {

    private Context context;
    private List<PageModel> list = new ArrayList<>();
    private Drawable itemBg;

    public MainAdapter(Context context) {
        this.context = context;
        initData();
        itemBg = context.getResources().getDrawable(R.drawable.bg_white_bottom_gray);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setBackground(itemBg);
        textView.setPadding(30, 40, 30, 40);
        return new MyHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.bindData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private void initData() {
        list.add(new PageModel("测试页面", MainActivity.class));
    }
}

class MyHolder extends RecyclerView.ViewHolder {

    TextView textView;

    public MyHolder(@NonNull View itemView) {
        super(itemView);
        textView = (TextView) itemView;
    }

    public void bindData(final PageModel pageModel) {

        textView.setText(pageModel.desc);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), pageModel.cls);
                itemView.getContext().startActivity(intent);
            }
        });
    }
}

class PageModel {

    public String desc;
    public Class<?> cls;

    public PageModel(String desc, Class<?> cls) {
        this.desc = desc;
        this.cls = cls;
    }
}
