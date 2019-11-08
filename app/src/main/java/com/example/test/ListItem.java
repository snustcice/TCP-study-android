package com.example.test;

public class ListItem {

    //lombok : @Getter, @Setter --> 알아서 getter, setter 쓸 수 있게 해줌 심지어 그거도 안 치고 바로 쓸 수 있는 @Data 라는게 있음
    //alt + Enter : 알아서 getter, setter 추가해 주는 기능이 IDE에 있음

    //아이템 리소스 값 담는 변수
    private int drawableRes;

    //옆에 큰 텍스트뷰(타이틀)에 담을 내용
    private String title;

    //작은 텍스트뷰(상세설명)에 담을 내용
    private String contents;

    //이 속성들 가져올 수 있는 getter, setter
    public int getDrawableRes(){
        return this.drawableRes;
    }

    public void setDrawableRes(int drawableRes){
        this.drawableRes = drawableRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
