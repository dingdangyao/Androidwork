package com.itcast.cn.shopping;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
public class MainActivity extends Activity {

    private ListView mListView;
    //需要适配的数据
    private String[] titles = { "衣物", "书本", "食物", "娱乐"
           };

    //图片集合
    private int[] icons = {R.drawable.cloth,R.drawable.furniture,R.drawable.food,
            R.drawable.music,R.drawable.kiwifruit,R.drawable.scarf};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化ListView控件
        mListView = (ListView) findViewById(R.id.lv);


        //创建一个Adapter的实例
        MyBaseAdapter mAdapter = new MyBaseAdapter();
        //设置Adapter
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(plist);

    }

    private AdapterView.OnItemClickListener plist=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Intent intent = new Intent(MainActivity.this, demos[position].demoClass);
            startActivity(intent);
        }
    };
        //把每个activity转成class
        private static final class DemoInfo {
            private final Class<? extends android.app.Activity> demoClass;

            public DemoInfo(Class<? extends android.app.Activity> demoClass) {
                this.demoClass = demoClass;
            }
        }

        //把每个activity转成xxx.class
        private static final DemoInfo[] demos = {
                new DemoInfo(firstActivity.class),
                new DemoInfo(secondActivity.class),
                new DemoInfo(thirdActivity.class),
                new DemoInfo(fourthActivity.class),

        };






    //创建一个类继承BaseAdapter
    class MyBaseAdapter extends BaseAdapter {
        //得到item的总数
        @Override
        public int getCount() {
            //返回ListView Item条目的总数
            return titles.length;
        }
        //得到Item代表的对象
        @Override
        public Object getItem(int position) {
            //返回ListView Item条目代表的对象
            return titles[position];
        }
        //得到Item的id
        @Override
        public long getItemId(int position) {
            //返回ListView Item的id
            return position;
        }


        //得到Item的View视图
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //将list_item.xml文件找出来并转换成View对象
            View view  = View.inflate(MainActivity.this,
                    R.layout.list_item, null);
            //找到list_item.xml中创建的TextView
            TextView title = (TextView) view.findViewById(R.id.title);

            ImageView iv = (ImageView) view.findViewById(R.id.iv);
            title.setText(titles[position]);

            iv.setBackgroundResource(icons[position]);
            return view;



        }

    }
    static class ViewHolder{
        TextView title;

        ImageView iv;
    }
}

