package elice.me.mykakako;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import elice.me.mykakako.com.vingle.framework.wrapper.KakaoLink;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.shareBtn)
    Button shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.shareBtn)
    void shareBtnClicked(){

        KakaoLink.addKakaoLink(this, "디저트사진",
                "http://mud-kage.kakao.co.kr/dn/NTmhS/btqfEUdFAUf/FjKzkZsnoeE4o19klTOVI1/openlink_640x640s.jpg"
        , "https://developers.kakao.com", "아메리카노, 빵, 케익",
                "웹에서 보기", "앱에서 보기" ,10 , 20, 30, 40);
    }
}
