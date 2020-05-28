package com.example.listview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity  {
    LinkedList<Map<String,Object>> listItems = new LinkedList<>();
    public ListView listView;
    public String[] from = {"鹽酥雞","地瓜薯條","雞排","肉絲炒飯", "蝦仁炒飯", "牛肉炒麵"};   //項目
    public int[]money={50,40,60,60,60,60};
    public int total_money=0;
    public TextView textname;
    public TextView text_money;
    public String msg="";
    public Button btn;
    public int img[] = {R.drawable.food_1, R.drawable.food_2, R.drawable.food_3,R.drawable.food_4,R.drawable.food_5,R.drawable.food_6};  //照片
    public AdapterView.OnItemClickListener onClickListView;
    public TreeMap<String,Integer> hs= new TreeMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textname=findViewById(R.id.textname);
        text_money=findViewById(R.id.textmoney);
        listView = findViewById(R.id.listview);
        btn=findViewById(R.id.button);
        initview();

    }

    public void initview() {



        for(int i=0;i<from.length;i++){   //把所有照片and文字放進去listItem
            Map<String,Object> listItem = new HashMap<String,Object>();
            listItem.put("face", img[i]);
            listItem.put("name", from[i]);
            listItems.add(listItem);

        }

         final SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this, listItems,   //調變器
                R.layout.item,new String[]{"face","name"},
                new int[]{R.id.imageView0,R.id.textView0});





        btn.setOnClickListener(new Button.OnClickListener() {     //當按下按鈕即顯示價格
            @Override
            public void onClick(View v) {
                text_money.setText(""+total_money+"元");
            }
        });



        listView.setAdapter(simpleAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {   //listview傾聽器
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int value=position;
                msg=msg+" "+from[position];
                total_money+=money[position];
                textname.setText(msg);

              //  Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();


            }
        });




    }


}
