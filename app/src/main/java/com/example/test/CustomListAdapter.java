package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

//처음에 빨간줄 나오는 : 상세 정의 안해줘서, 클래스 이름 쪽에 커서 놓고 alt+Enter 후 implement methods에서 전체 ok
public class CustomListAdapter extends BaseAdapter {

    private Context context;
    private List<ListItem> list ;
    public CustomListAdapter(Context context, List<ListItem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() { //우리가 들고 있는 리스트의 개수를 알려준다
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //가장 중요한 부분!!!!!
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){   //뷰가 초기화된 상태인지 아닌지 확인한다. 즉 여기 조건문 안은 초기 상태에서 실행된다
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);   //inflator : 리스트 뷰 안에다가 텍스트뷰, 이미지뷰 하나하나씩 그려주는 역할
            //인플레이터 호출이 끝나면 뷰를 그린다
            view = inflater.inflate(R.layout.list_item_view, viewGroup, false);  //layout 이름 설정한 대로 해줘야 함
        }

        //뷰가 초기화 된 상태, 내용을 설정해 준다(내용을 갈아 끼워준다)
        ImageView thumbnailView = (ImageView) view.findViewById(R.id.thumbnail);
        TextView titleView = (TextView) view.findViewById(R.id.textView);
        TextView contentView = (TextView) view.findViewById(R.id.textView2);

        ListItem item = list.get(i);
        thumbnailView.setImageResource(item.getDrawableRes());
        titleView.setText(item.getTitle());
        contentView.setText(item.getContents());

        return view;    //최종 상태의 view 반환
    }

}
