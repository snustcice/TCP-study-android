package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {    //implements 사용하면 listview.setOnItemClickListener(this);를 사용할 수 있음

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        List<String> datas = new ArrayList<>();   // cf) python : fas.add , 그러나 자바는 List가 뭘 들고 있는지 알려줘야 함(Generic, 제네릭) --> 뒤 <> 안의 String은 생략 가능, List가 가장 상위 객체

        datas.add("1");
        datas.add("2");
        datas.add("3");
        datas.add("4");
        datas.add("5");
        datas.add("6");
        datas.add("7");
        datas.add("8");
        datas.add("9");
        datas.add("10");    //add 10 datas
        datas.add("11");
        datas.add("12");
        datas.add("13");
        datas.add("14");
        datas.add("15");    //add 5 more datas to scroll
        datas.add("Now you find last data in datas!");

        ListView listview =  findViewById(R.id.listview);                                                                        // ListView : Class(uppercase letter), listview : Variable(lowercase letter)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, datas); /*
                                                                                                                                 ArrayAdapter<String>에서 <String> 써야함. this는 ListViewActivity.this와 같음
                                                                                                                                 simple_expandable_list_item_1 -- OS에서 제공해 주는 기본 레이아웃
                                                                                                                                 datas -- 우리가 추가한 리스트
                                                                                                                                  */
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);                      //listView 안의 각 아이템에 대해서 이벤트 만들어 주기 위한 코드들 -- implements 쓰면 OnCreate() 쪽으로 잘라서 넣어야 함
    }
    @Override   //여기로!
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String text = (String) adapterView.getItemAtPosition(i);        //AdapterView에서 찾아서 토스트 메시지로 표시
        Toast.makeText(ListViewActivity.this, text, Toast.LENGTH_SHORT).show();         // 실행 결과 -- 숫자 누르면 숫자가, 문자열 누르면 문자열이 토스트 메시지로 출력됨
        // 인덱싱을 띄우고 싶으면 text 대신 다른 걸 넣으면 됨
    }
}
