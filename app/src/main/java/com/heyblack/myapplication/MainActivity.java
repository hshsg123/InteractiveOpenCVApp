package com.heyblack.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private DrawView Draw1 = null;//画板视图
    private Button btn1 = null;
    private Button btn2 = null;
    private Button btn3 = null;
    private Button btn4 = null;
    private Button btn5 = null;
    private ImageView underView = null;
    public Bitmap bitmap=BitmapFactory.decodeStream(getClass().getResourceAsStream("/res/drawable/l729.jpg"));

    ImageView img;
    String path;
    String filepath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        underView = findViewById(R.id.imageView);


        //图版初始化、设置等操作
        inite();





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void inite(){
        Draw1=(DrawView)findViewById(R.id.writting);


        btn1 = (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                img = (ImageView) findViewById(R.id.imageView1);
                img.setImageBitmap(bitmap);
                underView.setImageBitmap(bitmap);
                Draw1.bringToFront();
                Draw1.rawImg = bitmap;
                Draw1.imageView = img;

                //getPhoto();
            }
        });
        btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Draw1.changeSta(2);
            }
        });



        btn3 = (Button)findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Draw1.changeSta(2);
            }
        });
        btn4 = (Button)findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Draw1.changeSta(0);
            }
        });
        btn5 = (Button)findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

            }
        });
    }

    private  void getPhoto(){
        img = (ImageView) findViewById(R.id.imageView1);
        File sd = Environment.getExternalStorageDirectory();
        path = sd.getPath();//获得手机内存storage的位置
        filepath = path + "/Pictures/Screenshots/S90606-180018.JPG";//storage下需要全屏显示的图片路径（要根据自己手机中需要显示图片路径位置进行修改）
        File file = new File(filepath);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<"+filepath);
        if (file.exists()) {
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<4");
            Bitmap bm = BitmapFactory.decodeFile(filepath);//获得设置路径下图片并编码为Bitmap格式

            System.out.println("<<<<<<<<<<<<<<<<<5");
            img.setImageBitmap(bm);//设置图片为背景图
        }
        else {
            System.err.println("<<<<<<<<<<<<<404 Not Find");//控制台输出没找到图片
        }
    }


}
