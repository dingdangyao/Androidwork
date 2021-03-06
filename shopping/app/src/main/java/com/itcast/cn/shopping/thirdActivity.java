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
public class thirdActivity extends Activity {

    private ListView mListView3;
    //需要适配的数据
    private String[] titles = { "桌子", "苹果", "蛋糕", "线衣", "猕猴桃",
            "围巾"};
    private String[] prices = { "3", "3", "3", "3", "10元",
            "28元"};
    //图片集合
    private int[] icons = {R.drawable.table,R.drawable.apple,R.drawable.cake,
            R.drawable.wireclothes,R.drawable.kiwifruit,R.drawable.scarf};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //初始化ListView控件
        mListView3 = (ListView) findViewById(R.id.lv3);


        //创建一个Adapter的实例
        MyBaseAdapter mAdapter = new MyBaseAdapter();
        //设置Adapter
        mListView3.setAdapter(mAdapter);
        mListView3.setOnItemClickListener(plist);

    }

    private AdapterView.OnItemClickListener plist=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Intent intent = new Intent(thirdActivity.this, demos[position].demoClass);
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
            new DemoInfo(thirdfirstActivity.class),
            new DemoInfo(thirdsecondActivity.class),
            new DemoInfo(thirdthirdActivity.class),
            new DemoInfo(thirdfourthActivity.class),
            new DemoInfo(thirdfifthActivity.class),

            new DemoInfo(thirdsixthActivity.class)
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
            View view  = View.inflate(thirdActivity.this,
                    R.layout.list_item3, null);
            //找到list_item.xml中创建的TextView
            TextView title = (TextView) view.findViewById(R.id.title3);
            TextView price = (TextView) view.findViewById(R.id.price3);
            ImageView iv = (ImageView) view.findViewById(R.id.iv3);
            title.setText(titles[position]);
            price.setText(prices[position]);
            iv.setBackgroundResource(icons[position]);
            return view;




        }

    }
    static class ViewHolder{
        TextView title3;
        TextView price3;
        ImageView iv3;
    }
}