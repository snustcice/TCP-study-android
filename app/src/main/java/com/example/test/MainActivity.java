package com.example.test;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar; // app/java/res/values/styles.xml에서 import한 것과 동일한 것으로

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity"; //자바에서 상수 만들 때 쓰는 방법, final -- 참조 불가하도록 설정

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //액티비티 실행될 때 한번만 호출됨 e.g. UI 컴포넌트(버튼 등등..)
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Button oneButton = findViewById(R.id.oneButton)은 꼭 이 아래에다가 해야 함, 그렇지 않으면 널 포인터 오류 남.

        Toolbar toolbar = findViewById(R.id.toolbar);   //툴바 불러오기, 툴바는 웬만하면 setContentView 바로 뒤에 만드는 게 좋음
        setSupportActionBar(toolbar);   /*appcomaptactivity 안의 메서드 중 하나로, actionabr로 쓸 대상을 지정하는 것 --> 툴바를 액션 바로 사용할 수 있게 함
                                          이 코드를 치고 난 뒤에는 툴바에 앱 이름 나옴, 즉 액션 바로 사용할 수 있음*/

        /* 액션바 커스터마이즈
        출력 결과는 아이콘이 뜸(나중에 Navigation Drawer 사용할 수 있음) */
        ActionBar actionBar = getSupportActionBar() ;
        actionBar.setIcon(R.drawable.baseline_alarm_on_24) ;    //원하는 아이콘으로도 대체 가능함
        actionBar.setDisplayUseLogoEnabled(true) ;
        actionBar.setDisplayShowHomeEnabled(true) ;

        Button oneButton = findViewById(R.id.oneButton);   //AppCompatActivity 에서 온 findViewById. 오타를 쳤거나 extends로 상속 받지 못하면 빨간색으로 오류 남.
        oneButton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent (MainActivity.this, ListViewActivity.class); //원래 있던 내용 날리고 ListViewActivity 보기 위한 내용으로 변경
                        startActivity(intent);
            }
        });

        Log.v(TAG, "onCreate()");   //onCreate() 안의 내용 수정, 로그 찍는다
    }

    //툴바를 사용하기 위해 추가한 코드
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.renamed, menu);    //renamed.xml이면 R.menu.renaemd로 작성해야 함

        return true;
    }

    //다이얼로그 : 유저 입력을 받도록 유도하는 창(e.g. YES, NO)
    /*
    duplicate branch 오류 왜 나는지 찾아보기
    가설 : swtich 안에 다 return이 true라서?
    실험 : showDialog()를 처음 케이스로 넣었더니 중간 duplicate 쪽 오류 사라짐, 두번째 케이스에 showDialog() 두번 넣어서 전부 다른 행동을 수행하게 하면 오류가 모두 사라짐
    */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_icon:
                showDialog();   //새로 작성한 함수를 호출한다
                return true;
            case R.id.action_settings:
                return true;
            case R.id.action_another:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //새로 작성한 함수
    //import 해줄때 appcompat 포함된 거로 함 --> mainactivity가 appcompat을 상속받아서 똑같은 스타일로 맞춰주기 위함
    private void showDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);    //builder 객체 생성(만들어주는 애), 메서드를 호출해서 원하는 최종 결과를 만들어줌
        builder.setTitle("AlertDialog Title");
        builder.setMessage("AlertDialog Content");
        builder.setPositiveButton("예(긍정적)",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"긍정적인 선택지를 선택했습니다.",Toast.LENGTH_LONG).show();   //예제에선 토스트 메시지 사용했지만 복잡한 행동도 실행 가능함
                    }
                });
        builder.setNegativeButton("아니오(부정적)",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"부정적인 선택지를 선택했습니다.",Toast.LENGTH_LONG).show();
                    }
                });
        builder.show();
    }

    @Override
    protected void onStart() {  //OnCreate에서 UI 만들고 그 다음에 실행 시키고 싶은 내용들 넣음, 주로 OnCreate에서 많이 넣음
        super.onStart();    //AppCompatActivity에서 상속, 부모 내용 먼저 실행하고 실행됨

        Log.v(TAG, "onStart()");   //Onstart() 안의 내용 수정
    }

    @Override
    protected void onResume() { //사용자 입력 처리 가능한 상태(화면에 뜰 때)
        super.onResume();

        Log.v(TAG, "onResume()");   //OnResume() 안의 내용 수정
    }

    @Override
    protected void onPause() {  //액티비티가 포커스 잃으면(다른 앱 가면) 실행
        super.onPause();

        Log.v(TAG, "onPause()");   //OnPause() 안의 내용 수정
    }

    @Override
    protected void onStop() {   //액티비티가 아예 화면 상에 안 보일때 호출
        super.onStop();

        Log.v(TAG, "onStop()");   //OnStop() 안의 내용 수정
    }

    @Override
    protected void onDestroy() {    //메모리 상에 액티비티가 존재하지 않을때 -- 다른 앱 계속 실행시키다 보면 나옴(e.g. 게임)
        super.onDestroy();

        Log.v(TAG, "onDestroy()");   //OnDestroy() 안의 내용 수정
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Change - HELLO WORLD!", Toast.LENGTH_LONG).show(); //Toast, .(도트)연산자는 속성 중 하나(MakeText)를 불러와서 함수를 실행
    }

    //유용한 기능 : Alt+Enter --> 필요한 파일 자동 import
    //유용한 기능 2 : AppCompatActivity 오른쪽 클릭 -> Find usage
    //프로젝트 파일 꼬이면 폴더 안의 Test.iml, .idea 폴더 삭제 후 다시 실행시키면 될 때 있음 (프로젝트 파일 꼬임?)

    /*
    <내용 정리>
    1차시 -- 깃, 토스트 메시지 띄워보기

    2차시 -- 깃, 로그 찍고 액티비티 주기 어떻게 돌아가는지 설명 => 깐깐하게 코드 관리 잘 해야함!(버그 발생 우려)

    3차시 -- Intent Filter, manifest.xml은 앱에 대한 정보 기술 + 퍼미션 지정, 자료형(Primitive, Reference + Wrapper - Integer에서 null 사용)
             동기=await(커피 나올 때까지 계속 기다림)와 비동기(던져넣고 할일 하고 끝나면 다시 받아감), 생성자, 접근제어자, getter & setter
             싱글 톤 패턴, 클래스 상속, super 사용법, 여담으로 오버로딩, 오버라이딩 차이

    4차시 -- 뷰(액티비티랑 다름. 화면에 표시되는 컴포넌트 최소 단위), 버튼, xml(내가 원하는 태그),

    5차시 -- 화변 몇대 몇 비율로 나누기, pedding과 margin의 차이(네모칸 안과 밖에 여백 준다), Layout 중 Linear와 Relative의 차이 -- Linear는 부모 쪽에서, Relative는 자식 쪽에서 위치를 수정해 줘야 함.
             android:orientation 치는 것 까먹지 않도록 주의, 인터페이스(implements 사용) -> 매우 어려움(어떤 동물이 오든지 eatinterface로 다룰 수 있음), 좀 더 찾아봐야 함
             constraintLayout은 무엇인가(단순한 계층 구조 <-> LinearLayout 3단 계층 구조)
    6차시 -- 가이드라인(쓸모없는 마진값들 없는지 확인해 줘야 함) -- 동적으로 계산해 줌(휴대폰 따라 알아서 조정) Constraint Layout 마무리
             ListView(해당 아이템 목록을 보여주는 뷰), Log.v는 Verbose(모든 로그 출력)일 때 출력, . 뒤에 영어 따라서 다른 로그 찍을 수 있음(e.g. Log.d -- debug)
             id 뒤에 초록색 밑줄로 나오는 것도 있음(잘못 친거 아닌지 확인), adapter(어댑터), Listview는 미리 뷰를 만들어 놓고 갈아 끼우는 위치만 바꾸고 데이터 바꿈(재사용!)

    7차시 -- Adapter(자원을 효율적으로 쓰기 위함, 뷰 객체 새로 만들지 않고 글자만 바꾸는 게 효율적임) << CustomAdapter(글자, 사진과 같이 복잡한 리스트뷰를 쓰기 위해서)

    8차시 -- ActionBar(Toolbar, AppBar) + Menu , build tool(ex. maven, gradle, ...)
     */
}