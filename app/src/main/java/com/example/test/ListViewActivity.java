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

        List<ListItem> datas = new ArrayList<>();   // cf) python : fas.add , 그러나 자바는 List가 뭘 들고 있는지 알려줘야 함(Generic, 제네릭) --> 뒤 <> 안의 String은 생략 가능, List가 가장 상위 객체

        //새로 추가한 값들
        ListItem item1 = new ListItem();
        item1.setDrawableRes(R.drawable.baseline_alarm_24);
        item1.setTitle("알람");
        item1.setContents("알람 모양의 .xml 파일입니다.");
        datas.add(item1);

        ListItem item2 = new ListItem();
        item2.setDrawableRes(R.drawable.baseline_alarm_add_24);
        item2.setTitle("알람 더하기");
        item2.setContents("알람 더하기 모양의 .xml 파일입니다.");
        datas.add(item2);

        ListItem item3 = new ListItem();
        item3.setDrawableRes(R.drawable.baseline_alarm_off_24);
        item3.setTitle("알람 끄기");
        item3.setContents("알람 끄기 모양의 .xml 파일입니다.");
        datas.add(item3);

        ListItem item4 = new ListItem();
        item4.setDrawableRes(R.drawable.baseline_alarm_on_24);
        item4.setTitle("알람 켜기");
        item4.setContents("알람 켜기 모양의 .xml 파일입니다.");
        datas.add(item4);

        //어댑터, 레이아웃까지 다 짜야 우리가 원하는 대로 화면 상에 출력 가능

        ListView listview =  findViewById(R.id.listview);                                                                        // ListView : Class(uppercase letter), listview : Variable(lowercase letter)

        CustomListAdapter adapter = new CustomListAdapter(ListViewActivity.this, datas);    //inflaotr 사용하기 위해서!!!(system service) activity도 context 중 하나
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);                      //listView 안의 각 아이템에 대해서 이벤트 만들어 주기 위한 코드들 -- implements 쓰면 OnCreate() 쪽으로 잘라서 넣어야 함
                                                                    //갈아 끼우는 애가 어댑터(자원 관리)
                                                                    //이미지 넣는 것처럼 복잡한 것 하려면 custom adapter 사용해야 함
    }
    @Override   //여기로!
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String text = (String) adapterView.getItemAtPosition(i);        //AdapterView에서 찾아서 토스트 메시지로 표시
        Toast.makeText(ListViewActivity.this, text, Toast.LENGTH_SHORT).show();         // 실행 결과 -- 숫자 누르면 숫자가, 문자열 누르면 문자열이 토스트 메시지로 출력됨
        // 인덱싱을 띄우고 싶으면 text 대신 다른 걸 넣으면 됨
    }
}
