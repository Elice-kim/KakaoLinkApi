package elice.me.mykakako;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import elice.me.mykakako.com.vingle.framework.wrapper.Data;
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

        Data data = new Data();
        data.setButtonTextApp("앱에서 보기");
        data.setButtonTextWeb("웹에서 보기");
        data.setTitle("디저트 사진");
        data.setText("아메아메");
        data.setImageUrl("");
        data.setWebUrl("https://developers.kakao.com");

        KakaoLink.addKakaoLink(this, data);


    }
}
