package cn.uhei.jike_linearlayout_codeconterller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * 使用代码定义布局文件
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //手动定义个线性布局
    private LinearLayout root;

    //添加一个按钮
    private Button btnClickme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        //初始化线性布局
        root = new LinearLayout(this);
        //垂直方向：垂直
        root.setOrientation(LinearLayout.VERTICAL);
        //设置布局文件是root
        setContentView(root);

        for (int i = 0; i < 5; i++) {
            //初始化一个按钮组件
            btnClickme = new Button(this);
            btnClickme.setText("Remove me");

            //监听器：点击被移除
            btnClickme.setOnClickListener(this);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
           //平均分割父级容器高度
            lp.weight = 1;
            //向视图添加组件
            root.addView(btnClickme,lp);
        }

//        //初始化一个按钮组件
//        btnClickme = new Button(this);
//        btnClickme.setText("clickme");

        /**
         * 添加布局对象的几种方法
         */

        //1 root添加一个子对象,默认大小
//        root.addView(btnClickme);

        //2  root添加一个子对象,直接设置宽高
//        root.addView(btnClickme,300,200);

        //3 root添加一个子对象,使用布局参数控制
        //arg2: 线性布局>布局参数>match_parent
        //arg3: 线性布局>布局参数>wrap_content
//        root.addView(btnClickme,LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        //4 先定义布局属性再向布局添加组件
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//        root.addView(btnClickme,lp);

    }
    //监听器：点击被移除
    @Override
    public void onClick(View v) {
        root.removeView(v);
    }
}
